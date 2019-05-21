package Myfirstproject.Myfirstproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateAccount {
	
	public static void main (String [] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		/*
		 * File filepathurl = new
		 * File("/Myfirstproject/src/main/java/testdata/MyJohnLewisLoginData.xlsx");
		 * FileInputStream file = new FileInputStream(filepathurl); 
		 * XSSFWorkbook workbook = new XSSFWorkbook(file); 
		 * XSSFSheet sheet = workbook.getSheetAt(0);
		 * Row row = sheet.getRow(0); 
		 * Cell cell = row.getCell(0);
		 * System.out.println(sheet.getRow(0).getCell(0));
		 */
		try {
		BufferedReader br = null;
		br = new BufferedReader(new FileReader("/Myfirstproject/rc/main/java/testdata/johntest.txt"));
		String s = br.readLine();
		System.out.println(s);
		br.close();
		} catch (IOException e) {
			System.out.println("no file");			
		}

		driver.get("https://www.amazon.co.uk/");
		driver.findElement(By.xpath("//span[contains(text(),'Hello, Sign in')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create your Amazon account')]")).click();
		driver.findElement(By.id("ap_customer_name")).sendKeys("Bhuvana");
		driver.findElement(By.id("ap_email")).sendKeys("test1@gmail.com");
		System.out.println(driver.getTitle());
		driver.close();

		
	}

}
