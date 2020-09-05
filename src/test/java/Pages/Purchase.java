package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Purchase extends Page {
    static Purchase purchase;
    String orderNo;

    Purchase(WebDriver driver) {
        //     elementsActions =         ElementsActions.getInstance(driver);
        super(driver);
    }

    public static Purchase getInstance(WebDriver driver) {
        if (purchase == null) {
            purchase = new Purchase(driver);
        }
        return purchase;
    }

    public void selectBlouses() {
        elementsActions.hoverandSelect("Women", "Blouses");
        elementsActions.sleep(500);
        elementsActions.click("addToCart");
        elementsActions.sleep(500);
        elementsActions.click("Proceed to checkout");
        elementsActions.sleep(500);
        elementsActions.click("Proceed to checkout2");
        elementsActions.sleep(500);
        elementsActions.click("Proceed to checkout3");
        elementsActions.sleep(500);
        elementsActions.click("agreeBtn");
        elementsActions.click("Proceed to checkout4");


    }

    public void selectPayByBankWire() {
        elementsActions.click("Pay by bank wire");
        elementsActions.click("confirmOrder"); //order details


        elementsActions.click("user");
    }

    public void reviewOrder() {
        elementsActions.click("orders");
        try {
            if (elementsActions.findElement("notHistory").isDisplayed())
                Assert.fail("No history even after we purchase");
        } catch (Exception e) {

        }
        close();

    }
}
