package PankajShukla.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PankajShukla.PageObjects.CartPage;
import PankajShukla.PageObjects.OrderPage;
//Git
public class AbstractComponents {
	
WebDriver driver;
WebDriverWait wait;
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@FindBy(css="[routerlink*=cart]")
	WebElement goToCart;
	
	@FindBy(css="[routerlink*=myorders]")
	WebElement goToOrder;
	
	public CartPage goToCart()
	{
		goToCart.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrder()
	{
		goToOrder.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	
	public void visibilityByWait(By findBy)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void visibilityByElementWait(WebElement waitElement)
	{
		wait.until(ExpectedConditions.visibilityOf(waitElement));
	}

	public void invisibilityByWait(By findBy)
	{
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
	
	public void invisibilityByElementWait(WebElement waitElement)
	{
		wait.until(ExpectedConditions.invisibilityOf(waitElement));
	}
	
	public Actions getActionsInitializer()
	{
		Actions actions = new Actions(driver);
		return actions;
	}
	
	

}
