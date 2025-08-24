package ru.study;

import nl.basjes.parse.useragent.UserAgentAnalyzer;
import org.apache.commons.lang3.ObjectUtils;

public class UserAgent {
    private final String osType;
    private final String browser;

    public UserAgent(String userAgentString) {
        //System.out.println(userAgentString);
        UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer.newBuilder().withCache(1000).build();
        nl.basjes.parse.useragent.UserAgent.ImmutableUserAgent userAgent = userAgentAnalyzer.parse(userAgentString);
        this.browser = userAgent.getValue("AgentName");
        this.osType = userAgent.getValue("OperatingSystemName");
    }

    @Override
    public String toString() {
        return "UserAgent{" +
                "osType='" + osType + '\'' +
                ", browser='" + browser + '\'' +
                '}';
    }
}
