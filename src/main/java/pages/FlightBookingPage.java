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
	
	
	@FindBy(xpath = "//*[contains(text(),'Flights')]")
	public WebElement flightButton;
	

}
