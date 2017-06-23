package com.framework.driver;

public enum BrowserType {
    FireFox("*firefox"),
    InternetExplore("*iexplore"),
    Chrome("*chrome"),
    HtmlUnit("*htmlunit"),
    Safari("*safari");

    private String browserType;

    BrowserType(final String type) {
        this.browserType = type;
    }

    public static BrowserType getBrowserType(final String browserType) {
        if (browserType.equalsIgnoreCase("*firefox") || browserType.equalsIgnoreCase("firefox")) {
            return BrowserType.FireFox;
        } else if (browserType.equalsIgnoreCase("*iexplore") || browserType.equalsIgnoreCase("iexplore")) {
            return BrowserType.InternetExplore;
        } else if (browserType.equalsIgnoreCase("*chrome") || browserType.equalsIgnoreCase("chrome")) {
            return BrowserType.Chrome;
        } else if (browserType.equalsIgnoreCase("*htmlunit") || browserType.equalsIgnoreCase("htmlunit")) {
            return BrowserType.HtmlUnit;
        } else if (browserType.equalsIgnoreCase("*safari") || browserType.equalsIgnoreCase("safari")) {
            return BrowserType.Safari;
        } else {
            return BrowserType.FireFox;
        }
    }

    public String getBrowserType() {
        return this.browserType;
    }
}
