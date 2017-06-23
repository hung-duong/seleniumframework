package com.framework.webpage;

import com.framework.utilities.ConfigReader;
import com.framework.webelements.ButtonElement;
import com.framework.webelements.LinkElement;
import com.framework.webelements.PageObject;
import com.framework.webelements.TextFieldElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

/**
 * Created by hungduong on 5/27/17.
 */
public class GoogleHomePage extends PageObject {

    private static final TextFieldElement searchTextBox = new TextFieldElement("search Text Box", By.name("q"));
    private static final LinkElement seleniumLink = new LinkElement("Selenium - Web Browser Automation", By.linkText("Selenium - Web Browser Automation"));

    public GoogleHomePage() throws Exception {
        super(searchTextBox, ConfigReader.getApplicationUrl());
    }

    public boolean isSearchBoxDisplayed() {
        return searchTextBox.isDisplayed();
    }

    public void SearchGoogle(String text) {
        searchTextBox.sendKeys("Selenium");
        searchTextBox.sendKeys(Keys.ENTER);
    }

    public void clickSeleniumLink() {
        seleniumLink.click();
    }
}
