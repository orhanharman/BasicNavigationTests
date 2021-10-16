package com.cbt.utilities;

import org.apache.commons.lang3.SystemUtils;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    public static WebDriver getDriver(String browserType){

        WebDriver driver = null;
        //can be used for OS type: System.getProperty("os.name");
        //SystemUtils.OS_NAME

        switch(browserType.toLowerCase()){
            case "safari":
                if(SystemUtils.OS_NAME.toLowerCase().contains("windows")) {
                    return null;
                }
                driver = new SafariDriver();
                break;
            case "edge":
                if(SystemUtils.OS_NAME.toLowerCase().contains("mac")){
                    return null;
                }
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        return driver;

    }

}

