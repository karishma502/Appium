package AppiumMobileAutomation;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce_tc_2 extends BaseTest{
	
	@Test
	public void AddToCart() throws InterruptedException {
		
	
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
		
		//Add to cart
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0))" +
						".scrollIntoView(new UiSelector().textContains(\"Air Jordan 4 Retro\").instance(0))"
				)).click();
		Thread.sleep(4000);
		int productCount=driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		for(int i=0;i<productCount;i++) {
			String ProductName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
			if(ProductName.equalsIgnoreCase("Air Jordan 4 Retro")) {
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			}
		}
		
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();

	}

}
