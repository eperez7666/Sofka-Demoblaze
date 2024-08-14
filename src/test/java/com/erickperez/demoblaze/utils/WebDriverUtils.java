package com.erickperez.demoblaze.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {

    public static WebDriver initializeChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chromedriver.exe");
        return new ChromeDriver();
    }

}
