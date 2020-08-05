package classWork;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;


public class AppiumRecordPlayback {
	private AndroidDriver driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		 caps.setCapability("deviceId", "31003d412c4d2305");
        caps.setCapability("deviceName", "Galaxy J7 (2016)");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("noReset", true);
        
        URL remoteUrl=new URL("http://localhost:4723/wd/hub");
        driver=new AndroidDriver(remoteUrl,caps);
        
	}
	
	@Test
	public void sampleTest() {
		(new TouchAction(driver)).tap(point(64, 931)).perform();
		(new TouchAction(driver)).tap(point(612, 781)).perform();
		(new TouchAction(driver)).tap(point(430, 916)).perform();
		(new TouchAction(driver)).tap(point(638, 1209)).perform();
		(new TouchAction(driver)).tap(point(97, 641)).perform();
		
	}
	
	private TapOptions point(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	@After
	public void tearDown() {
		driver.quit();
	}

}
