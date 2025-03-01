package PankajShukla.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import PankajShukla.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents{

	WebDriver driver;
	
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="[placeholder='Select Country']")
	WebElement  selectCountry;
	
	@FindBy(css=".ta-results")
	WebElement  countryOptions;
	
	@FindBy(css=".action__submit")
	WebElement  submitButton;
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement countryToBeSelected;
	
	
	public void selectCountry(String countryName)
	{
		getActionsInitializer().sendKeys(selectCountry,countryName).build().perform();
		visibilityByElementWait(countryOptions);
		countryToBeSelected.click();
	}
	
	
	public ConfirmationPage submit()
	{
		submitButton.click();
		ConfirmationPage confirmationPage = new ConfirmationPage(driver);
		return confirmationPage;
	}
	
}
