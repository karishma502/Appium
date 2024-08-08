package AppiumMobileAutomation;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	
	@BeforeClass
	public void ConfigureService() throws MalformedURLException, URISyntaxException, InterruptedException {

		//code to start appium service without manual intervention

		service =new AppiumServiceBuilder().withAppiumJS(new File("//usr//local//lib//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();

		//service.start();
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("emulator-5554");
		option.setApp("//Users//karishmakate//Appium//AppiumTesting//src//test//java//resources//ApiDemos-debug.apk");
		 driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), option);


		//stop server
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
		//service.stop();

	}
}
