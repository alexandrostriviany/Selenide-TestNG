package Pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.*;

/**
 * Created by BDSM on 16.02.2017.
 */
public class PornhupPage {

    @Test
    public void scrolToLink(){
        open("http://pornhub.com/");
        executeJavaScript("arguments[0].scrollIntoView();"
                ,$(By.id("footerMenu_terms")));
        $(By.id("footerMenu_terms")).click();
    }

}
