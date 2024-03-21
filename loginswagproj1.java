package mavenpackage1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginswagproj1 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\wwwvi\\OneDrive\\Desktop\\selenium drivers\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		WebElement user=driver.findElement(By.id("user-name"));
		user.click();
		user.sendKeys("standard_user");
		Thread.sleep(2000);
		
		WebElement pass=driver.findElement(By.xpath("//*[@id=\"password\"]"));
		pass.click();
		pass.sendKeys("secret_sauce");
		Thread.sleep(2000);
		
		WebElement login=driver.findElement(By.id("login-button"));
		login.click();
		Thread.sleep(2000);
		
		driver.close();

	}

}
