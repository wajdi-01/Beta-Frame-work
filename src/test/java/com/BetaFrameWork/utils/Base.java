package com.BetaFrameWork.utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;


public class Base {

    public static WebDriver driver;


    public WebDriver lunchBrowser() {

            // Récupérez la valeur de la propriété "browser" depuis la ligne de commande
        String browser = System.getProperty("browser", "CHROME");
        switch (browser) {
            case "CHROME" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                driver = new ChromeDriver(options);
            }
            case "FIREFOX" -> {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                driver = new FirefoxDriver(options);
            }
            case "EDGE" -> {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless");
                driver = new EdgeDriver(options);

            }
            default -> {
                throw new RuntimeException("Browser is not supported");
            }
        }

            driver.manage().window().maximize();
            //driver.get("url");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            return driver;
        }

}
