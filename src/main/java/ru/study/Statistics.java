package ru.study;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statistics {
    private int totalTraffic = 0;
    private LocalDateTime minTime = null;
    private LocalDateTime maxTime = null;
    private final HashSet<String> urls200 = new HashSet<>();
    private final HashSet<String> urls404 = new HashSet<>();
    private final HashMap<String, Integer> countOs = new HashMap<>();
    private final HashMap<String, Integer> countBrowser = new HashMap<>();
    private int totalEntries = 0;
    private int totalVisits = 0;
    private int errorRequests = 0;
    private final HashSet<String> uniqueIPs = new HashSet<>();
    private final HashSet<String> refererDomain = new HashSet<>();
    private HashMap<Integer, Integer> visitsPerSecond = new HashMap<>();
    private boolean isNotBot=false;
    private HashMap<String, Integer> maxVisits = new HashMap<>();


    public Statistics() {}

    public void addEntry(LogEntry entry) {
        this.totalTraffic += entry.getResponseSize();
        if (this.minTime == null || entry.getTime().isBefore(this.minTime)) {
            this.minTime = entry.getTime();
        }
        if (this.maxTime == null || entry.getTime().isAfter(this.maxTime)) {
            this.maxTime = entry.getTime();
        }
        if (entry.getResponseCode() == 200) this.urls200.add(entry.getPath());
        if (entry.getResponseCode() == 404) this.urls404.add(entry.getPath());
        this.countOs.put(entry.getAgent().getOsType(), this.countOs.getOrDefault(entry.getAgent().getOsType(), 0) + 1);
        this.countBrowser.put(entry.getAgent().getBrowser(), this.countBrowser.getOrDefault(entry.getAgent().getBrowser(), 0) + 1);
        this.totalEntries++;
        if (!entry.getAgent().isBot()) this.totalVisits ++;
        if (entry.isErrorStatusCode()) this.errorRequests ++;
        this.uniqueIPs.add(entry.getIpAddr());
        this.refererDomain.add(extractDomain(entry.getReferer()));
        if (!entry.getAgent().isBot()) this.isNotBot=true;
        this.visitsPerSecond = addVisitPerSecond(entry);
        this.maxVisits = addUser(entry);
    }

    public static long toSeconds(LocalDateTime time) {
        return time.toEpochSecond(ZoneOffset.UTC);
    }

    private static String extractDomain(String referer) {
        Pattern pattern = Pattern.compile("(https?://)?(www\\.)?(([\\da-z.-]+)\\.([a-z.]{2,6}))([/\\w.-]*)");
        Matcher matcher = pattern.matcher(referer);
        if (matcher.find()) {
            return matcher.group(3); // Группа 3 содержит доменное имя
        }
        return null;
    }

    public double getTrafficRate() {
        if (this.minTime == null || this.maxTime == null) return 0.0;
        long hoursDifference = ChronoUnit.HOURS.between(minTime, maxTime);
        if (hoursDifference <= 0) hoursDifference = 1;
        return ((double)this.totalTraffic / hoursDifference);
    }


    public HashMap<String, Double> getOsStatistics() {
        HashMap<String, Double> statistics = new HashMap<>();
        if (totalEntries == 0) {
            return statistics;
        }
        for (Map.Entry<String, Integer> entry : countOs.entrySet()) {
            String os = entry.getKey();
            int count = entry.getValue();
            double proportion = (double) count / totalEntries;
            statistics.put(os, proportion);
        }
        return statistics;
    }

    public HashMap<String, Double> getBrowserStatistics() {
        HashMap<String, Double> statistics = new HashMap<>();
        if (totalEntries == 0) {
            return statistics;
        }
        for (Map.Entry<String, Integer> entry : countBrowser.entrySet()) {
            String browser = entry.getKey();
            int count = entry.getValue();
            double proportion = (double) count / totalEntries;
            statistics.put(browser, proportion);
        }
        return statistics;
    }

    private long timePeriodHours(){
        if (this.minTime == null || this.maxTime == null) return 0;
        return Duration.between(maxTime, minTime).toHours();
    }

    public HashSet<String> getUrls200() {
        return this.urls200;
    }

    public HashSet<String> getUrls404() {
        return this.urls404;
    }

    public double getAverageRequestsPerHour() {
        long timeRange = timePeriodHours();
        if (timeRange == 0) {
            return totalVisits;
        }
        return (double) totalVisits / timeRange;
    }

    public double getAverageErrorRequestsPerHour() {
        long timeRange = timePeriodHours();
        if (timeRange == 0) {
            return errorRequests;
        }
        return (double) errorRequests / timeRange;
    }

    public double getAverageRequestsPerUser() {
        if (uniqueIPs.isEmpty()) {
            return 0.0;
        }
        return (double) totalVisits / uniqueIPs.size();
    }

    public HashSet<String> getRefererDomain() {
        return this.refererDomain;
    }

    private HashMap<Integer, Integer> addVisitPerSecond(LogEntry request) {
        HashMap<Integer, Integer> visitsPerSecond = new HashMap<>();
        if (this.isNotBot) {
            long second = toSeconds(request.getTime());
            visitsPerSecond.put((int) second, visitsPerSecond.getOrDefault((int) second, 0) + 1);
        }
        return visitsPerSecond;
    }

    public int maxVisitsInOneSecond() {
        return this.visitsPerSecond.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    private HashMap<String, Integer> addUser(LogEntry request) {
        HashMap<String, Integer> uniqueUser = new HashMap<>();
        if (this.isNotBot) {
            uniqueUser.put(request.getIpAddr(), uniqueUser.getOrDefault(request.getIpAddr(), 0) + 1);
        }
        return uniqueUser;
    }

    public int maxUniqueVisits() {
        return this.maxVisits.values().stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

}
