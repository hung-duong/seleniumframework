package com.framework.browserfactory;

import com.framework.driver.DriverConfig;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

/**
 * Created by hungduong
 */
public class SafariDriverFactory extends AbstractWebDriverFactory implements IWebDriverFactory {
    public SafariDriverFactory(final DriverConfig cfg) {
        super(cfg);
    }

    @Override
    public WebDriver createWebDriver() {
        System.out.println("Begin Safari");
        synchronized (this.getClass()) {
            driver = new SafariDriver();
        }

        System.out.println("safari started");

        this.setWebDriver(driver);

        // Implicit Waits handles dynamic element.
        setImplicitWaitTimeout(webDriverConfig.getImplicitWaitTimeout());

        return driver;
    }
}
