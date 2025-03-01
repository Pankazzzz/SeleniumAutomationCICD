package PankajShukla.PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import PankajShukla.AbstractComponents.AbstractComponents;

public class ConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
		
		public ConfirmationPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	@FindBy(tagName="h1")
	WebElement successText;
	
	public String getConfirmationMessage()
	{
		System.out.println(successText.getText());
		return successText.getText();
	}


}
