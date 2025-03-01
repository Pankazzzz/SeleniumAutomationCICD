package PankajShukla.Tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.awt.event.ItemEvent;
import java.time.Duration;
import java.util.HashMap;
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
import PankajShukla.PageObjects.OrderPage;
import PankajShukla.PageObjects.ProductCataloguePage;
import PankajShukla.TestComponents.BaseTest;

public class StandaloneApplication extends BaseTest{

	String productNameString="ADIDAS ORIGINAL";
	
		@Test(dataProvider = "getData",groups = {"Purchase"})
		public void submitOrder(HashMap<String, String> data) throws Exception{		
		ProductCataloguePage productCataloguePage = landingPage.loginToApplication(data.get("email"), data.get("password"));
		productCataloguePage.selectProduct(data.get("product"));
		CartPage cartPage = productCataloguePage.goToCart();
		boolean value = cartPage.verifySelectedProduct(data.get("product"));
		AssertJUnit.assertTrue(value);
		CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
		checkoutPage.selectCountry("ind");
		ConfirmationPage confirmationPage = checkoutPage.submit();
		String Successtext = confirmationPage.getConfirmationMessage();
		AssertJUnit.assertTrue(Successtext.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Done");		
	}
		
		@Test(dependsOnMethods = "submitOrder")
		public void order()
		{
			ProductCataloguePage productCataloguePage = landingPage.loginToApplication("automationtesting11@gmail.com", "Testing@1");
			OrderPage orderPage = productCataloguePage.goToOrder();
			boolean value = orderPage.validateOrderedProduct(productNameString);
			Assert.assertTrue(value);
		}
		
		
		@DataProvider
		public Object[][] getData() throws Exception
		{
				List<HashMap<String, String>> dataHashMaps =  getJsonData(System.getProperty("user.dir")+"/src/test/java/PankajShukla/Data/PurchaseOrder.json");
				return new Object[][] {{dataHashMaps.get(0)},{dataHashMaps.get(1)}};
		}
		
		
		  ///mvn test -POrder
		//mvn test -Dbrowser=Firefox
		//mvn test -POrder -Dbrowser=Firefox
		//mvn test -POrder -Dbrowser=Firefoxheadless

		
		
		
		
		
		
		//By HashMap
//		@Test(dataProvider = "getData",groups = {"Purchase"})
//		public void submitOrder(HashMap<String, String> data){		
//		ProductCataloguePage productCataloguePage = landingPage.loginToApplication(data.get("email"), data.get("password"));
//		productCataloguePage.selectProduct(data.get("product"));
//		CartPage cartPage = productCataloguePage.goToCart();
//		boolean value = cartPage.verifySelectedProduct(data.get("product"));
//		AssertJUnit.assertTrue(value);
//		CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
//		checkoutPage.selectCountry("ind");
//		ConfirmationPage confirmationPage = checkoutPage.submit();
//		String Successtext = confirmationPage.getConfirmationMessage();
//		AssertJUnit.assertTrue(Successtext.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		System.out.println("Done");		
//	}
//		
//		@DataProvider
//		public Object[][] getData()
//		{
//			
//			HashMap<String, String> dataHashMap1 = new HashMap<String, String>();
//			dataHashMap1.put("email", "automationtesting11@gmail.com");
//			dataHashMap1.put("password", "Testing@1");
//			dataHashMap1.put("product", "Banarsi Saree");
//			
//			HashMap<String, String> dataHashMap2 = new HashMap<String, String>();
//			dataHashMap2.put("email", "rahulshetty@gmail.com");
//			dataHashMap2.put("password", "Iamking@000");
//			dataHashMap2.put("product", "IPHONE 13 PRO");
//			
//			return new Object[][]{{dataHashMap1},{dataHashMap2}};
//			
//		}
//		

		
		//By Object
//		@Test(dataProvider = "getDataByValue",groups = {"Purchase"})
//		public void submitOrder(String email,String password, String product){		
//		ProductCataloguePage productCataloguePage = landingPage.loginToApplication(email, password);
//		productCataloguePage.selectProduct(product);
//		CartPage cartPage = productCataloguePage.goToCart();
//		boolean value = cartPage.verifySelectedProduct(product);
//		AssertJUnit.assertTrue(value);
//		CheckoutPage checkoutPage = cartPage.goToCheckoutPage();
//		checkoutPage.selectCountry("ind");
//		ConfirmationPage confirmationPage = checkoutPage.submit();
//		String Successtext = confirmationPage.getConfirmationMessage();
//		AssertJUnit.assertTrue(Successtext.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		System.out.println("Done");		
//	}
//		@DataProvider
//		public Object[][] getDataByValue()
//		{
//			return new Object[][] {{"automationtesting11@gmail.com","Testing@1","Banarsi Saree"},{"rahulshetty@gmail.com","Iamking@000",
//				"IPHONE 13 PRO"
//			}};
//		}
		

}
