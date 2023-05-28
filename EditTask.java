package task.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class EditTask {

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
        driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[3]")).click();
        driver.findElement(By.xpath("(//span[text()='Recently Viewed'])[5]")).click();
        WebElement x = driver.findElement(By.xpath("(//div[@class='forceVirtualActionMarker forceVirtualAction'])[1]"));
        x.click();
        WebElement y = driver.findElement(By.xpath("//div[text()='Edit']"));
        driver.executeScript("arguments[0].click();", y);
        WebElement c = driver.findElement(By.xpath("(//input[@type='text'])[5]"));
        c.sendKeys("05/27/2023");
        WebElement e = driver.findElement(By.xpath("(//div[@class='uiPopupTrigger'])[8]"));
       e.click();
        WebElement f = driver.findElement(By.xpath("//a[@title='Low']"));
        f.click();
        driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
        String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Task \"Bootcamp\" was saved.";
		Assert.assertEquals(actual_Result,expected_Result);
        
        
	}

}
