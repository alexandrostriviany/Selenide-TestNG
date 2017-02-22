package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by BDSM on 21.02.2017.
 */
public class InstagrammLoginPage {

    @FindBy(how = How.LINK_TEXT, using = "Вход")
    private SelenideElement logInOnHomePage;

    @FindBy(how = How.NAME, using = "username")
    private SelenideElement loginField;

    @FindBy(how = How.NAME, using = "password")
    private SelenideElement passwordField;

    @FindBy(how = How.XPATH, using = ".//*[@id='react-root']//button")
    private SelenideElement loginButton;


    public void openInstagramHomePageWithCredentials(final String name, final String password) {
        open("https://www.instagram.com/");
        scrollToElement(logInOnHomePage);
        logInOnHomePage.click();
        loginField.sendKeys(name);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    private void scrollToElement(SelenideElement element){
        Selenide.executeJavaScript("arguments[0].scrollIntoView();"
                ,element.getWrappedElement());
    }

}
