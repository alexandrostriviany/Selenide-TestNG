package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

/**
 * Created by BDSM on 21.02.2017.
 */
public class InstagramHomePage {

    @FindBys({@FindBy(how = How.CLASS_NAME, using = "_a012k")})
    private List<SelenideElement> follows;

    @FindBy(css = "div.coreSpriteMobileNavProfileInactive")
    private SelenideElement myProfile;


    public void openFirstFollowInTheWall() {
        follows.get(0).click();
    }

    public void openMyProfile(){
        myProfile.click();
    }

    public void WaitForAjax1(int sleepTime) {
        while (true) {
            if ((Boolean) Selenide.executeJavaScript("return jQuery.active == 0")) {
                break;
            }
            Selenide.sleep(sleepTime);
        }
    }

    private void scrollToElement(SelenideElement element){
        Selenide.executeJavaScript("arguments[0].scrollIntoView();"
                ,element.getWrappedElement());
    }

}
