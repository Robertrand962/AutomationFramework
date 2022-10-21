package PageObjects;

import Data.Constants;
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

public class CreateAccountPage {
    TestSetup testSetup;

    //Personal Information
    By TitleMrBtn = By.id("id_gender1");
    By FirstNameTextBox = By.id("customer_firstname");
    By LastNameTextBox = By.id("customer_lastname");
    By EmailTextBoxPersonalInfo = By.id("email");
    By PasswordTextBoxPersonalInfo = By.id("passwd");
    By DayDropDownDateOfBirth = By.id("days");
    By MonthDropDownDateOfBirth = By.id("months");
    By YearDropDownDateOfBirth = By.id("years");
    By NewsletterCheckBox = By.id("newsletter");
    By SpecialOffersCheckBox = By.id("optin");

    //Your Address

    By FirstNameTextBoxAddress = By.id("firstname");
    By LastNameTextBoxAddress = By.id("lastname");
    By CompanyTextBoxAddress = By.id("company");
    By AddressTextBoxAddress = By.id("address1");
    By Address2TextBoxAddress = By.id("address2");
    By CityTextBoxAddress = By.id("city");
    By StateDropdownAddress = By.id("id_state");
    By ZipCodeTextBoxAddress = By.id("postcode");
    By CountryDropdownAddress = By.id("id_country");
    By AdditionalInfoTextBoxAddress = By.id("other");
    By HomePhoneTextBoxAddress = By.id("phone");

    By MobilePhoneTextBoxAddress = By.id("phone_mobile");
    By AliasTextBoxAddress = By.id("alias");

    By RegisterBtn = By.id("submitAccount");
    By MandatoryFieldsAlert = By.xpath("//div[@class='alert alert-danger']");

    //My Account Page
    By MyAccountPage = By.id("center_column");


    // Create Account Page Methods.
    public CreateAccountPage(TestSetup driver) {
    }

    public void CreateAccountPageIsDisplayed() {
        HelperMethods.waitForElement(FirstNameTextBox);
    }

    public void FillPersonalInformation(String sheetname, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(GlobalProperties.getProperties("DataSheet"), sheetname);
        // retrieve data from sheet.
        String firstName = testData.get(rowNumber).get("FirstName");
        String lastName = testData.get(rowNumber).get("LastName");
        String passwordPi = testData.get(rowNumber).get("PasswordPI");
        String days = testData.get(rowNumber).get("days");
        String months = testData.get(rowNumber).get("months");
        String years = testData.get(rowNumber).get("years");
        //////////////////////////////////////////
        HelperMethods.waitForElement(FirstNameTextBox);
        HelperMethods.click(TitleMrBtn);
        HelperMethods.enterText(FirstNameTextBox, firstName);
        HelperMethods.enterText(LastNameTextBox, lastName);
        HelperMethods.click(EmailTextBoxPersonalInfo);
        HelperMethods.enterText(PasswordTextBoxPersonalInfo, passwordPi);
        HelperMethods.click(DayDropDownDateOfBirth);
        HelperMethods.selectDropdownByValue(DayDropDownDateOfBirth, days);
        HelperMethods.click(MonthDropDownDateOfBirth);
        HelperMethods.selectDropdownByValue(MonthDropDownDateOfBirth, months);
        HelperMethods.click(YearDropDownDateOfBirth);
        HelperMethods.selectDropdownByValue(YearDropDownDateOfBirth, years);
        HelperMethods.click(NewsletterCheckBox);
        HelperMethods.click(SpecialOffersCheckBox);
    }

