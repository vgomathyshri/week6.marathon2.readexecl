package selenium.week6.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceIndividual  extends SalesForceBase {
	
//	@Test
//	public void runSalesForceIndividual() throws InterruptedException{
	/*
	 * 01) Launch https://login.salesforce.com/ 
02) Login to Salesforce with your username and password
03) Click on the App Launcher (dots)
04) Click View All
05) Type Individuals on the Search box
06) Click Individuals Link
07) Click New
08) Select Salutation with data (coming from excel) 
09) Type Last Name 
10) Click Save
11) Click on the App Launcher (dots)
12) Click View All
13) Type Customers on the Search box
14) Click Customers Link
15) Click New
16) Type the same name provided in step 8 and confirm it appears
17) Close the browser

	 */
		@BeforeTest
		public void setExcelFile()
		{
			excelName = "SalesForceIndividual";
		}
		@Test(dataProvider = "fetchdata")
		public void runSalesForceIndividual(String lastName, String firstName) throws InterruptedException {
	
			driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("individuals");
			driver.findElement(By.xpath("//mark[text()='Individuals']")).click();
			driver.findElement(By.xpath("//a[@title='New']")).click();
			driver.findElement(By.xpath("//a[text()='--None--']")).click();
			driver.findElement(By.xpath("//a[@title='Mrs.']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys(lastName);
			driver.findElement(By.xpath("//button[@title='Save']")).click();
			Thread.sleep(12000);
			driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
			driver.findElement(By.xpath("//button[text()='View All']")).click();
			Thread.sleep(5000);
			WebElement findElement = driver.findElement(By.xpath("(//input[@class='slds-input'])[2]"));
			findElement.click();
			findElement.sendKeys("customer");	
			driver.findElement(By.xpath("//p[@class='slds-truncate']/mark[text()='Customer']")).click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//a[@title='New']")).click();
			driver.findElement(By.xpath("//input[@placeholder='Search Individuals...']")).sendKeys(lastName);
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@class='slds-m-left--smalllabels slds-truncate slds-media__body']//mark")).click();
			driver.findElement(By.xpath("//input[@class=' input']")).sendKeys(firstName);
			WebElement save = driver.findElement(By.xpath("(//span[text()='Save']/parent::button)[2]"));
			save.click();
			String text = driver.findElement(By.xpath("//div[@class='slds-form-element__control slds-grid itemBody']//a")).getText();
			if(text.contains(lastName))
			{
				System.out.println("LastName Verified");
			}
			
			
			
		}
		

	}


