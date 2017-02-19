package Tests;

import Pages.MailruPage;
import Pages.OlxHomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by BDSM on 16.02.2017.
 */
public class OlxHomeTest {
    OlxHomePage olxHome = page(OlxHomePage.class);

    @DataProvider(name = "credentials")
    public static Object[][] values() {
        return new Object[][]{{"велосипед", "45"}};
    }

    @Test(dataProvider = "credentials")
    public void searchByProductName (final String name, final String count) {
        olxHome.openOlxHomePage();
        olxHome.typeSearchWord(name);
        olxHome.submitSearch();
        olxHome.chekOffersCount(count);
    }

}
