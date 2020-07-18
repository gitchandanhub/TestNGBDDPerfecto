package Base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class AppDriver 
{
	public static  WebDriver driver = null;
	public static Properties conf  = new Properties();

    @BeforeTest
    public void launch() throws InterruptedException
    {
    	System.out.println(conf.getProperty("driverpath"));
    	//System.setProperty("webdriver.chrome.driver", conf.getProperty("driverpath"));
    	System.setProperty("webdriver.chrome.driver", "D:\\Software\\Selenium\\New Driver\\Chrome Driver 83\\chromedriver.exe");
    	System.setProperty("webdriver.chrome.silentOutput", "true");
    	driver = new ChromeDriver();
    	driver.manage().window().maximize();
    	Thread.sleep(1500);
    }
    
}
