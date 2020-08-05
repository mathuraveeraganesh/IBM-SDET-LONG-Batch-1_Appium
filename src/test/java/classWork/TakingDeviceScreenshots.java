package classWork;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class TakingDeviceScreenshots {
	
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
		public void test() throws IOException {
	        String timeStamp;
	    	File screenShotName;
		    // Take screenshot
		     File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    // This specifies the location the screenshot will be saved
		     screenShotName = new File("src/test/resources/screenshot.jpg");
		     // This will copy the screenshot to the file created
		     FileUtils.copyFile(scrFile, screenShotName);
		     //Set filepath for image
		     String filePath = "../"+screenShotName.toString();
		    //Set image HTML in the report
		    String path = "<img src='"+ filePath +"'/>";
		   //Show image in report
		   Reporter.log(path);
			
		}
		
		@AfterClass
		public void tearDown() {
			driver.quit();
		}

}
