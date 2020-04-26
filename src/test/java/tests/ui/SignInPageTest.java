package tests.ui;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.SignInPage;
import utils.BasePage;

public class SignInPageTest {
	
	public String sheetname="SignInPage",workbook = "UITestData";

	private SignInPage signInPage;
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
		
		signInPage=new SignInPage(wdriver);
		signInPage.signInPageTest(usrData);
	}
	

}
