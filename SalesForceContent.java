package selenium.week6.marathon;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceContent extends SalesForceBase {
@BeforeTest
public void setExcelFile()
{
	excelName = "SalesForceContent";
}
	@Test(dataProvider = "fetchdata")
	public void runSalesForceContent(String question, String answer)  throws InterruptedException {
		/*
		 * 01) Launch https://login.salesforce.com/ 
02) Login to Salesforce with your username and password
03) Click on the App Launcher (dots)
04) Click View All
05) Type Content on the Search box
06) Click Content Link
07) Click on Chatter Tab
08) Verify Chatter title on the page
09) Click Question tab
10) Type Question with data (coming from excel)
11) Type Details with data (coming from excel)
12) Click Ask
13) Confirm the question appears
14) Close the browser
		 */
		
		driver.findElement(By.xpath("//input[@class='slds-input']")).sendKeys("content");
		driver.findElement(By.xpath("//mark[text()='Content']")).click();
		Thread.sleep(5000);
		WebElement chatter = driver.findElement(By.xpath("//a[@title='Chatter']"));
		driver.executeScript("arguments[0].click()",chatter);		
		driver.findElement(By.xpath("//span[text()='Question']")).click();
		driver.findElement(By.xpath("//textarea[contains(@placeholder,'What would you like')]")).sendKeys(question);
		driver.findElement(By.xpath("//div[contains(@data-placeholder,'If you have more to say')]")).sendKeys(answer);
		driver.findElement(By.xpath("//button[text()='Ask']")).click();
		String text = driver.findElement(By.xpath("//div[@data-aura-class='forceChatterFeedBodyQuestionWithoutAnswer']/span")).getText();
		if(text.contains(question))
		{
			System.out.println("Question Verified");
		}
		
		
		
		
	}

}
