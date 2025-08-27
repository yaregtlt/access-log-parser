package ru.study;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogEntry {
    private final String ipAddr;
    private final LocalDateTime time;
    private final HttpMethod method;
    private final String path;
    private final int responseCode;
    private final int responseSize;
    private final String referer;
    private final UserAgent agent;

    public LogEntry(String logLine) {
        String[] stringsSpace = logLine.split(" ");
        String[] stringsQuotes = logLine.split("\"");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss", Locale.US);
        this.ipAddr = stringsSpace[0];
        this.time = LocalDateTime.parse(stringsSpace[3].replace("[",""), formatter);
        this.method = HttpMethod.valueOf(stringsSpace[5].replace("\"",""));
        this.path = stringsSpace[6];
        this.responseCode = Integer.parseInt(stringsSpace[8]);
        this.responseSize = Integer.parseInt(stringsSpace[9]);
        this.referer = stringsSpace[10].replace("[","").replace("]","");
        this.agent = new UserAgent(stringsQuotes[5]);
    }

    public String getIpAddr() {return ipAddr;}
    public LocalDateTime getTime() {return time;}
    public HttpMethod getMethod() {return method;}
    public String getPath() {return path;}
    public int getResponseCode() {return responseCode;}
    public int getResponseSize() {return responseSize;}
    public String getReferer() {return referer;}
    public UserAgent getAgent() {return agent;}

    public boolean isErrorStatusCode() {
        String str = String.valueOf(this.responseCode);
        char firstChar = str.charAt(0);
        return firstChar == '4' || firstChar == '5';
    }



}
