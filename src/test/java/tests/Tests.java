package tests;

import api.ResponseCard;
import apipojo.CardBonus;
import com.codeborne.selenide.Selenide;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import pages.CardPage;
import pages.MainPage;
import pages.WorkWithCardBonusesWindow;
import pages.WorkWithMainWindow;
import utils.RegionEnum;

import static com.codeborne.selenide.Selenide.open;
import static data.DataForCardBonus.*;

//@Listeners({ MyListener.class })
public class Tests extends Settings {
    private final MainPage mainPage = new MainPage();
    private final CardPage cardPage = new CardPage();
    private final WorkWithMainWindow workWithMainWindow = new WorkWithMainWindow();
    private final ResponseCard jsonCard = new ResponseCard();
    private CardBonus cardBonusObject;
    private final WorkWithCardBonusesWindow workWithCardBonusesWindow = new WorkWithCardBonusesWindow();

    private void clickOnCardAndBack(int index, RegionEnum region){
        mainPage.clickCardByIndex(index, region);
        cardPage.clickBackBtn();
        Selenide.sleep(1000);
    }

    private String cardNumber;

    @BeforeTest
    public void generalSteps() {
        open("http://localhost:3000");

    }


    public void uiTest() {
        // BeforeTest
        cardBonusObject = setCardBonus();
        mainPage.clickOnFirstCard();
        cardNumber = cardPage.getChosenCard().replace(",", "").replace("\n", "");
        cardBonusObject.setBarcode(cardNumber);

        // BodyTest
        cardPage.openCardBonus();
        workWithCardBonusesWindow.bonusSetValue(bonus);
        Assert.assertEquals(cardNumber, workWithCardBonusesWindow.getCardNumberFromBarcode(),
                cardNumber + " not equal " + workWithCardBonusesWindow.getCardNumberFromBarcode());
        workWithCardBonusesWindow.sumSetValue(sum);
        workWithCardBonusesWindow.commentSetValue(comment);
        workWithCardBonusesWindow.expireDateSetValue(expireDate);
        workWithCardBonusesWindow.authorSetValue(author);
        workWithCardBonusesWindow.clickSubmitButton();
    }

private void tableRegionCheck(RegionEnum region){
    int numberCards;
    int paginationSize = mainPage.getPaginationSize();
    int paginationCount = 0;
    do {
        Selenide.sleep(1000);
        numberCards = mainPage.getCardSize();
        if (paginationCount == paginationSize - 1) {
            for (int i = 0; i < numberCards; i++) {
                clickOnCardAndBack(i, region);
            }
            return;
        } else {
            Assert.assertEquals(numberCards, 10,
                    "Так как еще есть страницы количество карт должно быть 10, но их: " + numberCards + "\n");
            for (int i = 0; i < numberCards; i++) {
                clickOnCardAndBack(i, region);
            }
            paginationCount++;
            mainPage.clickOnPaginationNumber(paginationCount);
        }
    } while (paginationCount < paginationSize);
}
    public void regionListCheckedTable() throws InterruptedException {


        // BodyTest
      //  tableRegionCheck(RegionEnum.All);

        mainPage.clickOnRegionList();

        workWithMainWindow.clickOnRegion(RegionEnum.KZ);

        tableRegionCheck(RegionEnum.KZ);

        mainPage.clickOnRegionList();

        workWithMainWindow.clickOnRegion(RegionEnum.RU);

        tableRegionCheck(RegionEnum.RU);




        Thread.sleep(3000);
    }




    public void uiTestValidate() {
        // BeforeTest
        cardBonusObject = setCardBonus();
        mainPage.clickOnFirstCard();
        cardNumber = cardPage.getChosenCard().replace(",", "").replace("\n", "");
        cardBonusObject.setBarcode(cardNumber);

        // BodyTest
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


    public void apiTest() {
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


