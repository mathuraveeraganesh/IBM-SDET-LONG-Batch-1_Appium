package Actiity_1;

import java.net.MalformedURLException;
import java.net.URL;

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

public class Activity4_Sms {
	
AppiumDriver<MobileElement> driver=null;

	@BeforeClass
	public void setUp() throws MalformedURLException {
		DesiredCapabilities desiredcapabilities=new DesiredCapabilities();
		desiredcapabilities.setCapability("deviceId", "31003d412c4d2305");
		desiredcapabilities.setCapability("deviceName", "Galaxy J7 (2016)");
		desiredcapabilities.setCapability("platformName", "Android");
		desiredcapabilities.setCapability("appPackage", "com.samsung.android.messaging");
		desiredcapabilities.setCapability("appActivity", "com.android.mms.ui.ConversationComposer");
		desiredcapabilities.setCapability("noReset", true);
		
		driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),desiredcapabilities);
		
	}
	
	@Test
	public void sendSms() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("recipients_editor_to")));
		driver.findElement(MobileBy.id("recipients_editor_to")).sendKeys("9962066735");
		
		driver.findElement(MobileBy.AndroidUIAutomator("resourceId(\"com.samsung.android.messaging:id/editor_body\")")).sendKeys("Hello from Appium");
		driver.findElementById("send_button").click();
		
		Thread.sleep(4000);
		
		driver.navigate().back();
		String text = driver.findElementByXPath("//android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.TextView").getText();
		Assert.assertEquals(text, "Hello from Appium");
		
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
