package com.core;

import com.utils.FileHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.File;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Configuration
@PropertySource("classpath:driver.properties")
public class WebDriverFactory{
    private static WebDriver webDriver;
    private static WebDriverConfig configs;
    private static String driverVersion = System.getProperty("driverVersion");

    @Value("${browser.type}")
    private String browserName;

    public WebDriverFactory() { }

    public WebDriver getWebDriver() {
        System.out.println("########@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println(browserName);
        if(webDriver == null)
            webDriver = setWebDriver();
        return webDriver;
    }

    private static void configWebDriver() {
        WebDriver.Options options = webDriver.manage();
        //Set element timeout
        options.timeouts().implicitlyWait(configs.elementTimeout, TimeUnit.SECONDS);
        if (!StringUtils.isEmpty(configs.position)) {
            int[] pos = Arrays.stream(configs.position.split(","))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray();
            options.window().setPosition(new Point(pos[0], pos[1]));
        }
        //Set windows dimension
        if (!StringUtils.isEmpty(configs.dimension)) {
            int[] dim = Arrays.stream(configs.dimension.split("x"))
                    .map(String::trim).mapToInt(Integer::parseInt).toArray();
            options.window().setSize(new Dimension(dim[0], dim[1]));
        }
    }

    private WebDriver setWebDriver(){
        //Set directory that contains webdrivers to .\drivers
        String webDriversFolder = "drivers";
        WebDriverManager.config().setTargetPath(webDriversFolder);
        //Set desired version of webdriver
        if(driverVersion != null)
            WebDriverManager.config().setDriverVersion(driverVersion);

        //Initiate new webdriver instance base on browserName
        String browserPath;
        switch(browserName.toLowerCase().trim()) {
            case "ie":
                WebDriverManager.iedriver().setup();
                browserPath = (new FileHelper()).getFilePath("IEDriverServer.exe", new File(webDriversFolder));
                System.setProperty("webdriver.ie.driver", browserPath);
                webDriver = new InternetExplorerDriver((new WebDriverConfig()).setIEOptions());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                browserPath = (new FileHelper()).getFilePath("geckodriver.exe", new File(webDriversFolder));
                System.setProperty("webdriver.firefox.driver", browserPath);
                webDriver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                browserPath = (new FileHelper()).getFilePath("MicrosoftWebDriver.exe", new File(webDriversFolder));
                System.setProperty("webdriver.edge.driver", browserPath);
                webDriver = new EdgeDriver();
                break;
            default:
                WebDriverManager.chromedriver().setup();
                browserPath = (new FileHelper()).getFilePath("chromedriver.exe", new File(webDriversFolder));
                System.setProperty("webdriver.chrome.driver", browserPath);
                webDriver = new ChromeDriver((new WebDriverConfig()).setChromeOptions());
                break;
        }

        configWebDriver();
        return webDriver;
    }
}
