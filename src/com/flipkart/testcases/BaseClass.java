package com.flipkart.testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {
		
		File f = new File("src");
		File fs = new File(f,"com.flipkart.android_7.9.apk");


		DesiredCapabilities cap = new DesiredCapabilities();
		
	//	cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Emullator5542");

		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android device");

		
		cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Uiautomator2");
		cap.setCapability(MobileCapabilityType.VERSION, "9.0");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);

		
	//	cap.setCapability("appPackage","com.flipkart.android");
		//cap.setCapability("appActivity","com.flipkart.android.activity.HomeFragmentHolderActivity");
	//	capabilities.setCapability("app", app.getAbsolutePath());
		
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		return driver;

		
	}

}
