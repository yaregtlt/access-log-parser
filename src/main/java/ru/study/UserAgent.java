package ru.study;

import nl.basjes.parse.useragent.UserAgentAnalyzer;

public class UserAgent {
    private String osType = "";
    private String browser = "";

    public UserAgent(String userAgentString) {
        //System.out.println(userAgentString);
        UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer.newBuilder().withCache(1000).build();
        nl.basjes.parse.useragent.UserAgent.ImmutableUserAgent userAgent = userAgentAnalyzer.parse(userAgentString);
        if (!userAgent.getValue("AgentName").equals("Hacker")) {this.browser = userAgent.getValue("AgentName");}
            else this.browser = "No browser defined";
        if (!userAgent.getValue("OperatingSystemName").equals("Hacker")) {this.osType = userAgent.getValue("OperatingSystemName");}
            else this.osType = "No OS defined";
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
