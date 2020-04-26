package tests.ui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



import pages.RegisterPage;
import utils.BasePage;
import utils.JavaUtils;

public class RegisterPageTest {
	
	public String sheetname="RegisterPage",workbook = "UITestData";

	private RegisterPage registerPage;
	public static WebDriver wdriver;
	private BasePage basePage=new BasePage(wdriver);
	private HashMap<String, String> usrData;
	

	
    @Test
	public void registerPageTest(HashMap<String,String>usrData) {
	
		System.out.println("LAUNCHING THE WEB APP FOR FLOW : " + usrData.get("TCID"));
		wdriver=basePage.launchBrowser();
		registerPage=new RegisterPage(wdriver);
		registerPage.registerPageTest(usrData);
	}
	
	
}
