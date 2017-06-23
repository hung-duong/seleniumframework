package com.framework.driver;

import com.framework.browserfactory.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

/**
 * Created by hungduong on 6/17/17.
 */
public class WebUIDriver {
    private static ThreadLocal<WebDriver> driverSession = new ThreadLocal<WebDriver>();
    private static ThreadLocal<WebUIDriver> uxDriverSession = new ThreadLocal<WebUIDriver>();
    private DriverConfig config = new DriverConfig();
    private WebDriver driver;
    private IWebDriverFactory webDriverBuilder;

    public static void cleanUp() {
        IWebDriverFactory iWebDriverFactory = getWebUIDriver().webDriverBuilder;
        if (iWebDriverFactory != null) {
            iWebDriverFactory.cleanUp();
        } else {
            WebDriver driver = driverSession.get();
            if (driver != null) {
                try {
                    driver.quit();
                } catch (WebDriverException ex) {
                    ex.printStackTrace();
                }

                driver = null;
            }
        }

        driverSession.remove();
        uxDriverSession.remove();
    }

    public static WebDriver getWebDriver() {
        return getWebDriver(false);
    }

    public static WebDriver getWebDriver(final Boolean isCreate) {
        if (driverSession.get() == null && isCreate) {
            try {
                getWebUIDriver().createWebDriver();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return driverSession.get();
    }

    public static WebUIDriver getWebUIDriver() {
        if (uxDriverSession.get() == null) {
            uxDriverSession.set(new WebUIDriver());
        }

        return uxDriverSession.get();
    }

    public WebDriver createWebDriver() throws Exception {
        driver = createRemoteWebDriver(config.getBrowser().getBrowserType(), config.getMode().name());
        driverSession.set(driver);
        return driver;
    }

    public WebDriver createRemoteWebDriver(final String browser, final String mode) throws Exception {
        WebDriver driver = null;
        config.setBrowser(BrowserType.getBrowserType(browser));
        config.setMode(DriverMode.valueOf(mode));

        if (config.getMode() == DriverMode.ExistingGrid) {
            //webDriverBuilder = new RemoteDriverFactory(this.config);
        } else {
            if (config.getBrowser() == BrowserType.FireFox) {
                webDriverBuilder = new FirefoxDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.InternetExplore) {
                webDriverBuilder = new IEDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.Chrome) {
                webDriverBuilder = new ChromeDriverFactory(this.config);
            } else if (config.getBrowser() == BrowserType.Safari) {
                webDriverBuilder = new SafariDriverFactory(this.config);
            } else {
                throw new RuntimeException("Unsupported browser: " + browser);
            }
        }

        synchronized (this.getClass()) {
            driver = webDriverBuilder.createWebDriver();
        }

        return driver;
    }

    public DriverConfig getConfig() {
        return config;
    }

    public void setConfig(final DriverConfig config) {
        this.config = config;
    }
}
