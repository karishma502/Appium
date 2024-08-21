package AppiumMobileAutomation;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumBy;



public class WifiSettingsName extends BaseTest {

	@Test
	public void WifiSetting() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		
		//code to start wifi
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		Thread.sleep(3000);
		driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
		String alert = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alert, "WiFi settings");
		
		driver.findElement(By.id("android:id/edit")).sendKeys("KarishmaWifi");
		driver.findElement(By.id("android:id/button1")).click();
		

	}
}
