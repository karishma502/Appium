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



public class ScrollDemo extends BaseTest {

	@Test
	public void ScrollDemoTest() throws MalformedURLException, URISyntaxException, InterruptedException {



		//Scroll to element

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
						".scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))"
				)).click();
		Thread.sleep(3000);

		// Where to scroll known prior

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
						".scrollIntoView(new UiSelector().textContains(\"WebView\").instance(0))"
				)).click();
		Thread.sleep(4000);


		//no prior Idea
		scrollToEndAction();



	}
}
