package tests;

import org.testng.annotations.Test;

public class MainTestActions extends Tests {
    private final Tests testsList = new Tests();

    @Test
    private void tableCheckedLong() throws InterruptedException {
        testsList.regionListCheckedTable();
    }
    @Test
    private  void validateTest() {
        testsList.uiTestValidate();

    }

    @Test
    private  void apiValidateTest() {
        testsList.apiTest();
    }

    @Test
    private  void apiNoValidateTest() {
        testsList.noValidApiTest();
    }

    @Test
    private  void baseUiTest() {
        testsList.validUiTest();
    }

    @Test
    private  void baseNoValidUiTest() {
        testsList.noValidUiTest();
    }

}
