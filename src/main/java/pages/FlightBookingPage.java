package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class FlightBookingPage extends BasePage{
	
	public FlightBookingPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		
	}
	
	@FindBy(xpath = "//td[@class='frame_action_xrows']/input[@name='outFlight']")
    public  List<WebElement>  checkButtonofDepart;
	
	//input[@name="tripType"][@value="oneway"]
	//input[@name="tripType"][@value="roundtrip"]
	//select[@name="passCount"] passenger
	//select[@name="fromMonth"] On
	//select[@name="fromPort"] fromPort
	//select[@name="toPort"]
	//select[@name="toMonth"] returning date
	//select[@name="toDay"]
	//select[@name="fromDay"]
	//input[@name="servClass"][@value="Business"]
	//input[@name="servClass"][@value="First"]
	//input[@name="servClass"][@value="Coach"]
	//select[@name="airline"]
	//input[@name="findFlights"]
	//td[@class="frame_action_xrows"]/input[@name="outFlight"]
	//td[@class="frame_action_xrows"]/input[@name="outFlight"][@value="Unified Airlines$363$281$11:24"]
	//td[@class="frame_action_xrows"]/input[@name="inFlight"][@value="Unified Airlines$633$303$18:44"]
	//table[@bgcolor="ffffff"]/tbody/tr[3]/td[3] price check
	//table[@bgcolor="ffffff"]/tbody/tr[6]/td[3] return price check
	//input[@name="passFirst0"] first passenger
	//input[@name="passLast0"] last passenger
	//select[@name="pass.0.meal"]
	//input[@name="cc_frst_name"]
	//input[@name="creditnumber"]
	//input[@name="cc_mid_name"]
	//input[@name="cc_last_name"]
	//input[@name="billAddress1"]
	//input[@name="billAddress2"]
	//input[@name="billCity"]
	//input[@name="billState"]
	
	@FindBy(xpath = "//*[contains(text(),'Flights')]")
	public WebElement flightButton;
	

}
