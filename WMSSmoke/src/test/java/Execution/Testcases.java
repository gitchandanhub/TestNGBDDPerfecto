package Execution;

import org.testng.annotations.Test;

import Base.AppDriver;
import Pages.Dashboard;
import Pages.Loginpage;
import Pages.POmaster;
import Utility.VerifyImages;

public class Testcases extends AppDriver 
{
              @Test(priority =0)
              public void LoginTest() throws InterruptedException
              {
            	  Loginpage  lpobj = new Loginpage();
            	  lpobj.Enterusername(config.getProperty("Username"));
            	  lpobj.Enterpsswrd(config.getProperty("Password"));
            	  lpobj.clickbtn();
              }
              @Test(priority =1)
              public void verifyImages()
              {
            	  VerifyImages  viobj = new VerifyImages();
            	  viobj.ValidateImage();
              }
              @Test(priority = 2)
              public void Addpomaster() throws InterruptedException
              {
            	  Dashboard dbobj = new Dashboard();
            	  dbobj.Clickreceiving();
            	  dbobj.Clickpo();
            	  dbobj.Addpo();
            	  POmaster poobj = new POmaster();
            	  poobj.clickvendor();
            	  
              }
              @Test(priority =3)
              public void podetail()
              {
            	  
              }
}
