package PankajShukla.StepDefinition;

import org.testng.AssertJUnit;

import PankajShukla.PageObjects.CartPage;
import PankajShukla.PageObjects.CheckoutPage;
import PankajShukla.PageObjects.ConfirmationPage;
import PankajShukla.PageObjects.LandingPage;
import PankajShukla.PageObjects.ProductCataloguePage;
import PankajShukla.TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionImplementation  extends BaseTest{

	public  LandingPage landingPage;
	public ProductCataloguePage productCataloguePage;
	public ConfirmationPage confirmationPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws Exception
	{
		landingPage = loadApplication();
	}
	
	@Given("^I login with my credentials (.+) and (.+)$")
	public void I_login_with_my_credentials(String usernameString, String password)
	{
		 productCataloguePage = landingPage.loginToApplication(usernameString, password);
	}
	
	
	@When("^I add the product (.+)$")
	public void add_the_product(String productName)
	{
		productCataloguePage.selectProduct(productName);
	}
	
	@When("^Checkout (.+) and submit the order.$")
	public void Checkout_and_submit_the_order(String product)
	{
		CartPage cartPage = productCataloguePage.goToCart();
		boolean value = cartPage.verifySelectedProduct(product);
		AssertJUnit.assertTrue(value);
		CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
		checkoutPage.selectCountry("ind");
		confirmationPage = checkoutPage.submit();	
	}
	
	@Then("{string} message is displayed on confirmationPage.")
	public void message_is_displayed_on_confirmation_page(String string) 
    {
    	String Successtext = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(Successtext.equalsIgnoreCase(string));
		System.out.println("Done");		
		closeDriver();
    }
	
	
	@Then("{string} message is displayed.")
	public void message_is_displayed(String string) {
		AssertJUnit.assertEquals(string, landingPage.getErrorMessage());
		closeDriver();
    }
	
	
}
