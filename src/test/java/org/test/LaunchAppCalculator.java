package org.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class LaunchAppCalculator {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Lenovo k3 Note");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6");
		cap.setCapability("appPackage", "com.android.calculator2");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		cap.setCapability("udid", "LFIV6DRSU8ONR8FA");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				cap);

		MobileElement digit3 = driver.findElement(By.id("digit_3"));
		digit3.click();
        //add
		MobileElement add = driver.findElement(By.id("op_add"));
		add.click();

		MobileElement digit2 = driver.findElement(By.id("digit_2"));
		digit2.click();
		//add
		add.click();

		MobileElement digit8 = driver.findElement(By.id("digit_8"));
		digit8.click();
        //sub
		MobileElement sub = driver.findElement(By.id("op_sub"));
		sub.click();

		MobileElement digit5 = driver.findElement(By.id("digit_5"));
		digit5.click();

		MobileElement eq = driver.findElement(By.id("eq"));
		eq.click();
        //div
		MobileElement div = driver.findElement(By.id("op_div"));
		div.click();

		MobileElement dig2 = driver.findElement(By.id("digit_2"));
		dig2.click();

		MobileElement result = driver.findElement(By.id("result"));
		String text = result.getText();

		if (text.equals("4")) {
			System.out.println("correct answer");
		} else {
			System.out.println("Not correct");
		}

	}
}
