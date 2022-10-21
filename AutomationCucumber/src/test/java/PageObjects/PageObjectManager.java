package PageObjects;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import stepDefinition.BuyProductStepDefinition;
import utils.TestSetup;

public class PageObjectManager {
    public WebDriver driver;
    public HomePage homePage;
    public CreateAccountPage createAccountPage;
    public BuyProductPage BuyProductPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        homePage = new HomePage((TestSetup) TestSetup.driver);
        return homePage;
    }

    public CreateAccountPage getCreateAccountPage() {
        createAccountPage = new CreateAccountPage((TestSetup) TestSetup.driver);
        return createAccountPage;
    }

    public BuyProductPage getBuyProductPage() {
        BuyProductPage = new BuyProductPage((TestSetup)TestSetup.driver);
        return BuyProductPage;
    }
}
