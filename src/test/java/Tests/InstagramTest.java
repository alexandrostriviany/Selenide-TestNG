package Tests;

import Pages.InstagramFolowPage;
import Pages.InstagramHomePage;
import Pages.InstagrammLoginPage;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by BDSM on 16.02.2017.
 */
public class InstagramTest {

    InstagrammLoginPage instagrammLoginPage = page(InstagrammLoginPage.class);
    InstagramHomePage instagramHomePage = page(InstagramHomePage.class);
    InstagramFolowPage instagramFolowPage = page(InstagramFolowPage.class);

    @DataProvider(name = "credentials")
    public static Object[][] values() {
        return new Object[][]{{"sexy_strange_fox", "Vangog007"}};
    }

    @Test(dataProvider = "credentials")
    public void userCanLoginByUsername(final String name, final String password) {
        instagrammLoginPage.openInstagramHomePageWithCredentials(name,password);
        sleep(1000);
        instagramHomePage.openFirstFollowInTheWall();
        instagramFolowPage.openfollowers();
        sleep(1000);
        instagramFolowPage.addNewFollowers(100);
        Selenide.sleep(5000);
    }

}
