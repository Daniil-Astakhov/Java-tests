package tests;

import org.testng.annotations.Test;

public class ComplexText extends Tests {
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

}
