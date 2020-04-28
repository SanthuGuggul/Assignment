package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class practice {
	public static void main(String[] args) {
		
	
	System.setProperty("webdriver.chrome.driver", "./driver/chromedriver81.exe");
	WebDriver webdriver=new ChromeDriver();
	webdriver.get("http://newtours.demoaut.com");
	
	
	WebElement element=webdriver.findElement(By.xpath("//input[@name='userName']"));
	
	System.out.println(element.toString());
	
	
	}

}
