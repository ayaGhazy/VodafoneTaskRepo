package Pages;

import keywordDriven.ElementsActions;
import org.openqa.selenium.WebDriver;

public class Page {
    static Page page;
    ElementsActions elementsActions;
    WebDriver driver;

    Page(WebDriver driver) {
        elementsActions = ElementsActions.getInstance(driver);
        this.driver = driver;
    }

    public static Page getInstance(WebDriver driver) {
        if (page == null) {
            page = new Page(driver);
        }
        return page;
    }

    public void close() {
        driver.close();
    }
}
