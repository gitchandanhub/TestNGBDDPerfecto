package Modules;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import ExcelUtility.Readwriteexcel;

public class EmailFinder
{
	File src;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	FileOutputStream fos;
	AtomicInteger count1 = new AtomicInteger(1);
	AtomicInteger count = new AtomicInteger(1);
	@BeforeTest
	public void launch() throws IOException
	{
		
	
		System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\New Driver\\Chrome Driver 83");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		src = new File("D:\\Software\\Database_2020\\db shop database\\allindiaschooldatabase (1)\\May 2020\\EmailsforUrl.xlsx");
		wb = new XSSFWorkbook(); 
		sheet = wb.createSheet("Email_details");	
		row = sheet.createRow((short)0);  
		row.createCell(0).setCellValue("URL");
		row.createCell(1).setCellValue("Email1");
		row.createCell(2).setCellValue("Email2");
		row.createCell(3).setCellValue("Email3");
		row.createCell(4).setCellValue("Email4");
		row.createCell(5).setCellValue("Email5");
		row.createCell(6).setCellValue("Email6");
		row.createCell(7).setCellValue("Email7");
		fos = new FileOutputStream(src); 
		wb.write(fos);

	}
	WebDriver driver;
	@Test
	public void test() throws InterruptedException, IOException
	{
		int lastrow = Readwriteexcel.getlastrownum("D:\\Software\\Database_2020\\db shop database\\allindiaschooldatabase (1)\\May 2020\\InputUrl.xlsx", 0);
		for(int i =1; i<lastrow; i++)
		{
			String Url = Readwriteexcel.readexcel("D:\\Software\\Database_2020\\db shop database\\allindiaschooldatabase (1)\\May 2020\\InputUrl.xlsx", 0, i, 0);
			System.out.println("Row started => " +i);
			try
			{
				driver.navigate().to(Url);
				Thread.sleep(3000);
				row = sheet.createRow((short)count.getAndIncrement());
				row.createCell(0).setCellValue(Url);
				fos = new FileOutputStream(src); 
				wb.write(fos);
				email();
			}
			catch(Exception e)
			{

			}
		}
	}
	public void email() throws InterruptedException, IOException
	{
		List<WebElement> list = driver.findElements(By.xpath(".//*[contains(text(), '@') and contains(text(), '.com')]"));
		if(list.size()!=0)
		{
			for(int i = 0; i<list.size(); i++)
			{
				String email = list.get(i).getText();	      
				int j = i+1;
				row.createCell(j).setCellValue(email);
				fos = new FileOutputStream(src); 
				wb.write(fos);

			}
			list.clear();
		}
		else
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(1500);
			try
			{
				WebElement contact = driver.findElement(By.xpath(".//*[contains(text(), 'contact')]"));
				WebDriverWait wt = new WebDriverWait(driver, 5);
				wt.until(ExpectedConditions.elementToBeClickable(contact));
				contact.click();
				Thread.sleep(2000);
				contactus();
			}
			catch(Exception e)
			{
				System.out.println(e);
				try
				{
					WebElement contact =  driver.findElement(By.xpath(".//*[contains(text(), 'Contact')]"));
					WebDriverWait wt = new WebDriverWait(driver, 5);
					wt.until(ExpectedConditions.elementToBeClickable(contact));
					contact.click();
					Thread.sleep(2000);
					contactus();
				}
				catch(Exception e2)
				{
					System.out.println(e2);
					try
					{
						WebElement contact = driver.findElement(By.xpath(".//*[contains(text(), 'Contact Us')]"));
						WebDriverWait wt = new WebDriverWait(driver, 5);
						wt.until(ExpectedConditions.elementToBeClickable(contact));
						contact.click();
						Thread.sleep(2000);
						contactus();
					}
					catch(Exception e3)
					{
						System.out.println(e3);
						String curl = driver.getCurrentUrl();
						String newurl  = curl +"/contactus";
						driver.navigate().to(newurl);
						Thread.sleep(2000);
						contactus(); 
					}
				}
			}
		}
	}
	public void contactus() throws IOException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		List<WebElement> list2 = driver.findElements(By.xpath(".//*[contains(text(), '@') and contains(text(), '.com')]"));
		if(list2.size()!=0)
		{
			for(int i = 0; i<list2.size(); i++)
			{
				String email = list2.get(i).getText();	      
				int j = i+1;
				row.createCell(j).setCellValue(email);
				fos = new FileOutputStream(src); 
				wb.write(fos);
			}
			list2.clear();
		}
		else
		{
			List<WebElement> list3 = driver.findElements(By.xpath(".//*[contains(text(), '@')]"));
			if(list3.size()!=0)
			{
				for(int i = 0; i<list3.size(); i++)
				{
					String email = list3.get(i).getText();	      
					int j = i+1;
					row.createCell(j).setCellValue(email);
					fos = new FileOutputStream(src); 
					wb.write(fos);
				}
				list3.clear();
			}                
			else
			{
				List<WebElement> list4 = driver.findElements(By.xpath(".//*[contains(text(), '@')]"));
				if(list4.size()!=0)
				{
					for(int i = 0; i<list3.size(); i++)
					{
						WebElement element = driver.findElement(By.xpath(".//*[contains(text(), '@') and contains(text(), '.com')]"));
						String innerText = (String) ((JavascriptExecutor)driver).executeScript("return arguments[0].innerText", list4.get(i));
						int j = i+1;
						row.createCell(j).setCellValue(innerText);
						fos = new FileOutputStream(src); 
						wb.write(fos);
					}
				}

			}
		}
	}

}