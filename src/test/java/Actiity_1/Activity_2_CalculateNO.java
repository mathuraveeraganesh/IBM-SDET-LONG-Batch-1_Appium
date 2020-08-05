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

public class Activity_2_CalculateNO {
	AppiumDriver<MobileElement> driver=null;
	
	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredcapabilities=new DesiredCapabilities();
		desiredcapabilities.setCapability("deviceId", "31003d412c4d2305");
		desiredcapabilities.setCapability("deviceName", "Galaxy J7 (2016)");
		desiredcapabilities.setCapability("platformName", "Android");
		desiredcapabilities.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		desiredcapabilities.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredcapabilities);

		
	}
	
	@Test(priority = 0)
	public void add() {
		driver.findElementById("bt_05").click();
		driver.findElementByAccessibilityId("Plus").click();
		driver.findElementById("bt_09").click();
		driver.findElementByAccessibilityId("Equal").click();
		
		String addition = driver.findElementByAccessibilityId("Calculator input field").getText();
		System.out.println("Addition of 5+9:"+addition);
		Assert.assertEquals(addition, "14");
		
	}
	
	@Test(priority = 1)
	public void sub() {
		driver.findElementById("bt_01").click();
		driver.findElementById("bt_00").click();
		driver.findElementByAccessibilityId("Minus").click();
		driver.findElementById("bt_05").click();
		driver.findElementByAccessibilityId("Equal").click();
		
		String subtraction = driver.findElementByAccessibilityId("Calculator input field").getText();
		System.out.println("Subtraction of 10-5:"+subtraction);
		Assert.assertEquals(subtraction, "5");
		
	}
	
	@Test(priority = 2)
	public void Multiply() {
		driver.findElementById("bt_05").click();
		driver.findElementByAccessibilityId("Multiplication").click();
		driver.findElementById("bt_01").click();
		driver.findElementById("bt_00").click();
		driver.findElementById("bt_00").click();
		driver.findElementByAccessibilityId("Equal").click();
		
		String multiplication = driver.findElementByAccessibilityId("Calculator input field").getText();
		System.out.println("Multiplication of 5*100:"+multiplication);
		Assert.assertEquals(multiplication, "500");
		
	}
	
	@Test(priority = 3)
	public void Division() {
		driver.findElementById("bt_05").click();
		driver.findElementById("bt_00").click();
		driver.findElementByAccessibilityId("Division").click();
		driver.findElementById("bt_02").click();

		driver.findElementByAccessibilityId("Equal").click();
		
		String division = driver.findElementByAccessibilityId("Calculator input field").getText();
		System.out.println("Division of 50/2:"+division);
		Assert.assertEquals(division, "25");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
