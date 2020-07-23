package Wrappers;

import Utils.Common;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class UIActions extends Common {

    public UIActions() throws IOException, SAXException, ParserConfigurationException {}


    @Step("Click")
    public static void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Step("Set text")
    public static void setText(WebElement element, String value){
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    @Step("Select from dropdown")
    public static void selectFromDropDown(WebElement element, String value){
        wait.until(ExpectedConditions.elementToBeClickable(element));
        Select myValue = new Select(element);
        myValue.selectByVisibleText(value);
    }

    @Step("Mouse hover")
    public static void hoverOnElement(WebElement element){
        actions.moveToElement(element).build().perform();
    }

    @Step("Upload file")
    public static void uploadFile(WebElement element, String filePath) {
        element.sendKeys(filePath);
    }

    @Step("Switch to iframe")
    public static void switchToFrame(WebDriver driver, WebElement element) {
        driver.switchTo().frame(element);
    }

    @Step("Switch to parent frame")
    public static void switchToParentFrame(WebDriver driver) {
        driver.switchTo().parentFrame();
    }

    @Step("Switch to default frame")
    public static void switchToDefaultFrame(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
}
