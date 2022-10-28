package PageObjects;

import Excel.ExcelReader;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.GlobalProperties;
import utils.HelperMethods;
import utils.TestSetup;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class HomePage {
    // Constructor.
    TestSetup testSetup;
    // Home Page Elements.
    By SignInBtn = By.xpath("//a[normalize-space()='Sign in']");
    By EmailTextBox = By.id("email");
    By PasswordTextBox = By.id("passwd");
    By LoginBtn = By.id("SubmitLogin");
    By NavigationPage = By.xpath("//span[@class='navigation_page']");
    By CreateEmailTextBox = By.id("email_create");
    By CreateAccountBtn = By.id("SubmitCreate");
    By ErrorMessage = By.id("create_account_error");
    // Home Page Methods.

    public HomePage(TestSetup driver) {
    }

    public void homePageIsDisplayed() {
        HelperMethods.isEleVisible(SignInBtn);
    }

    public void clickSignIn() {
        HelperMethods.click(SignInBtn);
    }

    public void logIn(String username, String password) {
        HelperMethods.enterText(EmailTextBox, username);
        HelperMethods.enterText(PasswordTextBox, password);
        HelperMethods.click(LoginBtn);
    }

    public void isAccountPageDisplayed() {
        HelperMethods.isEleVisible(NavigationPage);
    }

    public void setInvalidEmail(String sheetname, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(GlobalProperties.getProperties("DataSheet"), sheetname);
        String invalidEmail = testData.get(rowNumber).get("InvalidEmail");
        HelperMethods.enterText(CreateEmailTextBox, invalidEmail);
        HelperMethods.click(CreateAccountBtn);
        HelperMethods.waitForElement(ErrorMessage);
    }

    public void setValidEmail(String sheetname, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(GlobalProperties.getProperties("DataSheet"), sheetname);
        String Email = testData.get(rowNumber).get("Email");
        HelperMethods.enterText(CreateEmailTextBox, Email);
        HelperMethods.click(CreateAccountBtn);
    }

    public void verifyErrorMessage(String message) {
        HelperMethods.isEleVisible(ErrorMessage);
        Assert.assertEquals(HelperMethods.getText(ErrorMessage), message);
    }
}
