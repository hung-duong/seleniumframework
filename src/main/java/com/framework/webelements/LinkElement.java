package com.framework.webelements;

import org.openqa.selenium.By;

/**
 * Created by hungduong
 */
public class LinkElement extends HtmlElement{
    public LinkElement(final String label, final By by) {
        super(label, by);
    }

    @Override
    public void click() {
        super.click();
    }

    public String getUrl() {
        return super.getAttribute("href");
    }
}
