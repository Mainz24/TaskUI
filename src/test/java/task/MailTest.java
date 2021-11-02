package task;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import task.Page.LoginPage;
import task.Page.MailPage;
import task.Page.SearchPage;
import task.Settings.ConfProperties;

public class MailTest {

    public WebDriver driver;
    public SearchPage searchPage;
    public LoginPage loginPage;
    public MailPage mailPage;
    @Test
    public void mailTest() {
        searchPage = new SearchPage(driver);
        loginPage = new LoginPage(driver);
        mailPage = new MailPage(driver);
        driver.get(ConfProperties.getProperty("urlPage"));
        searchPage.openYandex();
        loginPage.loginValue(ConfProperties.getProperty("loginMail"));
        loginPage.passValue(ConfProperties.getProperty("pass"));
        searchPage.clickMail();
        mailPage.switchPage()
                .sizeThemeOne()
                .newMail()
                .whomValue(ConfProperties.getProperty("loginMail"))
                .themeValue(ConfProperties.getProperty("themeMail"))
                .textValue()
                .sendClick()
                .sizeThemeTwo();
    }
}
