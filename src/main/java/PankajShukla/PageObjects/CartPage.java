package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import PankajShukla.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	
WebDriver driver;
	
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".items")
	List<WebElement>  selectedItemsElements;
	
	@FindBy(css=".totalRow button")
	WebElement goToCheckoutPage;
	
	public boolean verifySelectedProduct(String productName)
	{ 
		boolean value;
		value = selectedItemsElements.stream().anyMatch(item -> item.findElement(By.cssSelector("h3")).
				getText().equalsIgnoreCase(productName));
		return value;
	}
	
	public CheckoutPage goToCheckoutPage()
	{
		goToCheckoutPage.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}

}
