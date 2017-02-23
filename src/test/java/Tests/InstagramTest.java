package Tests;

import Pages.InstagramFolowPage;
import Pages.InstagramHomePage;
import Pages.InstagramMyProfilePage;
import Pages.InstagrammLoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by BDSM on 16.02.2017.
 */
public class InstagramTest {

    private InstagrammLoginPage loginPage = page(InstagrammLoginPage.class);

    private InstagramHomePage homePage = page(InstagramHomePage.class);

    private InstagramFolowPage folowPage = page(InstagramFolowPage.class);

    private InstagramMyProfilePage myProfilePage = page(InstagramMyProfilePage.class);

    @DataProvider(name = "credentials")
    public static Object[][] values() {
        return new Object[][]{{"sexy_strange_fox", "Vangog007"}};
    }

    @Test(dataProvider = "credentials")
    public void followSomeBlogs(final String name, final String password) {
        loginPage.openInstagramHomePageWithCredentials(name, password);
        sleep(1000);
        homePage.openFirstFollowInTheWall();
        folowPage.openfollowers();
        sleep(1000);
        folowPage.addNewFollowers(100);
    }

    @Test(dataProvider = "credentials")
    public void unFollowSomeBlogs(final String name, final String password) {
        loginPage.openInstagramHomePageWithCredentials(name, password);
        sleep(1000);
        homePage.openMyProfile();
        myProfilePage.openfollowers();
        sleep(1000);
        myProfilePage.dellNewFollowersFast(20);
    }


}
