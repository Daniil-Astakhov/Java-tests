package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import utils.RegionEnum;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class WorkWithMainWindow {

    private final SelenideElement kzRegion = $x("//li[@data-key='KZ']");

    private final SelenideElement allRegion = $x("//li[@data-key='All']");
    private final SelenideElement ruRegion = $x("//li[@data-key='RU']");

    public SelenideElement region(String region) {
        return $x("//li[@data-key='" + region + "']");
    }

    public void clickOnKzRegion() {
        kzRegion.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    public void clickOnAllRegion() {
        allRegion.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    public void clickOnRuRegion() {
        ruRegion.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    public void clickOnRegion(RegionEnum region) {
        region(region.getName()).shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }
}