    public void FillAddress(String sheetname, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(GlobalProperties.getProperties("DataSheet"), sheetname);
        // retrieve data from sheet.
        String firstName = testData.get(rowNumber).get("FirstName");
        String lastName = testData.get(rowNumber).get("LastName");
        String company = testData.get(rowNumber).get("Company");
        String address1 = testData.get(rowNumber).get("Address");
        String address2 = testData.get(rowNumber).get("Address2");
        String city = testData.get(rowNumber).get("City");
        String state = testData.get(rowNumber).get("State");
        String zipcode = testData.get(rowNumber).get("ZipCode");
        String country = testData.get(rowNumber).get("Country");
        String additionalInfo = testData.get(rowNumber).get("AdditionalInfo");
        String phone = testData.get(rowNumber).get("Phone");
        String phoneMobile = testData.get(rowNumber).get("MobilePhone");
        String alias = testData.get(rowNumber).get("Alias");
        ///////////////////////////////////
        HelperMethods.click(TitleMrBtn);
        HelperMethods.enterText(FirstNameTextBoxAddress, firstName);
        HelperMethods.enterText(LastNameTextBoxAddress, lastName);
        HelperMethods.enterText(CompanyTextBoxAddress, company);
        HelperMethods.enterText(AddressTextBoxAddress, address1);
        HelperMethods.enterText(Address2TextBoxAddress, address2);
        HelperMethods.enterText(CityTextBoxAddress, city);
        HelperMethods.selectDropdownByText(StateDropdownAddress, state);
        HelperMethods.enterText(ZipCodeTextBoxAddress, zipcode);
        HelperMethods.selectDropdownByText(CountryDropdownAddress, country);
        HelperMethods.enterText(AdditionalInfoTextBoxAddress, additionalInfo);
        HelperMethods.enterText(HomePhoneTextBoxAddress, phone);
        HelperMethods.enterText(MobilePhoneTextBoxAddress, phoneMobile);
        HelperMethods.enterText(AliasTextBoxAddress, alias);
    }

    public void ClickRegisterBtn() {
        HelperMethods.waitForElement(RegisterBtn);
        HelperMethods.click(RegisterBtn);
    }

    public void UserIsInMyAccountPage() {
        HelperMethods.isEleVisible(MyAccountPage);
    }

    public void VerifyMandatoryFieldsAlertRequired() {
        HelperMethods.waitForElement(MandatoryFieldsAlert);
        String ErrorMessage = HelperMethods.getText(MandatoryFieldsAlert);
        Assert.assertTrue(ErrorMessage.contains(Constants.FirstNameRequired));
        Assert.assertTrue(ErrorMessage.contains(Constants.LastNameRequired));
        Assert.assertTrue(ErrorMessage.contains(Constants.PhoneNumberRegisterRequired));
        Assert.assertTrue(ErrorMessage.contains(Constants.PasswordRequired));
        Assert.assertTrue(ErrorMessage.contains(Constants.Address1Required));
        Assert.assertTrue(ErrorMessage.contains(Constants.CityRequired));
        Assert.assertTrue(ErrorMessage.contains(Constants.ZipCodeRequired));
        Assert.assertTrue(ErrorMessage.contains(Constants.StateRequired));
    }
    public void FillInvalidFields(String sheetname, Integer rowNumber) throws IOException, InvalidFormatException {
        ExcelReader reader = new ExcelReader();
        List<Map<String, String>> testData = reader.getData(GlobalProperties.getProperties("DataSheet"), sheetname);
        String firstName = testData.get(rowNumber).get("FirstName");
        String lastName = testData.get(rowNumber).get("LastName");
        String zipcode = testData.get(rowNumber).get("ZipCode");
        String phoneMobile = testData.get(rowNumber).get("MobilePhone");
        ///////////////////
        HelperMethods.enterText(FirstNameTextBoxAddress, firstName);
        HelperMethods.enterText(LastNameTextBoxAddress, lastName);
        HelperMethods.enterText(ZipCodeTextBoxAddress, zipcode);
        HelperMethods.enterText(MobilePhoneTextBoxAddress, phoneMobile);
    }
    public void VerifyMandatoryFieldsAlertInvalid() {
        HelperMethods.waitForElement(MandatoryFieldsAlert);
        String ErrorMessageInvalid = HelperMethods.getText(MandatoryFieldsAlert);
        Assert.assertTrue(ErrorMessageInvalid.contains(Constants.FirstNameInvalid));
        Assert.assertTrue(ErrorMessageInvalid.contains(Constants.LastNameInvalid));
        Assert.assertTrue(ErrorMessageInvalid.contains(Constants.ZipCodeInvalid));
        Assert.assertTrue(ErrorMessageInvalid.contains(Constants.PhoneNumberInvalid));
    }
}

