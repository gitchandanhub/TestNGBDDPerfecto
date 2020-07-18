package Utility;

import java.util.List;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.apache.http.HttpResponse;

import Base.AppDriver;

public class VerifyImages extends AppDriver
{
      public void ValidateImage()
      {
    	  List<WebElement> imagesList = driver.findElements(By.tagName("img")); 
    	  for(WebElement imgElement : imagesList)
    	  {
    		 if(imagesList != null)
    		 {
    			 try 
    			 { 
    				   HttpClient client = HttpClientBuilder.create().build(); 
    				   HttpGet request = new HttpGet(imgElement.getAttribute("src")); 
    				   HttpResponse response = client.execute(request); 

    				   // verifying response code he HttpStatus should be 200 if not, 
    				   // increment as invalid images count 

    				   if (response.getStatusLine().getStatusCode() != 200) 
    				   {
    					   System.out.println("Image is broken" + " " +imgElement.getAttribute("src"));
    				   }
    			 } 
    			       catch (Exception e)
    			       { 
    				     //e.printStackTrace(); 
    				   }
    		 }
    	  }
      }
}
