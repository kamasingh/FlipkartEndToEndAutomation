package com.flipkart.testcases;


import static io.appium.java_client.touch.offset.ElementOption.element;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;


public class FlipkartEndtoEndTC extends BaseClass {

	@Test
	public static void flipkart() throws MalformedURLException, InterruptedException {


		AndroidDriver<AndroidElement> driver = capabilities();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElementsById("com.flipkart.android:id/locale_icon_layout").get(4).click();
		driver.findElementById("com.flipkart.android:id/ll_select_btn").click();
		Thread.sleep(2000);
		driver.findElementById("com.google.android.gms:id/credential_primary_label").click();
		driver.findElementById("com.flipkart.android:id/custom_back_icon").click();
	//	driver.findElementById("com.flipkart.android:id/button").click();
		Thread.sleep(2000);
	

		driver.findElementById("com.flipkart.android:id/search_widget_textbox").click();
		
		
		
		driver.findElementById("com.flipkart.android:id/search_autoCompleteTextView").sendKeys("Trimmer");
		driver.findElementById("com.flipkart.android:id/search_autoCompleteTextView").click();
		
			
		Thread.sleep(2000);
		/*
		 * Actions class is used for downward press of keyboard
		 */
		Actions action = new Actions(driver);
		action.sendKeys(Keys.DOWN).perform();
		((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.ENTER));

		driver.findElementById("com.flipkart.android:id/not_now_button").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Filter']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Brand']").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Panasonic\"));");

		driver.findElementByXPath("//android.widget.TextView[@text='Panasonic']").click();
		Thread.sleep(2000);


		driver.findElementByXPath("//android.widget.TextView[@text='Apply']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='Sort']").click();
		Thread.sleep(2000);

		driver.findElementByXPath("//android.view.ViewGroup[@index='4']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='Panasonic Er-Gn30-K  Runtime: 30 min Trimmer for Men']").click();
		

		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='ADD TO CART']").click();
		
		Thread.sleep(2000);
		driver.findElementByXPath("//android.widget.TextView[@text='GO TO CART']").click();
		
		Thread.sleep(2000);
		 AndroidElement ele = driver.findElementByXPath("//android.widget.TextView[@text='₹1,815 ']");
		 String price = ele.getText();
		 System.out.println(price);
		 
		 int realPrice = 1815;
		 char[] ch = price.toCharArray();
		 String newPrice="";
		 for (int i = 0; i < ch.length; i++) {
			 
			 if(ch[i]>=48&& ch[i]<=57)
			 {
				 newPrice=newPrice+ch[i];
			 }	
		}
		 int expectedPrice=Integer.parseInt(newPrice);
		 System.out.println(newPrice);
		 
		Assert.assertEquals(expectedPrice, realPrice);
		 

	

		
		
		
	}
		
}
