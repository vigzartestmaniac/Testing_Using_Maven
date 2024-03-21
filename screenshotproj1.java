package mavenpackage1;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class screenshotproj1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\wwwvi\\OneDrive\\Desktop\\selenium drivers\\chromedriver-win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		
		File file1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file1, new File("E:\\java\\imgfiles\\mavenscreenshot2.png"));
		System.out.println("Screenshot saved succesfully");
		
		driver.close();
		
		
		

	}

	

}
