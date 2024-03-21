package mavenpackage1;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class datadrivenproj1 {
public static void main(String[] args) throws IOException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\wwwvi\\OneDrive\\Desktop\\selenium drivers\\chromedriver-win32\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();	
			String url="https://www.saucedemo.com/";
		driver.get(url);
		driver.manage().window().maximize();
		
         FileInputStream excel=new FileInputStream("C:\\Users\\wwwvi\\OneDrive\\Desktop\\excelsheet\\login.xlsx");
 		//FileOutputStream fout=new FileOutputStream("C:\\Users\\wwwvi\\OneDrive\\Desktop\\excelsheet\\login.xlsx");
 		
		XSSFWorkbook wb=new XSSFWorkbook(excel);//Used to reading and writing open office xml(xlsx) format files.
		//wb.write(fout);
		
		XSSFSheet sh=wb.getSheet("login");
		System.out.println(sh.getLastRowNum());
		
		
		for(int i=1;i<=sh.getLastRowNum();i++)
		{
		driver.findElement(By.xpath("//*[@name='user-name']")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
		driver.findElement(By.xpath("//*[@id='login-button']")).click();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equals("https://www.saucedemo.com/"))
		{
			System.out.println("Login Failed");
			sh.getRow(i).createCell(2).setCellValue("Failed");
		}
		else
		{
			System.out.println("Logged in Successfully");
			sh.getRow(i).createCell(2).setCellValue("Successful");
		}
		FileOutputStream fout=new FileOutputStream("C:\\Users\\wwwvi\\OneDrive\\Desktop\\excelsheet\\login.xlsx");
		wb.write(fout);
		driver.get("https://www.saucedemo.com/");
		
		
		
		}}}