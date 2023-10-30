package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import utils.RegionEnum;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class MainPage {
    private final SelenideElement firstCard = $x("//p[@id='autoTest']");
    private final ElementsCollection cards = $$x("//tbody/tr");
    private final SelenideElement regionSelect = $x("//div[@id='select-region']");
    private final ElementsCollection paginations = $$x("//li[contains(@aria-label,'pagination item')]");

    public SelenideElement regionInTable(int i) {
        return $$x("//td[5]").get(i);
    }

    /**
     * This method searches and clicks on first line card in table. Rout to [info] page.
     */
    public void clickOnFirstCard() {
        firstCard.shouldBe(Condition.visible, Duration.ofSeconds(10)).click();
    }

    /**
     * This method click on card by index
     *
     * @param index - index of card
     */
    public void clickCardByIndex(int index, RegionEnum region) {
        if (region != RegionEnum.All) {
            regionInTable(index).shouldHave(Condition.text(region.getName()), Duration.ofSeconds(10));
        }
        cards.get(index).shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
    }

    /**
     * This method returns size of the cards on the page
     *
     * @return int - number of cards
     */
    public int getCardSize() {
        return cards.size();
    }

    /**
     * This method returns pagination number
     *
     * @return int - number of cards
     */
    public int getPaginationSize() {
        paginations.get(1).shouldBe(Condition.visible, Duration.ofSeconds(10));
        return paginations.size();
    }

    /**
     * This method searches and clicks on the region selector. Opening a modal window.
     */
    public void clickOnRegionList() {
        regionSelect.shouldBe(
                Condition.visible, Duration.ofSeconds(5)).click();
    }

    /**
     * This method open next window using pagination numbers
     *
     * @param index - pagination
     */
    public void clickOnPaginationNumber(int index) {
        paginations.get(index).click();
    }
}
