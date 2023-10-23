package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$x;

public class WorkWithCardBonusesWindow {
    private SelenideElement barcode = $x("//input[@id='barcode']");
    private SelenideElement bonus = $x("//input[@id='bonus']");
    private SelenideElement sum = $x("//input[@id='sum']");
    private SelenideElement validAt = $x("//input[@id='valid_at']");
    private SelenideElement isExpiring = $x("//input[@id='is_expiring']");
    private SelenideElement comment = $x("//input[@id='comment']");
    private SelenideElement expireDate = $x("//input[@id='expire_date']");
    private SelenideElement author = $x("//input[@id='author']");
    private SelenideElement submitButton = $x("//button[@type='submit']");

    public void bonusSetValue(String text) {
        bonus.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        bonus.sendKeys(text);
    }

    public void sumSetValue(String text) {
        sum.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        sum.sendKeys(text);
    }

    public void validAtSetValue(String text) {
        validAt.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        validAt.sendKeys(text);
    }

    public void isExpiringSetValue(String text) {
        isExpiring.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        isExpiring.sendKeys(text);
    }

    public void commentSetValue(String text) {
        comment.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        comment.sendKeys(text);
    }

    public void commentSetValueChars() {
        comment.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        String validStr = "Очень длинный комментарий для теста балбалаблабалабалаблабалаблабалаблабалабал";
        for (int i = 0; i < validStr.length(); i++) {
            comment.sendKeys(String.valueOf(validStr.charAt(i)));
        }
    }

    public void expireDateSetValue(String text) {
        expireDate.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        expireDate.sendKeys(text);
    }

    public void authorSetValue(String text) {
        author.shouldBe(Condition.visible, Duration.ofSeconds(5)).click();
        String validStr = "Очень длинное имя автора потому что это автотест";
        for (int i = 0; i < validStr.length(); i++) {
            author.sendKeys(String.valueOf(validStr.charAt(i)));
        }
//        author.sendKeys(text);
    }

    public String getCardNumberFromBarcode() {
        return barcode.getAttribute("value");
    }

    public void clickSubmitButton() {
        submitButton.click();
    }
}
