package task.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateTask {

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
		WebElement e = driver.findElement(By.xpath("(//span[text()='Global Actions'])[1]"));
		driver.executeScript("arguments[0].click();", e);
		driver.findElement(By.xpath("//a[@title='New Task']")).click();
		driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("Bootcamp");
		WebElement f = driver.findElement(By.xpath("(//div[@class='uiMenu'])[3]"));
		f.click();
		WebElement c = driver.findElement(By.xpath("//a[@title='Waiting on someone else']"));
		driver.executeScript("arguments[0].click();", f);
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Task \"Bootcamp\" was created.";
		Assert.assertEquals(actual_Result,expected_Result);
	}

}
