package PankajShukla.Tests;

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

public class StandaloneApplicationBackup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String productNameString="ADIDAS ORIGINAL";
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		driver.findElement(By.id("userEmail")).sendKeys("automationtesting11@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Testing@1");
		driver.findElement(By.id("login")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products= driver.findElements(By.cssSelector(".mb-3"));
		WebElement productToBeSelected = products.stream().filter(product -> product.findElement(By.tagName("b")).getText().equalsIgnoreCase(productNameString)).findFirst().orElse(null);
		productToBeSelected.findElement(By.cssSelector("button:last-of-type")).click();
		
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
		driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
		
		List<WebElement>  selectedItemsElements = driver.findElements(By.cssSelector(".items"));
		boolean value = selectedItemsElements.stream().anyMatch(item -> item.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(productNameString));
		Assert.assertTrue(value);
		driver.findElement(By.cssSelector(".totalRow button")).click();
		
		Actions actions = new Actions(driver);
		actions.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")),"ind").build().perform();
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".ta-results"))));
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String Successtext = driver.findElement(By.tagName("h1")).getText();
		System.out.println(Successtext);
		Assert.assertTrue(Successtext.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		System.out.println("Done");
		
		driver.close();
			

	}

}
