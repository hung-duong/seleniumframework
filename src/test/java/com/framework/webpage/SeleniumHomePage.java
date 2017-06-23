package com.framework.webpage;

import com.framework.webelements.LinkElement;
import com.framework.webelements.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by hungduong on 5/27/17.
 */
public class SeleniumHomePage extends PageObject{

    private static final LinkElement downloadLink = new LinkElement("Download", By.linkText("Download"));
    private static final LinkElement homeLinke = new LinkElement("", By.linkText("Browser Automation"));

    public SeleniumHomePage() throws Exception{
        super(homeLinke);
    }

    public void ClickDownload() {
        downloadLink.click();
    }

    public void NavigateHome() {
        homeLinke.click();
    }
}
