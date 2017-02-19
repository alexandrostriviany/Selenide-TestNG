package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by BDSM on 16.02.2017.
 */
public class MailruPage {
    @FindBy(className = "logo__link__img logo__link__img_medium")
    private SelenideElement header;

    @FindBy(how = How.ID, using = "mailbox__login")
    private SelenideElement loginField;

    @FindBy(how = How.ID, using = "mailbox__password")
    private SelenideElement passwordField;

    @FindBy(id = "mailbox__auth__button")
    private SelenideElement enterButton;

    @FindBy(id = "mailbox__auth__remember__checkbox")
    private SelenideElement rememberMeCheckBox;

    @FindBy(className = "b-nav__item__count")
    private SelenideElement mailCount;


    public MailruPage openMailRuHomePage() {
        open("http://mail.ru/");
        return page(MailruPage.class);
    }

    public MailruPage enterName(final String name) {
        loginField.setValue(name);
        return page(MailruPage.class);
    }

    public MailruPage checkMailCount(final String count){
        Assert.assertEquals(mailCount.getText(),count);
        return page(MailruPage.class);
    }

    public void enterPassword(final String pass) {
        passwordField.setValue(pass);
    }

    public void setRememberMeCheckBox(final boolean condition) {
        rememberMeCheckBox.setSelected(condition);
    }

    public void pressEnter() {
        passwordField.pressEnter();
    }
}
