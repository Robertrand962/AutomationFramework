package stepDefinition;

import PageObjects.BuyProductPage;
import PageObjects.CreateAccountPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import utils.HelperMethods;
import utils.TestSetup;

import java.io.IOException;


public class BuyProductStepDefinition {
    TestSetup testSetup;
    BuyProductPage BuyProductPage;


    public BuyProductStepDefinition(TestSetup testSetup) {
        this.testSetup = testSetup;
        this.BuyProductPage = testSetup.pageObjectManager.getBuyProductPage();
    }

    @Then("User move cursor over Women link and click on sub menu T-Shirts")
    public void userMoveCursorOverWomenLinkAndClickOnSubMenuTShirts() {
        BuyProductPage.MoveCursorOverWomenLinkAndClickOnSubmenu();
    }


    @Then("User validates that same product is displayed on searched page")
    public void userValidatesThatSameProductIsDisplayedOnSearchedPage() {
        BuyProductPage.VerifyProducts();
    }

    @Then("User Get Text of the first product displayed on the page")
    public void userGetTextOfTheFirstProductDisplayedOnThePage() {
        BuyProductPage.GetTextOfTheProduct();
    }

    @Then("User Search the text from {string} and {int} of the product displayed and click search button")
    public void userSearchTheTextFromAndRowNumberOfTheProductDisplayedAndClickSearchButton(String sheetname, Integer rowNumber) throws IOException, InvalidFormatException {
        BuyProductPage.SearchProduct(sheetname, rowNumber);
    }

    @Then("User move cursor hover the product and click on More button")
    public void userMoveCursorHoverTheProductAndClickOnMoreButton() {
        BuyProductPage.HoverTheCursorAndClickMoreBox();
    }

    @Then("User increase quantity, select size L and select color")
    public void userIncreaseQuantitySelectSizeLAndSelectColor() {
        BuyProductPage.SetClothesSpecifications();
    }

    @Then("User click add to cart button and proceed to check out button")
    public void userClickAddToCartButtonAndProceedToCheckOutButton() {
        BuyProductPage.AddToCartAndCheckOut();
    }

    @Then("User complete the buy order process till payment")
    public void userCompleteTheBuyOrderProcessTillPayment() {
        BuyProductPage.OrderProcessComplete();
    }

    @Then("User make sure that product is ordered")
    public void userMakeSureThatProductIsOrdered() {
        BuyProductPage.VerifyOrderComplete();
    }

    @Then("User move cursor hover the product and click on Add to Wishlist")
    public void userMoveCursorHoverTheProductAndClickOnAddToWishlist() {
        BuyProductPage.AddToWishList();
    }

    @Then("User verify that error message is displayed")
    public void userVerifyThatErrorMessageIsDisplayed() {
        BuyProductPage.VerifyMustBeLoggedErrorMessage();
    }

    @Then("User verify quantity, select size M and select color")
    public void userVerifyQuantitySelectSizeMAndSelectColor() {
        BuyProductPage.VerifySingleItemQuantity();
        BuyProductPage.ChangeSizeToMedium();
        BuyProductPage.SetColorToBlue();
    }

    @Then("User change the quantity to two and Verify total price is correct")
    public void userChangeTheQuantityToTwoAndVerifyTotalPriceIsCorrect() {
        BuyProductPage.ChangeTheQuantityInCheckOutAndVerifyTotalPrice();
    }
}
