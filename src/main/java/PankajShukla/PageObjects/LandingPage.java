package PankajShukla.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PankajShukla.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	public void goToApplication()
	{
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	}
	
	public ProductCataloguePage loginToApplication(String email,String password)
	{
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		loginButton.click();
		ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
		return productCataloguePage;
	}
	
	public String getErrorMessage()
	{
		visibilityByElementWait(errorMessage);
		return errorMessage.getText();
	}

}
