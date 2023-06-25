package task.salesforce;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class CreateFollowupTask {

	public static void main(String[] args) throws InterruptedException {
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
		driver.findElement(By.xpath("//p[text()='Content']")).click();
		WebElement p = driver.findElement(By.xpath("(//span[@class='viewAllLabel'])[3]"));
	    driver.executeScript("arguments[0].click();", p);
	    WebElement c = driver.findElement(By.xpath("//div[@class='test-listviewdisplayswitcher forceListViewManagerDisplaySwitcher']"));
		c.click();
		 driver.findElement(By.xpath("//li[@title='Table']")).click();
		 WebElement b = driver.findElement(By.xpath("(//a[@title='Bootcamp'])[1]"));
	    driver.executeScript("arguments[0].click();", b);
	    WebElement d = driver.findElement(By.xpath("(//a[@class='slds-grid slds-grid--vertical-align-center slds-grid--align-center sldsButtonHeightFix'])[2]"));
	    driver.executeScript("arguments[0].click();", d);
	    WebElement e = driver.findElement(By.xpath("//a[@title='Create Follow-Up Task']"));
	    driver.executeScript("arguments[0].click();", e);
	    WebElement r = driver.findElement(By.xpath("(//input[@type='text'])[2]"));
	    driver.executeScript("arguments[0].click();", r);
	    r.clear();
	    WebElement f = driver.findElement(By.xpath("//span[@title='Call']"));
	    driver.executeScript("arguments[0].click();", f);

	    WebElement h = driver.findElement(By.xpath("(//div[@class='uiMenu'])[8]//a"));
	    driver.executeScript("arguments[0].click();", h);
	    
	    WebElement g = driver.findElement(By.xpath("(//a[text()='High'])[1]"));
	    driver.executeScript("arguments[0].click();", g);
	    
	    WebElement i = driver.findElement(By.xpath("(//div[@class='uiMenu'])[7]//a"));
	    driver.executeScript("arguments[0].click();", i);
	    WebElement j = driver.findElement(By.xpath("(//a[text()='In Progress'])[1]"));
	    driver.executeScript("arguments[0].click();", j);
	    
	    WebElement k = driver.findElement(By.xpath("(//a[contains(@class,'entityMenuTrigger slds-button slds-button--icon slds-shrink-none slds-m-vertical--xxx-small slds-grid slds-grid_align-center')])[2]"));
	    driver.executeScript("arguments[0].click();", k);
	    WebElement l1 = driver.findElement(By.xpath("//span[@title='Contacts']"));
		driver.executeScript("arguments[0].click();", l1); 
		WebElement o = driver.findElement(By.xpath("//input[@title='Search Contacts']"));
		driver.executeScript("arguments[0].click();", o);
		driver.findElement(By.xpath("(//div[@title='Iswarya Uppliappan'])[1]")).click();
	    WebElement k1 = driver.findElement(By.xpath("(//a[contains(@class,'entityMenuTrigger slds-button slds-button--icon slds-shrink-none slds-m-vertical--xxx-small slds-grid slds-grid_align-center')])[3]"));
	    driver.executeScript("arguments[0].click();", k1);
	    JavascriptExecutor js1=(JavascriptExecutor)driver;
		js1.executeScript("window.scrollBy(0,-120)");
		Thread.sleep(2000);
		WebElement l = driver.findElement(By.xpath("//span[@title='Products']"));
		driver.executeScript("arguments[0].scrollIntoView(true)", l);  
		driver.executeScript("arguments[0].click();", l); 
		WebElement o1 = driver.findElement(By.xpath("//input[@title='Search Products']"));
		driver.executeScript("arguments[0].click();", o1);
		driver.findElement(By.xpath("(//div[@title='TL'])[1]")).click();
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		String actual_Result=driver.findElement(By.xpath("//span[@class='toastMessage slds-text-heading--small forceActionsText']")).getText();
		String expected_Result="Task \"Call\" was created.";
		Assert.assertEquals(actual_Result,expected_Result);
	}

}
