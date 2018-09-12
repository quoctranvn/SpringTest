package com;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        glue = {"com.stepdefs", "com.hooks"},
        plugin = { "pretty", "html:target/cucumber-html-reports"}
)

public class TestRunner {
    @BeforeClass
    public static void beforeSuite() { System.out.println("***** - Before Suite"); }

    @AfterClass
    public static void afterSuite() {
        System.out.println("***** - After Suite");
    }
}
