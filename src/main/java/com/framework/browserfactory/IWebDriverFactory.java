package com.framework.browserfactory;

import com.framework.driver.DriverConfig;
import org.openqa.selenium.WebDriver;

public interface IWebDriverFactory {
    void cleanUp();

    WebDriver createWebDriver() throws Exception;

    WebDriver getWebDriver();

    DriverConfig getWebDriverConfig();
}
