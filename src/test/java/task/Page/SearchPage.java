package task.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import task.Settings.Helper;

public class SearchPage extends Helper {
    public SearchPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Войти']")
    private WebElement openButton;
    private final By openText = By.xpath("//div[text()='Войти']");
    @FindBy(css = "div.desk-notif-card__mail-title")
    private WebElement yandexMail;
    private final By textMail = By.xpath("//div[text()='Почта']");
    /**
     * кнопка войти
     */
    public void openYandex() {
        elementDisplayed(openText);
        openButton.click();
    }
    /**
     * переход на Яндекс почту
     */
    public void clickMail() {
        elementDisplayed(textMail);
        yandexMail.click();
    }
}
