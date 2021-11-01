package task.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.Settings.Helper;

public class LoginPage extends Helper {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input.Textinput-Control")
    private WebElement login;
    private final By loginLocator = By.xpath("//*[text()='Введите ваш ID']");
    @FindBy(css = "input.Textinput-Control")
    private WebElement password;
    private final By passLocator = By.xpath("//*[text()='Введите пароль']");
    /**
     * логин
     */
    public void loginValue(String loginMail) {
        elementDisplayed(loginLocator);
        login.sendKeys(loginMail, Keys.ENTER);
    }
    /**
     * пароль
     */
    public void passValue(String pass) {
        elementDisplayed(passLocator);
        password.sendKeys(pass, Keys.ENTER);
    }
}
