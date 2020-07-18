package Execution;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Base.AppDriver;
import Pages.ContactUs;
import Utility.Verifylinks;

public class TestCases extends AppDriver
{
      @Test(priority = 1)
      public void verifylinks() throws IOException, InterruptedException
      {
    	  Verifylinks obj = new Verifylinks();
    	  try {
    	  obj.linktest();
    	  }
    	  catch(Exception e)
    	  {
    		  
    	  }
      }
      @Test(priority = 0)
      public void verifyContact() throws InterruptedException
      {
    	  ContactUs con = new ContactUs();
    	  con.opencontactpage();
    	  con.EnterName(config.getProperty("Name"));
    	  con.EnterEmail(config.getProperty("Email"));
    	  con.Entermobile(config.getProperty("Mobile"));
    	  con.EnterDetail(config.getProperty("Details"));
    	  con.clicksubmit();
    	  con.getmsg();
    	  con.navigatehome();
      }
}
