package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class AppDriver
	{
	     public static WebDriver driver = null;
	     public static Properties config = new Properties();
	     public static Logger log=Logger.getLogger("devpinoyLogger");
	     public static ExtentHtmlReporter htmlreporter;
	     public static ExtentReports extentreport;
	     public static ExtentTest extenttest; 
	     @BeforeTest
	      public void Initialize() throws Exception {
	    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	    	   LocalDateTime now = LocalDateTime.now();  
	    	   String x = dtf.format(now);
	    	   htmlreporter = new ExtentHtmlReporter("D:\\Software\\Oxygen_workspace\\WMSSmoke\\Report\\Steriaresult.html");
	    	  //htmlreporter = new ExtentHtmlReporter(config.getProperty("ExtentReport_path")+"Steriaresult"+dtf.format(now)+".html");
	    	     
	    	     htmlreporter.config().setEncoding("utf-8");
	    	     htmlreporter.config().setDocumentTitle("Automation Test");
	    	     htmlreporter.config().setReportName("Automation result");
	    	     htmlreporter.config().setTheme(Theme.STANDARD);      
	    	      extentreport = new ExtentReports();
	    	      extentreport.setSystemInfo("Organization", "way2testing");    
	    	    extentreport.attachReporter(htmlreporter);    
	    	  FileInputStream fis = new FileInputStream("D:\\Software\\Oxygen_workspace\\WMSSmoke\\src\\test\\java\\Property\\config.properties");
	    	  config.load(fis);
	    	  if(config.getProperty("BrowserName").equalsIgnoreCase("Chrome"))
	    	  {
	    		  
	    		  System.setProperty("webdriver.chrome.driver", config.getProperty("Chropath"));
	              System.setProperty("webdriver.chrome.silentOutput", "true");
	              DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	      		// To Accept SSL certificate
	              capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	              ChromeOptions options = new ChromeOptions();
	              options.addArguments("--incognito");
	              
	              capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	    		  driver = new ChromeDriver(capabilities);
	    		  
	    	  }
	    	  else  if(config.getProperty("BrowserName").equalsIgnoreCase("Firefox"))
	          {
	       	   System.setProperty("webdriver.gecko.driver", config.getProperty("FireFoxDriver_path"));
	       	   driver = new FirefoxDriver();
	          }
	          else  if(config.getProperty("BrowserName").equalsIgnoreCase("IE"))
	          {
	       	   System.setProperty("webdriver.internetExplorer.driver", config.getProperty("InternetExplorerpath"));
	       	   driver = new InternetExplorerDriver();
	          }
	          driver.manage().window().maximize();
	          driver.manage().timeouts().implicitlyWait(Utility.wait.Implicitwait, TimeUnit.SECONDS);
	          driver.navigate().to(config.getProperty("Url"));
	          try
    		  {
    			  driver.findElement(By.xpath("//*[@id='details-button']")).click();
    			  System.out.println("Advanced option clicked");
    			  Thread.sleep(2000);
    			  driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
    			  Thread.sleep(2000);
    		  }
    		  catch(Exception e)
    		  {
    			  
    		  }
	          Thread.sleep(4000);
	      }
	      
	      @AfterTest
	      public void close()
	      {
	    	  extentreport.flush();
	    	 // driver.quit();
	      }
	
}
