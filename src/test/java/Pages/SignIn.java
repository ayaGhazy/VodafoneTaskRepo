package Pages;

import org.openqa.selenium.WebDriver;

import java.sql.Timestamp;

public class SignIn extends Page {
    static SignIn signInPage;

    // ElementsActions elementsActions;
    // WebDriver driver;
    SignIn(WebDriver driver) {
        //     elementsActions =         ElementsActions.getInstance(driver);
        super(driver);
    }

    public static SignIn getInstance(WebDriver driver) {
        if (signInPage == null) {
            signInPage = new SignIn(driver);
        }
        return signInPage;
    }

    public void navigate() {
        elementsActions.navigate("url");
    }

    public void createAccount() {
        // click sign in button
        elementsActions.click("signInBTN");

        //click on email
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        elementsActions.type("emailTxt", Long.toString(timestamp.getTime()));
        elementsActions.click("createAccountBtn");
        //handle error
        elementsActions.sleep(1000);
        try {
            if (elementsActions.findElement("create_account_error").isDisplayed()) {
                timestamp = new Timestamp(System.currentTimeMillis());
                elementsActions.type("emailTxt", "Error" + timestamp.getTime());
                elementsActions.click("createAccountBtn");

            }
        } catch (Exception e) {

        }
    }

    public void register() {

        //click on email
        elementsActions.sleep(2000);
        elementsActions.type("customer_firstname");
        elementsActions.type("customer_lastname");
        elementsActions.type("passwd");
//        elementsActions.selectByValue("selectdays");
//        elementsActions.selectByValue("selectmonths");
//        elementsActions.selectByValue("selectyears");
        elementsActions.selectByIndex("selectdays");
        elementsActions.selectByIndex("selectmonths");
        elementsActions.selectByIndex("selectyears");
        elementsActions.click("femaleBtn");

        elementsActions.type("firstname");
        elementsActions.type("lastname");
        elementsActions.type("address1");
        elementsActions.type("city");
        elementsActions.selectByIndex("selectstate");
        elementsActions.type("phone_mobile");
        elementsActions.type("postcode");
        elementsActions.type("alias");
        elementsActions.click("submitAccountBtn");


    }
}
