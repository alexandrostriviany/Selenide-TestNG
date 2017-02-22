package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

/**
 * Created by BDSM on 21.02.2017.
 */
public class InstagramFolowPage {

    @FindBy(how = How.XPATH, using = ".//*[text()=\"Подписки: \"]")
    private SelenideElement followersLink;

    @FindBys({@FindBy(xpath = ".//*[text()=\"Подписаться\"]")})
    List<SelenideElement> listFollowers;

    public void openfollowers() {
        followersLink.click();
    }

    private void scrollToElement(SelenideElement element){
        Selenide.executeJavaScript("arguments[0].scrollIntoView();"
                ,element.getWrappedElement());
    }

    public void addNewFollowers(final int count) {
        int listSize = 0;
        if (listFollowers.size() > 2) {
            do {
                scrollToElement(listFollowers.get(0));
                Selenide.executeJavaScript("scroll(0,50)");
                listFollowers.get(0).click();
                Selenide.sleep(1500);
                listSize++;
            } while (listSize < count && listFollowers.size() > 2);
        }
    }

}
