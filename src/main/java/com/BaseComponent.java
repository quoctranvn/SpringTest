package com;

import org.openqa.selenium.WebElement;

public abstract class BaseComponent {
    private Object parentElement;

    public void setParentElement(WebElement parentElement) {
        this.parentElement = parentElement;
    }

    public WebElement getParentElement() {
        return (WebElement) parentElement;
    }
}
