package utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BasePage extends JavaUtils {

	public static WebDriver webdriver;

	public BasePage(WebDriver webdriver) {
		this.webdriver = webdriver;

	}

	public WebDriver launchBrowser() {

		String browser = configProperties.get("browser");
		System.out.println(browser);

		if (browser.equalsIgnoreCase("firefox")) {
			webdriver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver81.exe");
			webdriver = new ChromeDriver();
		}

		webdriver.get(configProperties.get("url"));
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		return webdriver;

	}

	public void clickOnButton(WebElement element) {
		WebDriverWait wait = new WebDriverWait(webdriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();

	}

	public void waitForElementToBeClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(webdriver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}

	public void acceptAlert() {
		Alert alert = webdriver.switchTo().alert();
		alert.accept();
	}

	public void printAlert() {
		JavascriptExecutor js = (JavascriptExecutor) webdriver;
		js.executeScript("window.print()");

		Alert alert = webdriver.switchTo().alert();
		alert.accept();
	}

	public void selectDropdownItemByVisibleText(WebElement element, String item) {
		Select dropdownItem = new Select(element);
		dropdownItem.selectByVisibleText(item);
	}

	public void captureScreenshotOnFailedTest(ITestResult result, String Tcid) {

		if (ITestResult.FAILURE == result.getStatus()) {

			final Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportRetina(100, 0, 0, 2))
					.takeScreenshot(webdriver);
			try {
				ImageIO.write(screenshot.getImage(), "PNG", new File("./Screenshots/" + Tcid + ".png"));
			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}

	public void pintPage() throws InterruptedException, AWTException {
		Robot rob = new Robot();
		/*
		 * JavascriptExecutor js = (JavascriptExecutor)webdriver;
		 * js.executeScript("window.print()");
		 */

		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_P);

		rob.keyRelease(KeyEvent.VK_P);
		rob.keyRelease(KeyEvent.VK_CONTROL);

		rob.setAutoDelay(5000);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		rob.delay(3000);
		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		rob.keyPress(KeyEvent.VK_LEFT);
		rob.keyRelease(KeyEvent.VK_LEFT);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

		rob.keyPress(KeyEvent.VK_ENTER);
		rob.keyRelease(KeyEvent.VK_ENTER);

	}

}
