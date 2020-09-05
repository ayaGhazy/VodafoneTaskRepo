package keywordDriven;

import ExcelUtility.ExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementsActions {
    static ElementsActions elementsActions;
    WebDriver driver;
    ExcelReader reader;

    ElementsActions(WebDriver driver) {
        this.driver = driver;
        reader = ExcelReader.getInstance();
    }

    public static ElementsActions getInstance(WebDriver driver) {
        if (elementsActions == null) {
            elementsActions = new ElementsActions(driver);
        }
        return elementsActions;
    }

    public void navigate(String url) {
        driver.get(reader.readTestData(url));
    }

    public void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement findElement(String element) {
        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        WebElement webElement = null;
        String caseString = reader.readfindBy(element);
        switch (caseString) {
            case "id":
                webElement = driver.findElement(By.id(reader.readBy(element)));

                break;
            case "xpath":

                webElement = driver.findElement(By.xpath(reader.readBy(element)));

                break;
            case "name":

                webElement = driver.findElement(By.name(reader.readBy(element)));

                break;
            default:

                webElement = driver.findElement(By.xpath(reader.readBy(element)));

                break;
        }
        sleep(300);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement);
        actions.build().perform();
        return webElement;
    }

    public void click(String element) {
        findElement(element).click();
    }

    public void type(String element) {
        findElement(element).sendKeys(reader.readValue(element));
    }

    public void type(String element, String text) {
        findElement(element).sendKeys('a' + text + reader.readValue(element));
    }

    public String getText(String element) {
        return findElement(element).getText();
    }

    public void selectByValue(String element) {
        Select select = new Select(findElement(element));
        select.selectByValue(reader.readValue(element));
        //findElement(findby, element).sendKeys(value);
    }

    public void selectByIndex(String element) {
        Select select = new Select(findElement(element));
        select.selectByIndex(1);//reader.readValue(element));
        //findElement(findby, element).sendKeys(value);
    }

    public void hoverandSelect(String element1, String element2) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(element1)).clickAndHold().moveToElement(findElement(element2)).click(findElement(element2)).build().perform();
    }
}
