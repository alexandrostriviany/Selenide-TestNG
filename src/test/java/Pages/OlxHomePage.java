package Pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by BDSM on 19.02.2017.
 */
public class OlxHomePage {

    @FindBy(id = "headerSearch")
    private SelenideElement searchField;

    @FindBy(id = "submit-searchmain")
    private SelenideElement submitButton;

    @FindBys({@FindBy(className = "offer")})

    private List<SelenideElement> offer;


    public void openOlxHomePage() {
        open("http://www.olx.ua/");
    }

    public void typeSearchWord(final String word) {
        searchField.sendKeys(word);
    }

    public void submitSearch() {
        submitButton.click();
    }

    public void chekOffersCount(final String count) {
        Assert.assertEquals(offer.size(),Integer.parseInt(count));
    }
}
