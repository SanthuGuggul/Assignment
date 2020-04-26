package tests.ui;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pages.FlightBookingPage;
import pages.SignInPage;
import utils.BasePage;

public class FlightBookingPageTest {
	
	public String sheetname="FlightBookingPage",workbook = "UITestData";

	private FlightBookingPage flightBookingPage;
	public static WebDriver wdriver;
	private BasePage basePage=new BasePage(wdriver);
	
	
	@Test
	public void signInPageTest(HashMap<String,String> usrData) {
	
		System.out.println("LAUNCHING THE WEB APP FOR FLOW : " + usrData.get("TCID"));
		if (wdriver == null) {
			System.out.println("LAUNCHING THE WEB APP FOR FLOW : " + usrData.get("TCID"));
			wdriver=basePage.launchBrowser();
			
			
		}else if((wdriver != null)){
			System.out.println("LAUNCHING THE WEB APP FOR FLOW : " + usrData.get("TCID"));
		}
		
		flightBookingPage=new FlightBookingPage(wdriver);
	
	}
	
	
	

}
