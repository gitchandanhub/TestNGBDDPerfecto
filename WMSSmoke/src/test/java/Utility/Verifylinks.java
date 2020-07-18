package Utility;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Base.AppDriver;

public class Verifylinks extends AppDriver
{
	public void linktest() throws IOException, InterruptedException
	{
		List alllinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links are :- " + alllinks.size());
		if(alllinks.size()==0)
		{
			driver.navigate().refresh();
			Thread.sleep(3000);
			g();
		}
		else
		{
			g();
		}
	}
	public void g() throws IOException, InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		List alllinks = driver.findElements(By.tagName("a"));
		if(alllinks.size()==0)
		{
			driver.navigate().refresh();
			Thread.sleep(3000);
			linktest();
		}
		for(int i = 0; i<alllinks.size(); i++)
		{
			WebElement links = (WebElement) alllinks.get(i);
			String inputlink = links.getAttribute("href");
			URL testlink = new URL(inputlink);
			//URL testlink = new URL(null, inputlink, new sun.net.www.protocol.https.Handler());
			try
			{
			HttpURLConnection huc = (HttpURLConnection)testlink.openConnection();
			huc.setConnectTimeout(4000);
			huc.connect();
			
				if(huc.getResponseCode()==200)
				{
					System.out.println(testlink + "--" +huc.getResponseMessage());
				}
				if(huc.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)
				{
					System.out.println(testlink + "--" + huc.getResponseMessage() + "--" + HttpURLConnection.HTTP_NOT_FOUND);
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception occured--" + e);
			}
		}

	}
}
