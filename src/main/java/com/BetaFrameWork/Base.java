package com.BetaFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Base {

    public static WebDriver driver;
    public static Properties props = new Properties();

    public Base() {
        try {
            File file = new File("src/test/resources/properities/config.properties");
            FileInputStream fis = new FileInputStream(file);
            props.load(fis);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void lunchBrowser() {

        if (props.getProperty("browser").equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (props.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();


        } else if (props.getProperty("browser").equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }

        driver.manage().window().maximize();
        driver.get(props.getProperty("url"));
        //driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        // driver.manage().deleteAllCookies();
    }
}
