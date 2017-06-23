package com.framework.browserfactory;

import com.framework.driver.BrowserType;
import com.framework.driver.DriverConfig;
import com.framework.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by hungduong
 */
public class IEDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {
    public IEDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    @Override
    public WebDriver createWebDriver() throws Exception {
        DriverConfig cfg = this.getWebDriverConfig();

        System.setProperty("webdriver.ie.driver", ConfigReader.getBrowserPath(BrowserType.InternetExplore));
        driver = new InternetExplorerDriver();

        // Implicit Waits to handle dynamic element. The default value is 5 seconds.
        setImplicitWaitTimeout(cfg.getImplicitWaitTimeout());
        if (cfg.getPageLoadTimeout() >= 0) {
            setPageLoadTimeout(cfg.getPageLoadTimeout());
        }

        this.setWebDriver(driver);

        return driver;
    }

    protected void setPageLoadTimeout(final long timeout) {
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }
}
