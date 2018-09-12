package com.core;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class WebDriverConfig {
    public static int elementTimeout = 10;
    public static String position = "0,0";
    public static String dimension = "800x600";

    public void setElementTimeout(int elementTimeout) {
        WebDriverConfig.elementTimeout = elementTimeout;
    }

    public void setPosition(String position) {
        WebDriverConfig.position = position;
    }

    public void setDimension(String dimension) {
        WebDriverConfig.dimension = dimension;
    }

    public ChromeOptions setChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-infobars");
//        chromeOptions.addArguments("--start-maximized");
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-extensions");
//        chromeOptions.addArguments("--disable-web-security");
//        chromeOptions.addArguments("--no-proxy-server");
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        prefs.put("credentials_enable_service", false);
//        prefs.put("profile.password_manager_enabled", false);
//        chromeOptions.setExperimentalOption("prefs", prefs);
        return chromeOptions;
    }

    public InternetExplorerOptions setIEOptions() {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.destructivelyEnsureCleanSession();
        return ieOptions;
    }
}
