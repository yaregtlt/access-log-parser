
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserAgent {
    private final String osType;
    private final String browser;

    public UserAgent(String userAgentString) {
//        Pattern osPattern = Pattern.compile("(?i)(Windows|Mac OS|Linux)");
//        Matcher osMatcher = osPattern.matcher(userAgentString);
//        if (osMatcher.find()) {
//            this.osType = osMatcher.group();
//        } else {
//            this.osType = "Unknown";
//        }
//        this.browser = browser;
        this.osType =
    }

    private static final UserAgentAnalyzer userAgentAnalyzer = UserAgentAnalyzer.newBuilder()
            .withCache(1000) // Optional: configure cache size
            .withField("AgentName")
            .withField("OperatingSystemName")
            .build();

}
