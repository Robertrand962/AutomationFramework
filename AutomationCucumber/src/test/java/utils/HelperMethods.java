package utils;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;


public class HelperMethods {

    public static WebDriver driver;


    public HelperMethods(WebDriver driver) {
        HelperMethods.driver = driver;
    }

    public static void isEleVisible(By by) {
        try {
            assertTrue(driver.findElement(by).isDisplayed());
        } catch (AssertionError error) {
            driver.close();
            Assert.fail();
        }
    }

    public static void click(By by) {
        try {
            driver.findElement(by).click();
        } catch (NoSuchElementException e) {
            driver.close();
            Assert.fail();
        }
    }

    public static void enterText(By by, String text) {
        try {
            driver.findElement(by).sendKeys(text);
        } catch (NoSuchElementException e) {
            driver.close();
            Assert.fail();
        }
    }

    public static String getText(By by) {
        try {
            return driver.findElement(by).getText();
        } catch (NoSuchElementException e) {
            driver.close();
            Assert.fail();
        }
        return driver.findElement(by).getText();
    }

    public static void selectDropdownByValue(By by, String text) {//dropdown :D
        try {
            Select dropdown = new Select(driver.findElement(by));
            dropdown.selectByValue(text);
        } catch (NoSuchElementException e) {
            driver.close();
            Assert.fail();
        }
    }

    public static void selectDropdownByText(By by, String text) {//dropdown :D
        try {
            Select dropdown = new Select(driver.findElement(by));
            dropdown.selectByVisibleText(text);
        } catch (NoSuchElementException e) {
            driver.close();
            Assert.fail();
        }
    }

    public static void waitForElement(By by) {
        try {
            Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(10))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);
            wait.until(ExpectedConditions.elementToBeClickable(by));
        } catch (NoSuchElementException e) {
            driver.close();
            Assert.fail();
        }
    }

    public static void hoverElement(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(by)).perform();
    }

    public static String getElementValue(By by) {
        try {
            return driver.findElement(by).getAttribute("value");
        } catch (NoSuchElementException e) {
            driver.close();
            Assert.fail();
        }
        return driver.findElement(by).getAttribute("value");
    }
}

