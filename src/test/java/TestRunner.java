import DriverManagement.Driver;
import Pages.Purchase;
import Pages.SignIn;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

public class TestRunner {
    SignIn signInPage;
    Purchase purchage;

    @BeforeClass
    public void setup() {

        signInPage = SignIn.getInstance(Driver.getInstance());

    }

    @Test
    public void TC001() {
        signInPage = SignIn.getInstance(Driver.getInstance());
        signInPage.navigate();

        signInPage.createAccount();
        signInPage.register();
        purchage = Purchase.getInstance(Driver.getInstance());
        purchage.selectBlouses();
        purchage.selectPayByBankWire();
        purchage.reviewOrder();
    }
}
