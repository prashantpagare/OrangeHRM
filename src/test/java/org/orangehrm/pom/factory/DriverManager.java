package org.orangehrm.pom.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.orangehrm.pom.constants.DriverType;

import java.time.Duration;

public class DriverManager {

    public WebDriver initializeDriver(){
       /* WebDriver driver;
        String browser = System.getProperty("browser", "CHROME");
        switch (DriverType.valueOf(browser.toLowerCase())) {
            case CHROME -> {
                WebDriverManager.chromedriver().cachePath("Drivers").setup();
                driver = new ChromeDriver();
            }
            case FIREFOX -> {
                WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
                driver = new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Invalid Browser name" + browser);
        }*/

            WebDriverManager.chromedriver().cachePath("Drivers").setup();
            WebDriver driver = new ChromeDriver();
            /*WebDriverManager.firefoxdriver().cachePath("Drivers").setup();
            WebDriver driver = new FirefoxDriver();*/
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            return driver;
    }

}
