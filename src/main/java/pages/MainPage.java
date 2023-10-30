package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
public class MainPage {
     private SelenideElement firstCard = $x("//p[@id='autoTest']" );

    public void clickOnFirstCard(){
        firstCard.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }
}
