package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.AppDriver;

public class Dashboard  extends AppDriver 
{
     public Dashboard()
     {
    	 PageFactory.initElements(driver, this);
     }
     
     @FindBy(xpath = "//*[@id='ctl00_MenuTab']/div[1]/ul/li[2]/a/span/span/span")   WebElement receiving;
     @FindBy(xpath = "//a[@class='rtsLink rtsAfter underfirstline']//span[@class='rtsTxt'][contains(text(),'Receiving')]")   WebElement receiving1;
     @FindBy(xpath = "//*[@id='ctl00_MenuTab']/div[2]/ul[2]/li[1]/a/span/span/span") WebElement purchaseorder;
     @FindBy(xpath = "//a[@class='rtsLink underfirstline']//span[@class='rtsTxt'][contains(text(),'Purchase Order')]") WebElement purchaseorder1;
     @FindBy(xpath = "//*[@id='ctl00_ContentPlaceHolder1_POGrid_ctl00_ctl02_ctl00_btnAdd']")  WebElement addbutton;
     public void Clickreceiving() throws InterruptedException
     {
    	 receiving.click();
    	 Thread.sleep(2000);
    	 System.out.println("clicked on receiving");
     }
     public void Clickpo() throws InterruptedException
     {
    	 purchaseorder.click(); 
    	 Thread.sleep(2000);
    	 System.out.println("clicked on PO");
     }
     public void Addpo() throws InterruptedException
     {
    	 addbutton.click(); 
    	 Thread.sleep(3000);
    	 System.out.println("clicked on ADD button");
    	 driver.switchTo().frame("winPopup");
    	 System.out.println("Switched to opup window");
    	 Thread.sleep(4000);
    	 
    	 
     }
}
