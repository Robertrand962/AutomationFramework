package PageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.HelperMethods;
import utils.TestSetup;

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

    public void setInvalidEmail(String invalidEmail) {
        HelperMethods.enterText(CreateEmailTextBox, invalidEmail);
        HelperMethods.click(CreateAccountBtn);
        HelperMethods.waitForElement(ErrorMessage);
    }

    public void setValidEmail(String validEmail) {
        HelperMethods.enterText(CreateEmailTextBox, validEmail);
        HelperMethods.click(CreateAccountBtn);

    }

    public void verifyErrorMessage(String message) {
        HelperMethods.isEleVisible(ErrorMessage);
        Assert.assertEquals(HelperMethods.getText(ErrorMessage), message);
    }
}
