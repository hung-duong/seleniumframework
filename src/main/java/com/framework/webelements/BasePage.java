package com.framework.webelements;

import com.framework.driver.WebUIDriver;
import org.openqa.selenium.WebDriver;

/**
 * Created by hungduong
 */
public abstract class BasePage {
    protected final WebUIDriver webUXDriver = WebUIDriver.getWebUIDriver();
    protected WebDriver driver = WebUIDriver.getWebDriver();

    //Contain the assert methods
}
