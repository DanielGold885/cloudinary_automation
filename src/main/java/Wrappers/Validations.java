package Wrappers;

import Utils.Common;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
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

    @Step("Validate attribute value")
    public static void validateAttributeValue(WebElement element, String attribute, String expectedValue) {

        String actualValue = element.getAttribute(attribute);
        assertEquals(actualValue, expectedValue);
    }

    @Step("Validate text")
    public static boolean isDisplayed(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isDisplayed();
    }

    @Step("Validate text")
    public static boolean isEnabled(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.isEnabled();
    }
}

