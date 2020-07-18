package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.AppDriver;

public class Loginpage extends AppDriver
{
                public Loginpage()
                {
                	PageFactory.initElements(driver, this);
                }
                
                @FindBy(id = "Login1_UserName")  WebElement usernm;
                @FindBy(id = "Login1_Password")  WebElement userpd;
                @FindBy(xpath = "//span[contains(text(),'Log In')]")  WebElement loginbutton;
                
                public void Enterusername(String usenm) throws InterruptedException
                {
                	usernm.clear();
                	usernm.sendKeys(usenm);
                	Thread.sleep(1000);
                	log.info("Username Entered" + " " +usenm );
                	System.out.println("Username Entered" + " " +usenm );
                }
                public void Enterpsswrd(String pwd) throws InterruptedException
                {
                	userpd.clear();
                	userpd.sendKeys(pwd);
                	Thread.sleep(1000);
                	log.info("Password Entered" + " " +pwd );
                	System.out.println("Password Entered");
                }
                public void clickbtn() throws InterruptedException
                {
                	loginbutton.click();
                	Thread.sleep(4000);
                	log.info("Login button clicked");
                	System.out.println("Login button clicked");
                }
}
