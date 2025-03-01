package PankajShukla.Tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.event.ItemEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PankajShukla.PageObjects.CartPage;
import PankajShukla.PageObjects.CheckoutPage;
import PankajShukla.PageObjects.ConfirmationPage;
import PankajShukla.PageObjects.LandingPage;
import PankajShukla.PageObjects.ProductCataloguePage;
import PankajShukla.TestComponents.BaseTest;
import PankajShukla.TestComponents.RetryAnalyzer;

public class ErrorValidationsTest extends BaseTest{

		@Test(groups = {"ErrorHandling"}, retryAnalyzer = RetryAnalyzer.class)
		public void loginErrorPage(){
		landingPage.loginToApplication("automatio1@gmail.com", "Testing@1");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
		
		@Test(groups = {"ErrorHandling"})
		public void searchProduct(){
		// TODO Auto-generated method stub
		
		String productNameString="ADIDAS ORIGINAL";
		ProductCataloguePage productCataloguePage = landingPage.loginToApplication("rahulshetty@gmail.com", "Iamking@000");
		productCataloguePage.selectProduct(productNameString);
		CartPage cartPage = productCataloguePage.goToCart();
		boolean value = cartPage.verifySelectedProduct("ADIDAS ORIGINA");
		Assert.assertFalse(value);
	}

}
