package com.framework.webelements;

import com.framework.driver.WebUIDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Provides methods to interact with a web page. All HTML element (ButtonElement, LinkElement, TextFieldElement, etc.)
 * extends from this class.
 */
public class HtmlElement {
    private enum LocatorType {
        ID, NAME, CLASS_NAME, LINK_TEXT, PARTIAL_LINK_TEXT, CSS_SELECTOR,
        TAG_NAME, XPATH,
    }

    protected WebDriver driver = null;
    protected WebElement element = null;
    private String label = null;
    private String locator = null;
    private By by = null;

    public HtmlElement(final String label, final By by) {
        this.label = label;
        this.by = by;
    }

    public HtmlElement(final String label, final String locator, final LocatorType locatorType) {
        this.label = label;
        this.locator = locator;
        this.by = getLocatorBy(locator, locatorType);
    }

    protected void findElement() {
        driver = WebUIDriver.getWebDriver();
        element = driver.findElement(by);
    }

    public Point getLocation() {
        findElement();

        return element.getLocation();
    }

    public void click() {
        findElement();
        element.click();
    }


    private By getLocatorBy(final String locator, final LocatorType locatorType) {

        switch (locatorType) {

            case ID:
                return By.id(locator);

            case NAME:
                return By.name(locator);

            case CLASS_NAME:
                return By.className(locator);

            case LINK_TEXT:
                return By.linkText(locator);

            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(locator);

            case CSS_SELECTOR:
                return By.cssSelector(locator);

            case TAG_NAME:
                return By.tagName(locator);

            default:
                return By.xpath(locator);
        }
    }

    public boolean isDisplayed() {

        try {
            findElement();

            return element.isDisplayed();
        } catch (final Exception e) {
            return false;
        }
    }

    public boolean isEnabled() {
        findElement();

        return element.isEnabled();
    }

    public void sendKeys(final CharSequence arg0) {
        findElement();
        element.sendKeys(arg0);
    }

    public boolean isSelected() {
        findElement();

        return element.isSelected();
    }

    public String getAttribute(final String name) {
        findElement();

        return element.getAttribute(name);
    }

    public boolean isTextPresent(final String text) {
        findElement();
        return element.getText().contains(text);
    }

    public void waitForPresent(final int timeout) {
        final Wait<WebDriver> wait = new WebDriverWait(driver, timeout);
        wait.until(new ExpectedCondition<WebElement>() {
            public WebElement apply(final WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }
}
