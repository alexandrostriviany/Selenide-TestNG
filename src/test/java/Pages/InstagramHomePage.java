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


    public void openFirstFollowInTheWall() {
        follows.get(0).click();
    }

    private void scrollToElement(SelenideElement element){
        Selenide.executeJavaScript("arguments[0].scrollIntoView();"
                ,element.getWrappedElement());
    }

}
