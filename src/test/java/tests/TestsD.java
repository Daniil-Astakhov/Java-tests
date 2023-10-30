package tests;

import api.ResponseCard;
import apipojo.CardBonus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CardPage;
import pages.MainPage;
import pages.WorkWithCardBonusesWindow;

import static com.codeborne.selenide.Selenide.open;
import static data.DataForCardBonus.*;
//@Listeners({ MyListener.class })
public class TestsD extends Settings{
    private MainPage mainPage = new MainPage();
    private CardPage cardPage = new CardPage();
    private ResponseCard jsonCard = new ResponseCard();
    private CardBonus cardBonusObject;
    private WorkWithCardBonusesWindow workWithCardBonusesWindow = new WorkWithCardBonusesWindow();

    private String cardNumber;
    @BeforeTest
    public void generalSteps(){
        open("http://localhost:3000");
        cardBonusObject = setCardBonus();
        mainPage.clickOnFirstCard();
        cardNumber = cardPage.getChosenCard().replace(",","").replace("\n", "");
        cardBonusObject.setBarcode(cardNumber);
    }

    @Test
    private void uiTest(){
        cardPage.openCardBonus();
        workWithCardBonusesWindow.bonusSetValue(bonus);
        Assert.assertEquals(cardNumber, workWithCardBonusesWindow.getCardNumberFromBarcode(),
                cardNumber + " not equal " + workWithCardBonusesWindow.getCardNumberFromBarcode());
        workWithCardBonusesWindow.sumSetValue(sum);
//        workWithCardBonusesWindow.validAtSetValue(validAt);
//        workWithCardBonusesWindow.isExpiringSetValue(isExpiring);
        workWithCardBonusesWindow.commentSetValue(comment);
      //  workWithCardBonusesWindow.commentSetValueChars();
        workWithCardBonusesWindow.expireDateSetValue(expireDate);
        workWithCardBonusesWindow.authorSetValue(author);

        workWithCardBonusesWindow.clickSubmitButton();
    }

    @Test
    private  void uiTestValidate(){
        cardPage.openCardBonus();
        workWithCardBonusesWindow.bonusSetValue((bonus));
        Assert.assertEquals(cardNumber, workWithCardBonusesWindow.getCardNumberFromBarcode(),
                cardNumber + " not equal " + workWithCardBonusesWindow.getCardNumberFromBarcode());
        workWithCardBonusesWindow.sumSetValue(sum);
//        workWithCardBonusesWindow.validAtSetValue(validAt);
//        workWithCardBonusesWindow.isExpiringSetValue(isExpiring);
        workWithCardBonusesWindow.commentSetValueChars();
        //  workWithCardBonusesWindow.commentSetValueChars();
//        workWithCardBonusesWindow.expireDateSetValue(expireDate);
        workWithCardBonusesWindow.authorSetValue(author);

        workWithCardBonusesWindow.clickSubmitButton();
    }

    @Test
    public void apiTest(){
        RestAssured.baseURI = "http://loyalty-dev.spb.lichishop.com";

        String requestBody = jsonCard.getJsonFromCardBonus(cardBonusObject);
        RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/manual")
                .then()
                .statusCode(400)
                .extract()
                .response();
    }
}


