package Utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.AppDriver;

public class NavigateUrl extends AppDriver
{

	public void openurl() throws InterruptedException
	{
		List<WebElement> alist = driver.findElements(By.tagName("a"));
    	System.out.println(alist.size());
  	  for(int i =0; i<alist.size(); i++)
  	  {
  		  String url = alist.get(i).getAttribute("href");
  		//  System.out.println(url);
  		  System.setProperty("webdriver.chrome.driver", config.getProperty("Chropath"));
          System.setProperty("webdriver.chrome.silentOutput", "true");
  		  driver = new ChromeDriver();
  		  try
  		  {
  		  driver.navigate().to(url);
  		  System.out.println("Navigating to" + " " +url);
  		  Thread.sleep(3000);
  		   if(driver.findElement(By.xpath("//*[@id='main-message']/h1/span")).isDisplayed())
		    {
			//String text = driver.findElement(By.xpath("//*[@id='main-message']/h1/span")).getText();
            System.out.println(url +" "+" is Not working");
		    }
  		   else
  		   {
  			 System.out.println(url +" "+" is  working");
  		   }
  		  }
  		  catch(Exception e)
  		  {
  			  
  		  }
  		  driver.close();
  	  }
	}
}
