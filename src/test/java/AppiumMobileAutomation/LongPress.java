package AppiumMobileAutomation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class LongPress extends BaseTest {

	@Test
	public void LongPressGesture() throws MalformedURLException, URISyntaxException, InterruptedException {
		
	//start appium
	ConfigureService();
	
	// Long press code
	driver.findElement(By.xpath("//*[contains(@text,'Views')]")).click();
    driver.findElement(MobileBy.AndroidUIAutomator(
            "new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
            ".scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))"
        )).click();


	//driver.findElement(AppiumBy.accessibilityId("Views")).click();
	
	Thread.sleep(6000);
	driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']")).click();
	driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
	WebElement ele =driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));

	((JavascriptExecutor) driver).executeScript("mobile: longClickGesture", ImmutableMap.of(
		    	    "elementId", ((RemoteWebElement) ele).getId(),"duration" ,2000
		    	));
	
	String menuText =driver.findElement(By.id("android:id/title")).getText();
	Assert.assertEquals(menuText, "Sample menu");
	
	//stop appium
	tearDown();
	
	
	}
}
