package AppiumMobileAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.Alert;
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



public class AltersDemo extends BaseTest {

	@Test
	public void DragDropTest() throws MalformedURLException, URISyntaxException, InterruptedException {

		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();

		// alert implementation
		// ok cancel dialog with a msg

		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();

		//Alert alert = driver.switchTo().alert();

		Thread.sleep(3000);
		String alertMsg =driver.findElement(By.id("android:id/alertTitle")).getText();
		String expected ="Lorem ipsum dolor sit aie consectetur adipiscing\n"
				+ "Plloaso mako nuto siwuf cakso dodtos anr koop.";
		Assert.assertEquals(alertMsg, expected);

		driver.findElement(By.xpath("//android.widget.Button[@resource-id='android:id/button1']")).click();

		// List Dialogue

		driver.findElement(AppiumBy.accessibilityId("List dialog")).click();

		driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='Command one']")).click();

		String cmdText = driver.findElement(By.id("android:id/message")).getText();
		Assert.assertEquals(cmdText, "You selected: 0 , Command one");

		driver.navigate().back();

		// check progress Dialogue

		driver.findElement(AppiumBy.accessibilityId("Progress dialog"));
		Thread.sleep(3000);
	}
}
