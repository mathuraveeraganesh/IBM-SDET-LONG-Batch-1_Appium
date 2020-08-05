package classWork;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class ExamplewithLocators {
	
	//AppiumDriver<MobileElement> driver = null;
	 AndroidDriver driver=null;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setCapability("deviceId", "31003d412c4d2305");
        caps.setCapability("deviceName", "Galaxy J7 (2016)");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
        caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
        caps.setCapability("noReset", true);
        
        URL remoteUrl=new URL("http://localhost:4723/wd/hub");
        //driver = new AndroidDriver<MobileElement>(appServer, caps);
        driver=new AndroidDriver(remoteUrl,caps);
        
        
	}
	
	@Test
	public void test() {
		driver.findElementById("bt_08").click();
		driver.findElementByAccessibilityId("Multiplication").click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_02")).click();
		driver.findElementById("bt_equal").click();
		
		//Verify Result
		String text = driver.findElementByAccessibilityId("Calculator input field").getText();
		System.out.println("Result-"+text);
		Assert.assertEquals(text,"16");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
