package org.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class LNokAirApp {
	static AndroidDriver<MobileElement> driver;

	public static void scrollDown() {
		Dimension size = driver.manage().window().getSize();
		// System.out.println(size);

		// start height
		Double Stht = size.getHeight() * 0.7;
		int start = Stht.intValue();
		// System.out.println(start);
		// end Height
		Double endHt = size.getHeight() * 0.2;
		int end = endHt.intValue();
		// System.out.println(end);

		// scroll down
		TouchAction ac = new TouchAction(driver);
		ac.longPress(PointOption.point(0, start)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(5)))
				.moveTo(PointOption.point(0, end)).release().perform();

	}

	public static List<MobileElement> getLocator(List<MobileElement> element) {
		return element;

	}

	public static void ScrollDowntillLoc(List<MobileElement> element) {
		while (getLocator(element).size() == 0) {
			scrollDown();
		}
		if (getLocator(element).size() != 0) {
			getLocator(element).get(0).click();
		}

	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Lenovo k3 Note");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6");
		cap.setCapability("appPackage", "com.nokair.it.nokairapp");
		cap.setCapability("appActivity", "com.nokair.it.nokairapp.LauncherActivity");
		cap.setCapability("udid", "LFIV6DRSU8ONR8FA");
		cap.setCapability("noReset", true);

		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		MobileElement bookFlight = driver.findElement(By.id("imgBookFlight"));
		bookFlight.click();

		// Oneway trip
		MobileElement oneWay = driver.findElement(By.id("onewayTgl"));
		oneWay.click();

		// From
		MobileElement from = driver.findElement(By.id("btnFrom"));
		from.click();

		// to select from city
		List<MobileElement> frromcity = driver.findElements(By.xpath("//*[@text='New Delhi, India [DEL]']"));
		ScrollDowntillLoc(frromcity);

		// to
		MobileElement to = driver.findElement(By.id("btnTo"));
		to.click();

		MobileElement toCity = driver.findElement(By.xpath("//*[@text='Bangkok (Don Mueang) [DMK]']"));
		toCity.click();

		// Date
		MobileElement date = driver.findElement(By.id("btnDepartDate"));
		date.click();

		MobileElement nextMonth = driver.findElement(By.id("btnNextMonth"));
		nextMonth.click();
		nextMonth.click();

		MobileElement selectDate = driver.findElement(By.xpath("(//*[@text='6'])[1]"));
		selectDate.click();
		// No of passengers
		MobileElement adAdult = driver.findElement(By.id("addAdultBtn"));
		adAdult.click();

		MobileElement adChild = driver.findElement(By.id("addChildBtn"));
		adChild.click();

		MobileElement cntue = driver.findElement(By.id("btnContinue"));
		cntue.click();

		// Flight selection
		MobileElement slectflight = driver.findElement(By.id("txtDisplayFlight"));
		slectflight.click();

		MobileElement ChooseFlight = driver.findElement(By.id("tgtFlex"));
		ChooseFlight.click();

		cntue.click();
		cntue.click();
		// passenger 1
		MobileElement mr = driver.findElement(By.xpath("(//*[@text='Mr.'])[1]"));
		mr.click();

		MobileElement frstName = driver
				.findElement(By.xpath("(//*[@resource-id='com.nokair.it.nokairapp:id/edtFirtsName'])[1]"));
		frstName.clear();
		frstName.sendKeys("Manoj");

		MobileElement lastName = driver
				.findElement(By.xpath("(//*[@resource-id='com.nokair.it.nokairapp:id/edtLastName'])[1]"));
		lastName.clear();
		lastName.sendKeys("Sekar");

		// passenger 2
		MobileElement mr2 = driver.findElement(By.xpath("(//*[@text='Mr.'])[2]"));
		mr2.click();

		MobileElement frstName2 = driver
				.findElement(By.xpath("(//*[@resource-id='com.nokair.it.nokairapp:id/edtFirtsName'])[2]"));
		frstName2.clear();
		frstName2.sendKeys("Raj");

		MobileElement lastName2 = driver
				.findElement(By.xpath("(//*[@resource-id='com.nokair.it.nokairapp:id/edtLastName'])[2]"));
		lastName2.clear();
		lastName2.sendKeys("Sekar");

		// Select same service
		MobileElement sameservice1 = driver
				.findElement(By.xpath("(//*[@resource-id='com.nokair.it.nokairapp:id/rdSameService'])[1]"));
		sameservice1.click();

		// Child passenger
		List<MobileElement> email = driver.findElements(By.id("edtBookingEmail"));
		ScrollDowntillLoc(email);

		MobileElement boy = driver.findElement(By.id("tgtBoy"));
		boy.click();

		MobileElement childfrstName = driver
				.findElement(By.xpath("(//*[@resource-id='com.nokair.it.nokairapp:id/edtFirtsName'])[2]"));
		childfrstName.clear();
		childfrstName.sendKeys("Raj");

		MobileElement childlastName = driver
				.findElement(By.xpath("(//*[@resource-id='com.nokair.it.nokairapp:id/edtLastName'])[2]"));
		childlastName.clear();
		childlastName.sendKeys("Sekar");

		// Email
		MobileElement emailId = driver.findElement(By.id("edtBookingEmail"));
		emailId.sendKeys("sekarmano@gmail.com");

		// Mobile No
		MobileElement mobNo = driver.findElement(By.id("edtBookingMobileNo"));
		mobNo.sendKeys("8015572746");
		// skip
		cntue.click();

		// Terms and Conditions Accept
		MobileElement accept = driver.findElement(By.xpath("//*[@text='Accept']"));
		accept.click();

		// Conformation page
		MobileElement conform = driver.findElement(By.id("btnPaymentConfirm"));
		conform.click();

		// Payment
		// Credit card no
		MobileElement creditCard = driver.findElement(By.id("credit_card_number"));
		creditCard.sendKeys("1632659875462365");

		// ExpiryDate and Month
		MobileElement expiryDate = driver.findElement(By.id("credit_card_expiry_date"));
		expiryDate.sendKeys("2809");

		// CCV
		MobileElement ccv = driver.findElement(By.id("credit_card_cvv"));
		ccv.sendKeys("256");

		// Card Holder Name
		MobileElement cardHolderName = driver.findElement(By.id("credit_card_holder_name"));
		cardHolderName.sendKeys("Manoj");

		// pay

		// List<MobileElement> pay = driver.findElements(By.id("pay_amount"));
		// ScrollDowntillLoc(pay);
		// pay.click();

	}
}
