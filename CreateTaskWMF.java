package task.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateTaskWMF {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf@1234");
		driver.findElement(By.id("Login")).click();
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		driver.findElement(By.xpath("//button[text()='View All']")).click();
        driver.findElement(By.xpath("//p[text()='Sales']")).click();
        WebElement opp=driver.findElement(By.xpath("//a[@title='Tasks']"));
        driver.executeScript("arguments[0].click();", opp);
        driver.findElement(By.xpath("//button[@title='Display as Split View']")).click();
        driver.findElement(By.xpath("//li[@title='Table']")).click();
		driver.findElement(By.xpath("//div[@title='New Task']")).click();
		WebElement a = driver.findElement(By.xpath("//input[@title='Search Contacts']"));
		driver.executeScript("arguments[0].click();", a);
		driver.findElement(By.xpath("//div[@title='Jane Doe']")).click();
		driver.findElement(By.xpath("//textarea[@class='textarea textarea uiInput uiInputTextArea uiInput--default uiInput--textarea']")).sendKeys(" SALES+C6 FORCE Automation Using Selenium");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
	    String actual_Error=driver.findElement(By.xpath("(//div[text()='Complete this field.'])[1]")).getText();
	    String expected_Error= "Complete this field.";
	    Assert.assertEquals(actual_Error,expected_Error);
	    Assert.assertTrue(actual_Error.contains("Complete this field."));
	
	}

}
