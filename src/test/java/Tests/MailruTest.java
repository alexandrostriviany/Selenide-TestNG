package Tests;

import Pages.MailruPage;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by BDSM on 16.02.2017.
 */
public class MailruTest {
    MailruPage mailRuSelenide = page(MailruPage.class);

    @DataProvider(name = "credentials")
    public static Object[][] values() {
        return new Object[][]{{"Vangog-007", "51508", "7132"}};
    }

    @Test(dataProvider = "credentials")
    public void userCanLoginByUsername(final String name, final String password, final String count) {
        mailRuSelenide.openMailRuHomePage();
        mailRuSelenide.enterName(name);
        mailRuSelenide.enterPassword(password);
        mailRuSelenide.setRememberMeCheckBox(false);
        mailRuSelenide.pressEnter();
        mailRuSelenide.checkMailCount(count);
    }

}
