package com.stepdefs;

import com.AppConfig;
import com.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = AppConfig.class)
@SpringBootTest
public class BaseStepDefs {
    @Autowired
    protected WebDriver webDriver;

    @Autowired
    protected LoginPage loginPage;
}
