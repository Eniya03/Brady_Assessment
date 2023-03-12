import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TradingView {
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		
	 
		System.setProperty("webdriver.chrome.driver","/Users/eniyasundaram/Downloads/chromedriver");
		 

		driver = new ChromeDriver(); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		driver.get("https://www.tradingview.com/markets/currencies/rates-all/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[@class='tv-header__area tv-header__area--user']/button[1]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Sign in')]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@class='i-clearfix']/div/span")).click();
	 
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.name("username")).sendKeys("eniyasundaram40@gmail.com");
		driver.findElement(By.name("password")).sendKeys("password@123");
		
		WebElement submit = driver.findElement(By.xpath("//button[@type='submit']"));
		submit.click();
		
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//div[@class=\"recaptchaContainer-ZXbT4bae\"]/div/div/iframe")));
       wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@id='recaptcha-anchor']"))).click();
       
       Thread.sleep(20000);
       driver.switchTo().defaultContent();
       submit.click();
       Thread.sleep(1000);
      
       
       driver.findElement(By.xpath("//a[@href='/markets/currencies/rates-asia/']")).click();
      
       driver.findElement(By.xpath("//div[@class='tv-header__area tv-header__area--search']")).click();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
       driver.findElement(By.xpath("//input[@name='query']")).sendKeys("FX: GBPJPY");
     
       
       Actions action = new Actions(driver);
		WebElement Element = driver.findElement(By.xpath("//div[@class='cell-DPHbT8fH descriptionCell-DPHbT8fH']"));
		action.moveToElement(Element).perform();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 
		 JavascriptExecutor j = (JavascriptExecutor) driver;

	      
	     WebElement element = driver.findElement(By.xpath("//button[contains(text(),'See overview')]"));
	       ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style','visibility:visible;');",
	              element);
	       j.executeScript("arguments[0].click();", element);
	        
	        
       
	
		
	       String Actual= driver.getTitle();
	       String Expected= "GBP JPY Chart – Pound to Yen Rate — TradingView";
	       Assert.assertEquals(Expected, Actual);
	        
	   	driver.close();
		
	        
	}

}	
