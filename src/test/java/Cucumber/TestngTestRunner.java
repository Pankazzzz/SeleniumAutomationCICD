package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/cucumber", glue = "PankajShukla.StepDefinition", tags="@Regression" ,monochrome = true, plugin = {"html:target/cucumber.html"})
public class TestngTestRunner extends AbstractTestNGCucumberTests{
	
	

}
