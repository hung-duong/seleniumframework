package com.framework.webelements;

import org.openqa.selenium.By;

/**
 * Created by hungduong
 */
public class TextFieldElement extends HtmlElement {
    public TextFieldElement(final String label, final By by) {
        super(label, by);
    }

    public void clear() {
        findElement();
        if (!element.getAttribute("type").equalsIgnoreCase("file")) {
            element.clear();
        }
    }

    public void sendKeys(final String keysToSend) {
        findElement();
        element.sendKeys(keysToSend);
    }

    public void type(final String keysToSend) {
        sendKeys(keysToSend);
    }

    public void clearAndType(final String keysToSend) {
        clear();
        type(keysToSend);
    }
}
