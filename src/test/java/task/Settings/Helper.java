package task.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;

public class Helper {
    public WebDriverWait wait;
    public WebDriver driver;

    public Helper(WebDriver driver) {
        this.driver = driver;
    }
    /**
     * явное ожидание появления элемента
     */
    public void waitVisibilityOfElement(By element) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element));
    }
    /**
     * проверка присутствия элемента на экране
     */
    public void elementDisplayed(By element) {
        waitVisibilityOfElement(element);
        assertTrue(driver.findElement(element).isDisplayed()) ;
    }
}
