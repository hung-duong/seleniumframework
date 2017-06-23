package com.framework.webelements;

import com.framework.driver.BrowserType;
import com.framework.driver.WebUIDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Created by hungduong
 */
public class ButtonElement extends HtmlElement {
    public ButtonElement(final String label, final By by) {
        super(label, by);
    }

    @Override
    public void click() {
        BrowserType browser = WebUIDriver.getWebUIDriver().getConfig().getBrowser();
        if (browser == BrowserType.InternetExplore) {
            super.sendKeys(Keys.ENTER);
        } else {
            super.click();
        }
    }

    public void submit() {
        findElement();
        element.submit();
    }
}
