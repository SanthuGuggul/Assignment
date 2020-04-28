package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class FlightBookingPage extends BasePage {

	public static String departKey;
	public static String arrivalKey;

	public FlightBookingPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);

	}

	// td[@class="frame_action_xrows"]/input[@name="outFlight"]
	@FindBy(xpath = "//td[@class='frame_action_xrows']/input[@name='outFlight']")
	public WebElement checkButtonofDepart;

	@FindBy(xpath = "//input[@name='tripType'][@value='oneway']")
	public WebElement oneWayTripType;
	@FindBy(xpath = "//input[@name='tripType'][@value='roundtrip']")
	public WebElement roundTripType;
	@FindBy(xpath = "//select[@name='passCount']")
	public WebElement passengerCount;

	@FindBy(xpath = "//select[@name='fromMonth']")
	public WebElement departingMonth;

	@FindBy(xpath = "//select[@name='fromDay']")
	public WebElement departingDay;

	@FindBy(xpath = "//select[@name='fromPort']")
	public WebElement departingDestination;

	@FindBy(xpath = "//select[@name='toPort']")
	public WebElement arrival;

	@FindBy(xpath = "//select[@name='toMonth']")
	public WebElement arrivalMonth;

	@FindBy(xpath = "//select[@name='toDay']")
	public WebElement arrivalDay;

	@FindBy(xpath = "//input[@name='servClass'][@value='Business']")
	public WebElement businessServiceClass;

	@FindBy(xpath = "//input[@name='servClass'][@value='First']")
	public WebElement FirstServiceClass;

	@FindBy(xpath = "//input[@name='servClass'][@value='Coach']")
	public WebElement coachServiceClass;

	@FindBy(xpath = "//select[@name='airline']")
	public WebElement airLinePrefrences;

	@FindBy(xpath = "//input[@name='findFlights']")
	public WebElement findFlightsButton;

	@FindBy(xpath = " //td[@class='frame_action_xrows']/input[@name='outFlight'][@value='Unified Airlines$363$281$11:24']")
	public WebElement departingFlightSelction;

	@FindBy(xpath = " //td[@class='frame_action_xrows']/input[@name='inFlight'][@value='Unified Airlines$633$303$18:44']")
	public WebElement arrivalFlightSelction;

	@FindBy(xpath = "//table[@bgcolor='ffffff']/tbody/tr[3]/td[3]")
	public WebElement depratingPriceCheck;

	@FindBy(xpath = "//table[@bgcolor='ffffff']/tbody/tr[6]/td[3]")
	public WebElement arrivingPriceCheck;

	@FindBy(xpath = "//input[@name='passFirst0']")
	public WebElement passengerOne;
	@FindBy(xpath = "//input[@name='passLast0']")
	public WebElement passengerLastOne;

	@FindBy(xpath = "//select[@name='pass.0.meal']")
	public WebElement passengerMealPreferenceOne;

	@FindBy(xpath = "//input[@name='passFirst1']")
	public WebElement passengerTwo;
	@FindBy(xpath = "//input[@name='passLast1']")
	public WebElement passengerLastTwo;

	@FindBy(xpath = "//select[@name='pass.1.meal']")
	public WebElement passengerMealPreferenceTwo;

	@FindBy(xpath = "//input[@name='cc_frst_name']")
	public WebElement creditCardFirstName;

	@FindBy(xpath = "//input[@name='cc_mid_name']")
	public WebElement creditCardMidName;

	@FindBy(xpath = "//input[@name='cc_last_name']")
	public WebElement creditCardLastName;

	@FindBy(xpath = "//input[@name='creditnumber']")
	public WebElement creditNumber;

	@FindBy(xpath = "//input[@name='billAddress1']")
	public WebElement billAddress1;
	@FindBy(xpath = "//input[@name='billAddress2']")
	public WebElement billAddress2;
	@FindBy(xpath = "//input[@name='billCity']")
	public WebElement billCity;

	@FindBy(xpath = "//input[@name='billState']")
	public WebElement billState;

	@FindBy(xpath = "//select[@name='billCountry']")
	public WebElement billCountry;

	@FindBy(xpath = "//input[@name='delAddress1']")
	public WebElement delAddress1;
	@FindBy(xpath = "//input[@name='delAddress2']")
	public WebElement delAddress2;

	@FindBy(xpath = "//input[@name='delCity']")
	public WebElement delCity;

	@FindBy(xpath = "//input[@name='delState']")
	public WebElement delState;

	@FindBy(xpath = "//input[@name='billZip']")
	public WebElement billZip;

	@FindBy(xpath = "//input[@name='delZip']")
	public WebElement delZip;

	@FindBy(xpath = "//*[contains(text(),'Flights')]")
	public WebElement flightButton;

	@FindBy(xpath = "//select[@name='delCountry']")
	public WebElement delCountry;
	@FindBy(xpath = "//input[@name='reserveFlights']")
	public WebElement reserveFlightsButton;

	@FindBy(xpath = "//input[@name='buyFlights']")
	public WebElement securePurchase;

	// input[@name="reserveFlights"]
	@FindBy(xpath = "//img[@src='/images/forms/Logout.gif']")
	public WebElement logOut;

	@FindBy(xpath = "//select[@class='md-select']")
	public WebElement selectFileType;

	@FindBy(css = "cr-button.action-button")
	public WebElement SavePage;

	@FindBy(xpath = "//table/tbody/tr[3]/td[3]/font")
	public WebElement inFlightPrice;

	@FindBy(xpath = "//table/tbody/tr[2]/td/table/tbody/tr[6]/td[3]/font")
	public WebElement outFlightPrice;

	@FindBy(xpath = "//table/tbody/tr[2]/td/table/tbody/tr[9]/td[2]/font/b")
	public WebElement totalPrice;

	public void flightBookingPageTest(HashMap<String, String> usrData) throws InterruptedException, AWTException {
	
		
		//Enter flight Details

		if (usrData.get("Action").equalsIgnoreCase("BookFlightTicket")) {
			clickOnButton(flightButton);
			if (usrData.get("typeTrip").equalsIgnoreCase("oneWay")) {
				clickOnButton(flightButton);

			} else {
				clickOnButton(roundTripType);
			}

			selectDropdownItemByVisibleText(passengerCount, usrData.get("passengerCount"));
			selectDropdownItemByVisibleText(departingMonth, usrData.get("departingMonth"));
			selectDropdownItemByVisibleText(departingDay, usrData.get("departingDay"));
			selectDropdownItemByVisibleText(departingDestination, usrData.get("departingDestination"));
			selectDropdownItemByVisibleText(arrival, usrData.get("arrival"));
			selectDropdownItemByVisibleText(arrivalMonth, usrData.get("arrivalMonth"));
			selectDropdownItemByVisibleText(arrivalDay, usrData.get("arrivalDay"));
			selectDropdownItemByVisibleText(airLinePrefrences, usrData.get("airLinePrefrences"));

			if (usrData.get("class").equalsIgnoreCase("businessServiceClass")) {
				clickOnButton(businessServiceClass);
			} else if (usrData.get("class").equalsIgnoreCase("FirstServiceClass")) {
				clickOnButton(FirstServiceClass);
			} else {
				clickOnButton(coachServiceClass);
			}

			clickOnButton(findFlightsButton);

			if (usrData.get("DepartingFlight").equalsIgnoreCase("fixed")) {
				clickOnButton(departingFlightSelction);
			} else {
				String value = usrData.get("DepartingFlight");

				webdriver
						.findElement(By.xpath(
								"//td[@class='frame_action_xrows']/input[@name='outFlight'][@value='" + value + "']"))
						.click();

				String temp = value.replaceAll(" ", "");
				departKey = temp.replaceAll(":", "");

			}

			if (usrData.get("ArrivalFlight").equalsIgnoreCase("fixed")) {
				clickOnButton(arrivalFlightSelction);
			} else {

				String value = usrData.get("ArrivalFlight");
				webdriver
						.findElement(By.xpath(
								"//td[@class='frame_action_xrows']/input[@name='inFlight'][@value='" + value + "']"))
						.click();

				String temp = value.replaceAll(" ", "");

				arrivalKey = temp.replaceAll(":", "");

			//	System.out.println(arrivalKey);
			//	System.out.println(getvalueFromIni(arrivalKey));

			}

			clickOnButton(reserveFlightsButton);

			assertFLightBookingAssert(usrData);

			// Enter Passenger Details

			if (usrData.get("passengerCount").equalsIgnoreCase("1")) {
				passengerOne.sendKeys("passengerOne");
				passengerLastOne.sendKeys(usrData.get("passengerOne"));
				selectDropdownItemByVisibleText(passengerMealPreferenceOne, usrData.get("passengerMealPreference"));
			} else if (usrData.get("passengerCount").equalsIgnoreCase("2")) {
				passengerOne.sendKeys(usrData.get("passengerOne"));
				passengerLastOne.sendKeys(usrData.get("passengerOne"));
				selectDropdownItemByVisibleText(passengerMealPreferenceOne, usrData.get("passengerMealPreference"));
				passengerTwo.sendKeys(usrData.get("passengerOne"));
				passengerLastOne.sendKeys(usrData.get("passengerOne"));
				selectDropdownItemByVisibleText(passengerMealPreferenceTwo, usrData.get("passengerMealPreference"));
			}

			// Entering Credit Card information
			if (usrData.get("creditCardFirstName").equalsIgnoreCase("dynamic")) {
				creditCardFirstName.sendKeys(generateRandomAlphaString(5));

			} else {
				creditCardFirstName.sendKeys(usrData.get("creditCardFirstName"));
			}

			if (usrData.get("creditCardMidName").equalsIgnoreCase("dynamic")) {
				creditCardMidName.sendKeys(generateRandomAlphaString(5));

			} else {
				creditCardMidName.sendKeys(usrData.get("creditCardMidName"));
			}

			if (usrData.get("creditCardLastName").equalsIgnoreCase("dynamic")) {
				creditCardLastName.sendKeys(generateRandomAlphaString(5));

			} else {
				creditCardLastName.sendKeys(usrData.get("creditCardLastName"));
			}
			if (usrData.get("creditNumber").equalsIgnoreCase("dynamic")) {
				creditNumber.sendKeys(generateRandomNumber(10));

			} else {
				creditNumber.sendKeys(usrData.get("creditNumber"));

			}

			// Entering Billing Address
			billAddress1.clear();
			billAddress1.sendKeys(usrData.get("billAddress1"));
			billAddress2.clear();
			billAddress2.sendKeys(usrData.get("billAddress2"));
			billCity.clear();
			billCity.sendKeys(usrData.get("billCity"));
			billState.clear();
			billState.sendKeys(usrData.get("billState"));
			selectDropdownItemByVisibleText(billCountry, usrData.get("billCountry"));
			billZip.clear();
			billZip.sendKeys(usrData.get("billZip"));

			// Entering Delivery address

			delAddress1.clear();
			delAddress1.sendKeys(usrData.get("delAddress1"));
			delAddress2.clear();
			delAddress2.sendKeys(usrData.get("delAddress2"));
			delCity.clear();
			delCity.sendKeys(usrData.get("delCity"));
			delState.clear();
			delState.sendKeys(usrData.get("delState"));

			if (usrData.get("delCountry") != "UNITED STATES") {
				selectDropdownItemByVisibleText(delCountry, usrData.get("delCountry"));
				acceptAlert();

			} else {
				selectDropdownItemByVisibleText(delCountry, usrData.get("delCountry"));
			}
			delZip.clear();
			delZip.sendKeys(usrData.get("delZip"));

			clickOnButton(securePurchase);

			pintPage();

			clickOnButton(logOut);

			webdriver.close();

		}

	}

	public void assertFLightBookingAssert(HashMap<String, String> usrData) {

		if (usrData.get("Assertion").equalsIgnoreCase("assertOnPrice")) {

			Double arrivalPrice = Double.parseDouble(getvalueFromIni(arrivalKey));
			Double DepartPrice = Double.parseDouble(getvalueFromIni(departKey));
			double tax = (arrivalPrice + DepartPrice) * 0.08;

			double totalExpectedPrice = Math.ceil(tax) + (arrivalPrice + DepartPrice);

			String temp = totalPrice.getText();
			System.out.println(temp);
			String actualPrice = temp.replace("$", "");
			System.out.println("this is replace all" + actualPrice);
			Double ActualPriceinDouble = Double.parseDouble(actualPrice);
			assertOnDoubleTypeResponse(totalExpectedPrice, ActualPriceinDouble);

		}

	}

}
