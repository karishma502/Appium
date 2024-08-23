package AppiumMobileAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;



public class DragAndDropDemo extends BaseTest {

	@Test
	public void DragDropTest() throws MalformedURLException, URISyntaxException, InterruptedException {

		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
						".scrollIntoView(new UiSelector().textContains(\"Views\").instance(0))"
				)).click();

		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();

		//Drag and drop implementation
		WebElement ele = driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
				"elementId", ((RemoteWebElement) ele).getId(),
				"endX", 471,
				"endY", 429
				));

		Thread.sleep(3000);

		// assert text
		String actual =driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
		Assert.assertEquals(actual, "Dropped!");
	}


}
