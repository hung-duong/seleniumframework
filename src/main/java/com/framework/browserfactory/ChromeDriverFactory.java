package com.framework.browserfactory;

import com.framework.driver.BrowserType;
import com.framework.driver.DriverConfig;
import com.framework.utilities.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ChromeDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {

    public ChromeDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    @Override
    public WebDriver createWebDriver() throws Exception {
        DriverConfig cfg = this.getWebDriverConfig();

        System.setProperty("webdriver.chrome.driver", ConfigReader.getBrowserPath(BrowserType.Chrome));
        driver = new ChromeDriver();

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
