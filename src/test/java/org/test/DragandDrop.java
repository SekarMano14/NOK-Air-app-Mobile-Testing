package org.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.ElementOption;

public class DragandDrop {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Lenovo k3 Note");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6");
		cap.setCapability("appPackage", "dragdrop.stufflex.com.dragdrop");
		cap.setCapability("appActivity", "dragdrop.stufflex.com.dragdrop.splash");
		cap.setCapability("udid", "LFIV6DRSU8ONR8FA");

		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),
				cap);

		Thread.sleep(5000);
		MobileElement btnLit = driver
				.findElement(By.xpath("//*[@resource-id='dragdrop.stufflex.com.dragdrop:id/btn_literature']"));
		btnLit.click();

		MobileElement src = driver
				.findElement(By.xpath("//*[@resource-id='dragdrop.stufflex.com.dragdrop:id/chooseA']"));
		MobileElement des = driver
				.findElement(By.xpath("//*[@resource-id='dragdrop.stufflex.com.dragdrop:id/answer']"));

		TouchAction ac = new TouchAction(driver);
		ac.longPress(ElementOption.element(src)).moveTo(ElementOption.element(des)).release().perform();

		// 2nd ques
		MobileElement s = driver.findElement(By.xpath("//*[@resource-id='dragdrop.stufflex.com.dragdrop:id/chooseC']"));
		ac.longPress(ElementOption.element(s)).moveTo(ElementOption.element(des)).release().perform();

		// 3rd ques
		MobileElement a = driver.findElement(By.xpath("//*[@resource-id='dragdrop.stufflex.com.dragdrop:id/chooseB']"));
		ac.longPress(ElementOption.element(a)).moveTo(ElementOption.element(des)).release().perform();

	}
}
