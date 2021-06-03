package Utilities.BrowserUtilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BrowserDataFactory {

    public static WebDriver startApplication(String browserName, String appURL) {
        WebDriver driver = null;
        if (browserName.contains("Chrome") || browserName.contains("CHROME")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        else if (browserName.contains("firefox") || browserName.contains("FIREFOX")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        else if (browserName.contains("Edge") || browserName.contains("EDGE")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        else {
            System.out.println("Check the drivers availability to initiate the browser");
        }

        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appURL);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeBrowser(WebDriver driver) {
        driver.quit();
    }

}
