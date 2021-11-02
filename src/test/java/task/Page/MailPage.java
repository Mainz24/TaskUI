package task.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import task.Settings.Helper;
import java.util.List;
import java.util.Set;

public class MailPage extends Helper {

    private int amountMassageOne;
    public MailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[text()='Simbirsoft theme']")
    private List<WebElement> themeIncoming;
    private final By correctTheme = By.xpath("//*[text()='Входящие']");
    @FindBy(css = "span.mail-ComposeButton-Text")
    private WebElement newMessage;
    private final By write = By.xpath("//span[text()='Написать']");
    @FindBy(xpath = "//div[@class='ComposeRecipients-TopRow'] " +
            "//div[@class='composeYabbles']")
    private WebElement whom;
    private final By newLetter = By.xpath("//span[text()='Новое письмо']");
    @FindBy(css = "input.composeTextField.ComposeSubject-TextField")
    private WebElement themeNew;
    @FindBy(css = "div.cke_wysiwyg_div")
    private WebElement textMail;
    @FindBy(css = "button.Button2.Button2_pin_circle-circle.Button2_view_default")
    private WebElement send;
    @FindBy(xpath = "//*[text()='Вернуться во \"Входящие\"']")
    private WebElement inbox;
    private final By emailSent = By.xpath("//span[text()='Письмо отправлено']");
    @FindBy(css = "span[data-click-action='mailbox.check']")
    private WebElement mailboxCheck;
    /**
     * переход на новую вкладку
     */
        public MailPage switchPage() {
        String window1 = driver.getWindowHandle();
        Set<String> currentWindow = driver.getWindowHandles();
        String window2 = null;
        for (String window : currentWindow) {
            if (!window.equals(window1)) {
                window2 = window;
                break;
            }
        }
        driver.switchTo().window(window2);
        return this;
    }
    /**
     * проверка количества писем с темой Simbirsoft theme
     */
    public MailPage sizeThemeOne(){
        elementDisplayed(correctTheme);
        List<WebElement> theme = themeIncoming;
        amountMassageOne = theme.size();
        return this;
    }
    /**
     * создание нового сообщения
     */
    public MailPage newMail() {
        elementDisplayed(write);
        newMessage.click();
        return this;
    }
    /**
     * кому
     */
    public MailPage whomValue(String loginMail) {
        elementDisplayed(newLetter);
        whom.sendKeys(loginMail);
        return this;
    }
    /**
     * тема
     */
    public MailPage themeValue(String themeMail) {
        themeNew.sendKeys(themeMail);
        return this;
    }
    /**
     * текс письма с количеством входящих писем
     */
    public MailPage textValue() {
        textMail.sendKeys("Найдено " + amountMassageOne + " писем/ьма");
        return this;
    }
    /**
     * отправка сообщения
     */
    public MailPage sendClick() {
        send.click();
        return this;
    }
    /**
     * проверка на то, что письмо отправлено самому себе
     */
    public void sizeThemeTwo() {
        elementDisplayed(emailSent);
        inbox.click();
        int amountMassageTwo;
        do {
            mailboxCheck.click();
            List<WebElement> themeTwo = themeIncoming;
            amountMassageTwo = themeTwo.size();
            Assert.assertEquals(amountMassageTwo, amountMassageOne);
        }
        while(amountMassageTwo != amountMassageOne);
    }
}
