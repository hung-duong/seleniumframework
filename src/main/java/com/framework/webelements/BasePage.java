package com.framework.webelements;

import com.framework.driver.WebUIDriver;
import org.openqa.selenium.WebDriver;

/**
 * Created by hungduong
 */
public abstract class BasePage {
    protected WebDriver driver = WebUIDriver.getWebDriver();
    protected final WebUIDriver webUXDriver = WebUIDriver.getWebUIDriver();

    //Contain the assert methods
}
