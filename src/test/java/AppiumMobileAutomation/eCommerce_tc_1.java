package AppiumMobileAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_1 extends BaseTest{

	@Test
	public  void fillForm() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Karishma");
		Thread.sleep(3000);
		driver.hideKeyboard();
		driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
						".scrollIntoView(new UiSelector().textContains(\"Angola\").instance(0))"
				)).click();
		Thread.sleep(4000);

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		//String toastMsg=driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
		//Assert.assertEquals(toastMsg, "Please enter your name");
	}


}
