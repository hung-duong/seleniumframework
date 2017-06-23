package com.framework.driver;

public class DriverConfig {
    private static final int DEFAULT_IMPLICIT_WAIT_TIMEOUT = 5;
    private static final int DEFAULT_EXPLICIT_WAIT_TIME_OUT = 15;
    private static final int DEFAULT_PAGE_LOAD_TIMEOUT = 90;
    private double implicitWaitTimeout = DEFAULT_IMPLICIT_WAIT_TIMEOUT;
    private int explicitWaitTimeout = DEFAULT_EXPLICIT_WAIT_TIME_OUT;
    private int pageLoadTimeout = DEFAULT_PAGE_LOAD_TIMEOUT;


    private BrowserType browser = BrowserType.FireFox;
    private DriverMode mode = DriverMode.LOCAL;
    private String hubUrl;

    public BrowserType getBrowser() {
        return browser;
    }

    public void setBrowser(final BrowserType browser) {
        this.browser = browser;
    }

    public DriverMode getMode() {
        return mode;
    }

    public void setMode(final DriverMode mode) {
        this.mode = mode;
    }

    public double getImplicitWaitTimeout() {
        return implicitWaitTimeout;
    }

    public void setImplicitWaitTimeout(final double implicitWaitTimeout) {
        this.implicitWaitTimeout = implicitWaitTimeout;
    }

    public int getExplicitWaitTimeout() {
        if (explicitWaitTimeout < getImplicitWaitTimeout()) {
            return (int) getImplicitWaitTimeout();
        } else {
            return explicitWaitTimeout;
        }
    }

    public void setExplicitWaitTimeout(final int explicitWaitTimeout) {
        this.explicitWaitTimeout = explicitWaitTimeout;
    }

    public int getPageLoadTimeout() {
        return pageLoadTimeout;
    }

    public void setPageLoadTimeout(final int pageLoadTimeout) {
        this.pageLoadTimeout = pageLoadTimeout;
    }
}
