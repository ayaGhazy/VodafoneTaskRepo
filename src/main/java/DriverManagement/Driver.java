package DriverManagement;

import ExcelUtility.ExcelReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    static ChromeDriver driver;

    Driver() {
    }

    public static WebDriver getInstance() {
        ExcelReader reader = ExcelReader.getInstance();
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe");

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--window-size=1024x768");
            // options.addArguments("enable-automation");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
