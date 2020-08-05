package Actiity_1;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Activity3_ContactApp {
	
	AppiumDriver<MobileElement> driver=null;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredcapabilities=new DesiredCapabilities();
		desiredcapabilities.setCapability("deviceId", "31003d412c4d2305");
		desiredcapabilities.setCapability("deviceName", "Galaxy J7 (2016)");
		desiredcapabilities.setCapability("platformName", "Android");
		desiredcapabilities.setCapability("appPackage", "com.samsung.android.contacts");
		desiredcapabilities.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
		desiredcapabilities.setCapability("noReset", true);
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredcapabilities);
		
	}
	
	@Test
	public void AddContact() throws InterruptedException {
		
		driver.findElementByAccessibilityId("Create contact").click();
		Thread.sleep(2000);
		driver.findElementById("expansion_view").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[2]")
				.sendKeys("Android");
		driver.findElementByXPath("//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.EditText[4]")
				.sendKeys("DeviceTest");
		driver.navigate().back();
		driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.EditText").sendKeys("9876543210");
		driver.findElementById("menu_done").click();
		Thread.sleep(2000);
		String text = driver.findElementById("header").getText();
		System.out.println("Contact Name-"+text);
		Assert.assertEquals(text, "Android DeviceTest");
		
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
