package AppiumMobileAutomation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;



public class Miscellanous extends BaseTest {

	@Test
	public void MiscellanousTest() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		
		//Rotate device to landScape
		
		DeviceRotation landScape = new DeviceRotation(0, 0, 90);
		driver.rotate(landScape);
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		String alert = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alert, "WiFi settings");
		
		// Copy to clipBoard - past it clipboard
		driver.setClipboardText("WIFI");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElement(By.id("android:id/button1")).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
	}
}
   