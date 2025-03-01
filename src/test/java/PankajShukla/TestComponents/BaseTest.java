package PankajShukla.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.checkerframework.common.reflection.qual.NewInstance;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import PankajShukla.PageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws Exception
	{
		
		Properties prop = new Properties();
		FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/PankajShukla/Resources/Helper.properties");
		prop.load(fileInputStream);
		
		String browser = System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browser.contains("chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			if(browser.contains("headless"))
			{
				options.addArguments("headless");
			}
			
			driver = new ChromeDriver(options);	
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonData(String filePath) throws Exception
	{
	 
			String jsoonContent = Files.readString(Paths.get(filePath));
			
			ObjectMapper mapper = new ObjectMapper();
			List<HashMap<String, String>> data = mapper.readValue(jsoonContent, new TypeReference<List<HashMap<String, String>>>() {
			});
			
			return data;
			
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		 TakesScreenshot ts = (TakesScreenshot)driver;
		  File source = ts.getScreenshotAs(OutputType.FILE);
		  File destFile = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
		  FileHandler.copy(source, destFile);
		  return destFile.getAbsolutePath();	  
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage loadApplication() throws Exception
	{
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.goToApplication();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeDriver()
	{
		driver.close();
	}
	
	




}
