package com.config;

import com.core.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class CoreConfig {
    @Autowired
    private WebDriverFactory webDriverFactory;

    @Bean
    @Scope("cucumber-glue")
    public WebDriver webDriver() {
        return webDriverFactory.getWebDriver();
    }

    @Bean
    public PageObjectPostProcessor pageObjectPostProcessor(@Autowired ApplicationContext appContext) {
        return new PageObjectPostProcessor(appContext);
    }
}
