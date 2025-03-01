package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.common.base.MoreObjects.ToStringHelper;

import PankajShukla.AbstractComponents.AbstractComponents;
import net.bytebuddy.matcher.MethodReturnTypeMatcher;

public class ProductCataloguePage extends AbstractComponents {
	
	
WebDriver driver;
	
	public ProductCataloguePage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	By productsVisible = By.cssSelector(".mb-3");
	By animationBy = By.cssSelector(".ng-animating");
	By addToCart = By.cssSelector("button:last-of-type");
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	@FindBy(css="#toast-container")
	WebElement toastContainer;
	
	
	public List<WebElement> getAllProducts()
	{
		visibilityByWait(productsVisible);
		return products;
	}
	
	public WebElement getProduct(String productName)
	{
		WebElement productToBeSelected;
		productToBeSelected = getAllProducts().stream().filter(product -> product.findElement(By.tagName("b"))
				.getText().equalsIgnoreCase(productName)).findFirst().orElse(null);
		return productToBeSelected;
	}
	
	public void selectProduct(String productName)
	{
		WebElement productElement = getProduct(productName);
		productElement.findElement(addToCart).click();
		invisibilityByWait(animationBy);
		invisibilityByElementWait(toastContainer);
	}
	
	
	
	

}
