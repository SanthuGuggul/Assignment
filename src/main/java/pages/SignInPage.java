package pages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.BasePage;

public class SignInPage extends BasePage{
	
	public SignInPage(WebDriver webDriver) {
		super(webDriver);
		PageFactory.initElements(webDriver, this);
		
	}
	
	@FindBy(xpath = "//*[contains(text(),'Flights')]")
	public WebElement flightButton;
	
	@FindBy(xpath = "//*[@name='login']")
	public WebElement signInButton;
	
	@FindBy(xpath = "//input[@name='userName']")
	public WebElement userName;
	
	@FindBy(xpath = "//input[@name='password']")
	public WebElement passWord;
	
	@FindBy(xpath = "//input[@name='login']")
	public WebElement signOnSubmit;
	
	@FindBy(xpath = "//*[contains(text(),'SIGN-ON')]")
	public WebElement signON;
	
  
  public void signInPageTest(HashMap<String,String> usrData) {
	  if(usrData.get("Action").equalsIgnoreCase("signIn")) {
		 System.out.println("i am here");
		  signIn(usrData);
		 
	  }else if(usrData.get("Action").equalsIgnoreCase("signOn")) {
		  signOn(usrData);
		  
	  }
	  
	  
  }

	
  private void signIn(HashMap<String,String> usrData) {
	  
	  clickOnButton(flightButton);
	  userName.sendKeys(usrData.get("userName"));
	  passWord.sendKeys(usrData.get("passWord"));
	  clickOnButton(signOnSubmit);
	  
	  
  }
  
  private void signOn(HashMap<String,String> usrData) {
	  
	  clickOnButton(signON);
	  userName.sendKeys(usrData.get("userName"));
	  passWord.sendKeys(usrData.get("passWord"));
	  clickOnButton(signOnSubmit);
	  
	  
  }
	
	
	
	
	 

	
	
}
