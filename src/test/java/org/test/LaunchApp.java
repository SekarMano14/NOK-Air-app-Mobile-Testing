package org.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class LaunchApp {
	static AndroidDriver<MobileElement> driver;

	public static void scrollDown() {
		Dimension size = driver.manage().window().getSize();

		// start height
		Double Stht = size.getHeight() * 0.5;
		int start = Stht.intValue();
		// end Height
		Double endHt = size.getHeight() * 0.2;
		int end = endHt.intValue();

		// scroll down
		TouchAction ac = new TouchAction(driver);
		ac.press(PointOption.point(0, start)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
				.moveTo(PointOption.point(0, end)).release().perform();

	}
	
	public static  List<MobileElement> getLocator() {
		 List<MobileElement> endItem = driver.findElements(By.xpath("(//*[@resource-id='com.flipkart.android:id/banner_image'])[4]"));
		return endItem;

	}
	
	public static void ScrollDowntillLoc() {
		while(getLocator().size()==0) {
			scrollDown();
			}
		if(getLocator().size()!=0) {
			getLocator().get(0).click();
		}

	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Realme X2");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "10");
		cap.setCapability("appPackage", "com.flipkart.android");
		cap.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		cap.setCapability("udid", "475507fb");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		
		

		Thread.sleep(5000);
	
		MobileElement txtSearch = driver.findElement(By.id("search_widget_textbox"));
		txtSearch.click();

		MobileElement searchItems = driver.findElement(By.id("search_autoCompleteTextView"));
		searchItems.sendKeys("iphone");

//		driver.sendKeyEvent(AndroidKeyCode.ENTER);
//		ApplicationSetup.driver.getKeyboard().pressKey(Keys.ENTER);
		
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.SEARCH));
		

		List<MobileElement> items = driver.findElements(By.xpath("//*[contains((@text, 'Apple')]"));

		for (MobileElement x : items) {
			System.out.println(x.getText());
		ScrollDowntillLoc();

		}

	}
}
