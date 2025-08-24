package ru.study;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Statistics {

    private int totalTraffic = 0;
    private LocalDateTime minTime = null;
    private LocalDateTime maxTime = null;

    public Statistics() {}

    public void addEntry(LogEntry entry) {
        this.totalTraffic += entry.getResponseSize();

        if (this.minTime == null || entry.getTime().isBefore(this.minTime)) {
            this.minTime = entry.getTime();
        }

        if (this.maxTime == null || entry.getTime().isAfter(this.maxTime)) {
            this.maxTime = entry.getTime();
        }
    }

    public double getTrafficRate() {
        if (this.minTime == null || this.maxTime == null) return 0.0;

        long hoursDifference = ChronoUnit.HOURS.between(minTime, maxTime);

        if (hoursDifference <= 0) hoursDifference = 1;

        return ((double)this.totalTraffic / hoursDifference);
    }
}
