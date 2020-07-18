
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sim_google 
{
	WebDriver driver;
	File src;
	File file;
	FileInputStream fis;
	XSSFWorkbook workbook;
	XSSFSheet shet;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	XSSFRow row;
	FileOutputStream fos;
	String name;
	String address;
	String number;
	String website;
	AtomicInteger count = new AtomicInteger(1);
	@BeforeTest
	public void g() throws InterruptedException, IOException
	{
		Proxy p=new Proxy();
	    p.setHttpProxy("45.77.156.187:8080");
	    DesiredCapabilities cap=new DesiredCapabilities();     
	      // Pass proxy object p
	    cap.setCapability(CapabilityType.PROXY, p);
	   System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\New Driver\\Chrome Driver 83\\chromedriver.exe");
	    driver = new ChromeDriver();
		//FirefoxOptions foptions = new FirefoxOptions();
	  // foptions.setCapability("marionette", false);
	   // driver = new FirefoxDriver(foptions);
	    driver.manage().window().maximize(); 
	    src = new File("D:\\Software\\Database_2020\\db shop database\\All India Medical june 2019\\mumgmedical.xlsx");
		wb = new XSSFWorkbook(); 
		sheet = wb.createSheet("res_details");	
		row = sheet.createRow((short)0);  
		row.createCell(0).setCellValue("Name");
		row.createCell(1).setCellValue("Address");
		row.createCell(2).setCellValue("Number");
		row.createCell(3).setCellValue("website");	
	    fos = new FileOutputStream(src); 
		wb.write(fos);
		driver.navigate().to("https://www.google.com/search?tbm=lcl&sxsrf=ALeKk02KKaBQz1SubrYTmF7WOH-btTErmg%3A1591871195364&ei=2wbiXoTgFdLZrQHzuoCoBg&q=medical+store+in+mumbai&oq=medical+store+in+mumbai&gs_l=psy-ab.3..0j0i7i30k1l6j0j0i7i30k1l2.2542.5034.0.6400.13.13.0.0.0.0.202.1613.0j9j1.10.0....0...1c.1.64.psy-ab..3.10.1604...0i13k1.0.g0SQlt_visA#rlfi=hd:;si:;mv:[[19.181369,72.903061],[18.901816999999998,72.80896969999999]];tbs:lrf:!1m4!1u3!2m2!3m1!1e1!1m4!1u16!2m2!16m1!1e1!1m4!1u16!2m2!16m1!1e2!2m1!1e16!2m1!1e3!3sIAE,lf:1,lf_ui:3");
		Thread.sleep(30000);
	}
	@Test
	public void h() throws InterruptedException, IOException
	{	
	List<WebElement> list = driver.findElements(By.cssSelector(".dbg0pd>div"));
	for(int i =0; i<list.size(); i++)
	{
		((JavascriptExecutor)driver).executeScript("scroll(10,400)");
		list.get(i).click();
		Thread.sleep(3000);
		row = sheet.createRow((short)count.getAndIncrement());
		
		fos = new FileOutputStream(src); 
		wb.write(fos);
		try
		{
			name = list.get(i).getText();
			row.createCell(0).setCellValue(name);
			fos = new FileOutputStream(src); 
			wb.write(fos);
		}
		catch(Exception e2)
		{
			try
			{
				 name = driver.findElement(By.xpath(".//*[@id='akp_uid_2']/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[1]/div/span")).getText();
				row.createCell(0).setCellValue(name);
				fos = new FileOutputStream(src); 
				wb.write(fos);
			}
			catch(Exception e3)
			{
				try
				{
				 name = driver.findElement(By.cssSelector(".FxvUNb.kno-ecr-pt.kno-fb-ctx.PPT5v.hNKfZe>span")).getText();
					row.createCell(0).setCellValue(name);
					fos = new FileOutputStream(src); 
					wb.write(fos);
				}
				catch(Exception e8)
				{
					
				}
			}
		}
		try
		{
			 address = driver.findElement(By.xpath(".//*[@id='akp_uid_2']/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div[2]/div/div/span[2]")).getText();
			row.createCell(1).setCellValue(address);
			fos = new FileOutputStream(src); 
			wb.write(fos);
		}
		catch(Exception e4)
		{
			try
			{
			 address = driver.findElement(By.cssSelector(".LrzXr")).getText();
				row.createCell(1).setCellValue(address);
				fos = new FileOutputStream(src); 
				wb.write(fos);
			}
			catch(Exception e5)
			{
				
			}
		}
		try
		{
			number = driver.findElement(By.xpath(".//*[@id='akp_uid_2']/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[2]/div/div[4]/div/div/span[2]/span/span")).getText();
			row.createCell(2).setCellValue(number);
			fos = new FileOutputStream(src); 
			wb.write(fos);
		}
		catch(Exception e6)
		{
			try
			{
			 number = driver.findElement(By.cssSelector(".LrzXr.zdqRlf.kno-fv>span>span")).getText();
				row.createCell(2).setCellValue(number);
				fos = new FileOutputStream(src); 
				wb.write(fos);
			}
			catch(Exception e7)
			{
				
			}
		}
		try
		{
		 website = driver.findElement(By.xpath(".//*[@id='akp_uid_2']/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div/div[1]/div/div[2]/div[1]/a")).getAttribute("href");
		row.createCell(3).setCellValue(website);
		fos = new FileOutputStream(src); 
		wb.write(fos);
		}
		catch(Exception e)
		{
			try
			{
				 website = driver.findElement(By.cssSelector(".CL9Uqc.ab_button")).getAttribute("href");
				row.createCell(3).setCellValue(website);
				fos = new FileOutputStream(src); 
				wb.write(fos);
			}
			catch(Exception e9)
			{
				
			}
		}
		
	}
	  
	list.clear();
	 k();
	}
public void k() throws InterruptedException, IOException
{
	driver.findElement(By.cssSelector("#pnnext>span")).click();
	   Thread.sleep(3000);
	   h();
}
}