package task.Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.concurrent.TimeUnit;


public class DriverSettings {

    public WebDriverWait wait;
    public WebDriver driver;

    @BeforeTest
    public void Starting() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromeDriver"));
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Long.parseLong(ConfProperties.getProperty("durationTimeout")));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfProperties.getProperty("durationTimeout")), TimeUnit.SECONDS);
    }

    @AfterTest
    public void end() {
        driver.quit();
    }
}
