package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.AppDriver;

public class POmaster extends AppDriver
{
           public POmaster()
           {
        	   PageFactory.initElements(driver, this);
           }
           
           @FindBy(id = "txtRefSoNos")  WebElement soref;
           @FindBy(id = "cmbVendor_Input")  WebElement vendor;
           @FindBy(xpath = "//*[@id='cmbVendor_DropDown']/div[1]/ul/li[2]")  WebElement vendoritem;
           
           public void clickvendor() throws InterruptedException
           {
        	   vendor.click();
        	   Thread.sleep(2000);
        	   vendoritem.click();
           }
}
