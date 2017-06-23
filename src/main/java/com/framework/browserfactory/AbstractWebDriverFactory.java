package com.framework.browserfactory;

import com.framework.driver.DriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import java.util.concurrent.TimeUnit;

/**
 * Created by hungduong
 */
public abstract class AbstractWebDriverFactory {
    protected DriverConfig webDriverConfig;

    protected WebDriver driver;

    public AbstractWebDriverFactory(final DriverConfig cfg) {
        this.webDriverConfig = cfg;
    }

    public void cleanUp() {
        try {
            if (driver != null) {
                try {
                    driver.quit();
                } catch (WebDriverException ex) {
                    ex.printStackTrace();
                }

                driver = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public WebDriver createWebDriver() throws Exception {
        return null;
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public void setWebDriver(final WebDriver driver) {
        this.driver = driver;
    }

    public DriverConfig getWebDriverConfig() {
        return webDriverConfig;
    }

    public void setWebDriverConfig(final DriverConfig cfg) {
        this.webDriverConfig = cfg;
    }

    public void setImplicitWaitTimeout(final double timeout) {
        if (timeout < 1) {
            driver.manage().timeouts().implicitlyWait((long) (timeout * 1000), TimeUnit.MILLISECONDS);
        } else {
            try {
                driver.manage().timeouts().implicitlyWait(new Double(timeout).intValue(), TimeUnit.SECONDS);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
