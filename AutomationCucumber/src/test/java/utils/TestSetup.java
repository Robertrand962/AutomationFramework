package utils;

import PageObjects.PageObjectManager;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class TestSetup {
    public static WebDriver driver;
    public TestBase testBase;
    public HelperMethods helperMethods;
    public PageObjectManager pageObjectManager;

    public TestSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
        helperMethods = new HelperMethods(testBase.WebDriverManager());
    }
}
