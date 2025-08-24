package ru.study;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Statistics {
    private int totalTraffic = 0;
    private LocalDateTime minTime = null;
    private LocalDateTime maxTime = null;
    private final HashSet<String> urls200 = new HashSet<>();
    private final HashSet<String> urls404 = new HashSet<>();
    private HashMap<String, Integer> countOs = new HashMap<>();
    private HashMap<String, Integer> countBrowser = new HashMap<>();
    private int totalEntries = 0;


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

    public double getTrafficRate() {
        if (this.minTime == null || this.maxTime == null) return 0.0;
        long hoursDifference = ChronoUnit.HOURS.between(minTime, maxTime);
        if (hoursDifference <= 0) hoursDifference = 1;
        return ((double)this.totalTraffic / hoursDifference);
    }



}
