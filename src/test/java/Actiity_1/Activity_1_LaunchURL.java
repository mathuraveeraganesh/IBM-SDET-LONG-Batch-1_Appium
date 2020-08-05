package Actiity_1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Activity_1_LaunchURL {
	
	AppiumDriver<MobileElement> driver;
	
	WebDriverWait wait;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredcapailities=new DesiredCapabilities();
		desiredcapailities.setCapability("deviceId", "31003d412c4d2305");
		desiredcapailities.setCapability("deviceName", "Galaxy J7 (2016)");
		desiredcapailities.setCapability("platformName", "Android");
		desiredcapailities.setCapability("automationName", "UiAutomator2");
		desiredcapailities.setCapability("appPackage", "com.android.chrome");
		desiredcapailities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		desiredcapailities.setCapability("noReset", true);
		
		
		URL appserver=new URL("http://localhost:4723/wd/hub");
		driver=new AndroidDriver<MobileElement>(appserver,desiredcapailities);

		wait = new WebDriverWait(driver, 10);
	}
	
	@Test
	public void launchUrl() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			driver.navigate().to("https://www.training-support.net/");
			
			
		} catch (Exception e) {
			String text = driver.findElementByXPath("//android.view.View[@text='Training Support']").getText();
			System.out.println("Title of Homepage-"+text);
			Thread.sleep(2000);
			driver.findElementByAccessibilityId("About Us").click();
			String text1 = driver.findElementByXPath("//android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]").getText();
			System.out.println("Title of New Page-"+text1);
			
			Assert.assertEquals(text,"Training Support");
			Assert.assertEquals(text1,"About Us");
		}
		
	}
	
	
	@AfterClass
	public void tearDown() {
		//driver.quit();
	}

}
