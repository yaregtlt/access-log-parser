package ru.study;

import nl.basjes.parse.useragent.UserAgentAnalyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgent {
    private String osType = "";
    private String browser = "";
    private boolean isYandexBot;
    private boolean isGooglebot;
    private boolean isBot;

    public UserAgent(String userAgentString) {
        Pattern browserPattern = Pattern.compile("(?i)(Edge|Firefox|Chrome|Opera)");
        String os;
        String browser;
        UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer.newBuilder().withCache(1000).build();
        nl.basjes.parse.useragent.UserAgent.ImmutableUserAgent userAgent = userAgentAnalyzer.parse(userAgentString);
        os = userAgent.getValue("OperatingSystemName");
        browser = userAgent.getValue("AgentName");
        Matcher browserMatcher = browserPattern.matcher(browser);
        if (!browser.equals("Hacker") & browserMatcher.find()) this.browser = browser;
        if (!os.equals("Hacker")) this.osType = os;
        this.isGooglebot = userAgentString.toLowerCase().contains("googlebot");
        this.isYandexBot = userAgentString.toLowerCase().contains("yandexbot");
        this.isBot = userAgentString.toLowerCase().contains("bot");
    }

    public boolean isBot() {
        return this.isBot;
    }
    public boolean isYandexBot() {
        return isYandexBot;
    }
    public boolean isGooglebot() {
        return isGooglebot;
    }

    public String getOsType() {
        return osType;
    }

    public String getBrowser() {
        return browser;
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "osType='" + osType + '\'' +
                ", browser='" + browser + '\'' +
                '}';
    }
}
