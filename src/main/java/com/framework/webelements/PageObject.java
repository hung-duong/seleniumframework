package com.framework.webelements;

import com.framework.driver.WebUIDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by hungduong
 */
public class PageObject extends BasePage implements IPage{
    //Element to identify the page
    private HtmlElement pageIdentifierElement = null;
    private String title = null;
    private String url = null;

    public PageObject() throws Exception {
        this(null, null);
    }

    public PageObject(final HtmlElement pageIdentifierElement) throws Exception {
        this(pageIdentifierElement, null);
    }

    public PageObject(final HtmlElement pageIdentifierElement, final String url) throws Exception {
        this.pageIdentifierElement = pageIdentifierElement;
        driver = WebUIDriver.getWebDriver();

        if (url != null) {
            open(url);
        }
    }

    private void open(final String url) throws Exception {
        if (this.getDriver() == null) {
            driver = webUXDriver.createWebDriver();
        }

        setUrl(url);
        driver.navigate().to(url);
    }

    public WebDriver getDriver() {
        driver = WebUIDriver.getWebDriver();

        return driver;
    }

    protected void setUrl(final String openUrl) {
        this.url = openUrl;
    }

    public String getUrl() {
        return url;
    }

    public String getLocation() {
        return driver.getCurrentUrl();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void waitForPageToLoad() {
        ExpectedCondition<Boolean> expection = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };

        Wait<WebDriver> wait = new WebDriverWait(driver, 30);
        try {
            wait.until(expection);
        } catch(Throwable error) {
            error.printStackTrace();
        }

    }
}
