package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	
WebDriver driver;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderedProductName;

	public Boolean validateOrderedProduct(String productName)
	{
		return orderedProductName.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
	}
}
