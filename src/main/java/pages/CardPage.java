package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class CardPage {
    private final SelenideElement cardBonusButton =
            $x("//button[@id='TestButton']");
    public SelenideElement chosenCard =
            $x("//span[contains(@id,'react-aria')]");
    public SelenideElement backBtn =
            $x("//button[contains(@id,'back')]");

    public void openCardBonus() {
        cardBonusButton.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    public String getChosenCard() {
        Selenide.sleep(2000);
        return chosenCard.shouldBe(Condition.visible, Duration.ofSeconds(5)).getText();
    }

    public void clickBackBtn() {
        backBtn.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();

    }

}
