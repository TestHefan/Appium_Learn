package com.appium.dongqiudi;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class TestCase {
	private static AndroidDriver driver;

	@BeforeSuite(alwaysRun = true)
	public void setUp() throws Exception {
		// set up appium
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "apps");
		File app = new File(appDir, "com.dongqiudi.news_99.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Android Emulator");
		capabilities.setCapability("platformVersion", "6.0");
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.dongqiudi.news");
		capabilities.setCapability("appActivity", ".BaseSplashActivity");
		//capabilities.setCapability("waitActivity", ".GuideActivity");
		capabilities.setCapability("unicodeKeyboard", "True");
		capabilities.setCapability("resetKeyboard", "True");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		System.out.print("ok!!");
	}

	@AfterTest
	// @AfterTest(alwaysRun=true)
	public void tearDown() throws Exception {
		// driver.quit();
	}

	@Test
	public void testcase() {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement e = wait.until(new ExpectedCondition<WebElement>() {
			// @Override
			public WebElement apply(WebDriver d) {
				//return d.findElement(By.id("com.dongqiudi.news:id/iv_logo"));
				return d.findElement(By.id("com.dongqiudi.news:id/image"));
			}

		});

		// WebElement nokjfs = driver.findElement(By.id("com.dongqiudi.news:id/cancel"));
		// nokjfs.click();
		AppLibs a = new AppLibs();

		// Xlsfile xlsfile=new Xlsfile();
		/*
		 * for(int i=1;i<=10;i++) { //Xlsfile.readxls("test",4,
		 * i).getType()!=CellType.EMPTY; System.out.println("for i="+i);
		 * System.out.println("isempty is "+Xlsfile.isempty("test",4, i));
		 * 
		 * if(Xlsfile.isempty("test",4, i)) {break;}
		 * System.out.println(Xlsfile.readxls("test",4,
		 * i)+"  "+Xlsfile.readxls("test",5, i)+"  "+Xlsfile.readxls("test",6,
		 * i)+"  "+Xlsfile.readxls("test",7, i)); WebElement
		 * elements=a.findElement(driver,Xlsfile.readxls("test",4,
		 * i),Xlsfile.readxls("test",5, i));
		 * a.execute(elements,Xlsfile.readxls("test",6,
		 * i),Xlsfile.readxls("test",7, i));
		 * Xlsfile.writexls("test",8,i,"success"); }
		 * 
		 * 
		 * String
		 * lastname=a.checktext(driver,"id","com.yougou:id/product_name","asics"
		 * ); System.out.println("Last Name="+lastname);
		 */

		for (int i = 1; i <= 10; i++) {
			System.out.println("for start i=" + i);
			if (Xlsfile.isempty("dongqiudi_testcase", 1, i)) {
				break;
			}
			WebElement elementname = a
					.element(driver, Xlsfile.search(Xlsfile.readxls(
							"dongqiudi_testcase", 1, i)));
			
			String execute = Xlsfile.readxls("dongqiudi_testcase", 2, i);
			String value = Xlsfile.readxls("dongqiudi_testcase", 3, i);
			a.execute(driver, elementname, execute, value);
		}
		/*
		WebElement el = driver.findElement(By.id("com.dongqiudi.news:id/iv_logo"));
        el.click();
        */
		driver.pinch(200, 500);

	}
	// public static void main(String[] args) {

	// a.findElement2();

	// }
}
