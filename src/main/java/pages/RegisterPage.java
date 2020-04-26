package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class RegisterPage extends BasePage {
	

	public RegisterPage(WebDriver webdriver) {
		super(webdriver);
		PageFactory.initElements(webdriver, this);
	}
	
	@FindBy(xpath = "//*[contains(text(),'REGISTER')]")
	public WebElement registerButton;
	@FindBy(xpath = "//input[@name='firstName']")
	public WebElement firstName;
	@FindBy(xpath = "//input[@name='lastName']")
	public WebElement lastName;
	@FindBy(xpath = "//input[@name='phone']")
	public WebElement phone;
	@FindBy(xpath = "//input[@name='userName']")
	public WebElement eMail;
	@FindBy(xpath = "//input[@name='address1']")
	public WebElement address1;
	@FindBy(xpath = "//input[@name='address2']")
	public WebElement address2;
	@FindBy(xpath = "//input[@name='city']")
	public WebElement city;
	@FindBy(xpath = "//input[@name='state']")
	public WebElement state;
	@FindBy(xpath = "//input[@name='postalCode']")
	public WebElement postalCode;
	@FindBy(xpath = "//select[@name='country']")
	public WebElement country;
	@FindBy(xpath = "//input[@name='email']")
	public WebElement username;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement password;
	@FindBy(xpath = "//input[@name='confirmPassword']")
	public WebElement confirmPassword;
	@FindBy(xpath = "//input[@src='/images/forms/submit.gif']")
	public WebElement submit;
	
	
	public void registerPageTest(HashMap<String, String> usrData) {
		
		if(usrData.get("Action").equalsIgnoreCase("register")) {
			register(usrData);
		}
		
		
	}
	
	
	private void register(HashMap<String, String> usrData) {
		clickOnButton(registerButton);
		firstName.sendKeys(usrData.get("firstName"));
		lastName.sendKeys(usrData.get("lastName"));
		phone.sendKeys(usrData.get("phone"));
		eMail.sendKeys(usrData.get("eMail"));
		address1.sendKeys(usrData.get("address1"));
		address2.sendKeys(usrData.get("address2"));
		city.sendKeys(usrData.get("city"));
		state.sendKeys(usrData.get("state"));
		postalCode.sendKeys(usrData.get("postalCode"));
		country.sendKeys(usrData.get("country"));
		username.sendKeys(usrData.get("username"));
		password.sendKeys(usrData.get("password"));
		confirmPassword.sendKeys(usrData.get("password"));
		clickOnButton(submit);
		
		
	}
	
	
	
	
	
	

}
