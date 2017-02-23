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
public class InstagramMyProfilePage {

    @FindBy(how = How.XPATH, using = ".//*[text()=\"Подписки: \"]")
    private SelenideElement followersLink;

    @FindBys({@FindBy(css = "._ah57t._dzx3o._i46jh._rmr7s")})
    List<SelenideElement> listFollowers;

    public void openfollowers() {
        followersLink.click();
    }

    private void scrollToElement(SelenideElement element) {
        Selenide.executeJavaScript("arguments[0].scrollIntoView();"
                , element.getWrappedElement());
    }

    public void dellNewFollowers(final int count) {
        int listSize = 0;
        if (listFollowers.size() > 2) {
            do {
                scrollToElement(listFollowers.get(0));
                Selenide.executeJavaScript("scroll(0,20)");
                listFollowers.get(0).click();
                Selenide.sleep(1500);
                listSize++;
            } while (listSize < count && listFollowers.size() > 2);
        }
    }

    public void dellNewFollowersFast(final int howMuch) {
        for (int i = 0; i < howMuch; i++) {
            scrollToElement(listFollowers.get(0));
            Selenide.executeJavaScript("scroll(0,20)");
            int size = 7;
            List<SelenideElement> list = listFollowers;
            for (int j = 1; j < size; j++) {
                list.get(0).click();
            }
        }
    }

}
