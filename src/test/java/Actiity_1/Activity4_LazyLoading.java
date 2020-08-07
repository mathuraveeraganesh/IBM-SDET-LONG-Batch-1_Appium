package Actiity_1;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Activity4_LazyLoading {
	
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
			driver.navigate().to("https://www.training-support.net/selenium/lazy-loading");
			
			
			
		} catch (Exception e) {
			Thread.sleep(2000);
	       // MobileElement pageTitle = driver.findElementByClassName("android.widget.TextView");
	    	
	        //wait.until(ExpectedConditions.textToBePresentInElement(pageTitle, "Lazy Loading"));
	        
		    // Count the number of images shown on the screen
		    List<MobileElement> numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
		    System.out.println("Number of image shown currently: " + numberOfImages.size());
			
	        // Assertion before scrolling
		    //Assert.assertEquals(numberOfImages.size(), 4);
		 
		    // Scroll to Helen's post
		    driver.findElement(MobileBy.AndroidUIAutomator("UiScrollable(UiSelector()).scrollTextIntoView(\"helen\")"));
				
	        // Find the number of images shown after scrolling
		    numberOfImages = driver.findElementsByXPath("//android.view.View/android.view.View/android.widget.Image");
		    System.out.println("Number of image shown currently: " + numberOfImages.size());
				
	        // Assertion after scrolling
		    Assert.assertEquals(numberOfImages.size(), 4);
			
		}
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
