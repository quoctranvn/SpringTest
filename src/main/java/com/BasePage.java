package com;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePage  {
    @Autowired
    protected WebDriver webDriver;

}
