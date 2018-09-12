package com.hooks;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.TimeUnit;

public class CustomHook {
    @Autowired
    private WebDriver webDriver;

    @Before
    public void beforeScenario(){
        System.out.println("***** - Before Scenario");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("http://automationpractice.com/index.php");
    }

    @After
    public void afterScenario(){
        System.out.println("***** - After Scenario");
        webDriver.close();
        webDriver.quit();
    }

}
