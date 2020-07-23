package Wrappers;

import Utils.Common;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class Validations extends Common {


    @Step("Validate element text")
    public static void elementText(WebElement element, String expectedValue) {
        assertEquals(element.getText(), expectedValue);
    }

    @Step("Count number of elements")
    public static void elementCount(List<WebElement> elements, int expectedListSize) {
        wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        assertEquals(elements.size(), expectedListSize);
    }

    @Step("Validate text")
    public static void textValidation(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Validate text")
    public static boolean isDisplayed(WebElement element) {
        return element.isDisplayed();
    }

    @Step("Validate text")
    public static boolean isEnabled(WebElement element) {
        return element.isEnabled();
    }
}
