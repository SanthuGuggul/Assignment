package utils;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;







public class BasePage extends JavaUtils{
	
	public static WebDriver webdriver;

	
	public BasePage(WebDriver webdriver) {
		this.webdriver=webdriver;
		
	}
	
	public WebDriver launchBrowser() {
		
		String browser=configProperties.get("browser");
		System.out.println(browser);
		
		if(browser.equalsIgnoreCase("firefox")) {
			 webdriver=new FirefoxDriver();
		}else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver81.exe");
			webdriver=new ChromeDriver();
		}
	
		webdriver.get(configProperties.get("url"));
		webdriver.manage().window().maximize();
	
		return webdriver;
		
	}
	
	public void clickOnButton(WebElement element) {
		WebDriverWait  wait=new WebDriverWait(webdriver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
		
	}
	
	
	public void captureScreenshotOnFailedTest(ITestResult result, String Tcid) {
		if(ITestResult.FAILURE==result.getStatus()) {
			File folder = new File("./Screenshots");
			
			final Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportRetina(100, 0, 0, 2)).takeScreenshot(webdriver);
			try {
				ImageIO.write(screenshot.getImage(),"PNG",new File("./Screenshots/" + Tcid + ".png"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
	}

}
	
	

	
	

