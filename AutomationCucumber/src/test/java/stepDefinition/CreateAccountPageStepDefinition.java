package stepDefinition;

import Excel.ExcelReader;
import PageObjects.CreateAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utils.GlobalProperties;
import utils.TestSetup;

import java.io.IOException;
import java.util.List;
import java.util.Map;


public class CreateAccountPageStepDefinition {
    TestSetup testSetup;
    CreateAccountPage createAccountPage;


    public CreateAccountPageStepDefinition(TestSetup testSetup) {
        this.testSetup = testSetup;
        this.createAccountPage = testSetup.pageObjectManager.getCreateAccountPage();
    }

    @Then("^User is in create an account page.$")
    public void user_is_in_create_an_account_page() {
        createAccountPage.CreateAccountPageIsDisplayed();
    }


    @Then("^User submit personal information and create an account$")
    public void userClickSubmitPersonalInformationAndCreateAnAccount() {
        createAccountPage.ClickRegisterBtn();
    }

    @And("User provides personal information and address information from given sheetname {string} and rownumber {int}")
    public void userProvidesPersonalInformationAndAddressInformationFromGivenSheetnameAndRownumberRowNumber(String sheetname, Integer rowNumber) throws IOException, InvalidFormatException {
        // Send data to method.
        createAccountPage.FillPersonalInformation(sheetname, rowNumber);
        createAccountPage.FillAddress(sheetname, rowNumber);
    }

    @Then("User validates that user is created")
    public void userValidatesThatUserIsCreated() {
        createAccountPage.UserIsInMyAccountPage();
    }
    @Then("User leave mandatory fields blank and click Register button")
    public void userLeaveMandatoryFieldsBlankAndClickRegisterButton() {
        createAccountPage.ClickRegisterBtn();
    }

    @Then("User verify that error has been displayed for the mandatory fields")
    public void userVerifyThatErrorHasBeenDisplayedForTheMandatoryFields() {
        createAccountPage.VerifyMandatoryFieldsAlertRequired();
    }
    @Then("User enter incorrect values in fields from given sheetname {string} and rownumber {int}")
    public void userEnterIncorrectValuesInFields(String sheetname, Integer rowNumber) throws IOException, InvalidFormatException {
        createAccountPage.FillInvalidFields(sheetname, rowNumber);
        createAccountPage.ClickRegisterBtn();

    }

    @Then("User verify that error messages for respective fields are displaying")
    public void userVerifyThatErrorMessagesForRespectiveFieldsAreDisplaying() {
        createAccountPage.VerifyMandatoryFieldsAlertInvalid();
    }
}