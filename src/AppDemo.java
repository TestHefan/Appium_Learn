
 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
 
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.URL;
import java.util.List;
 
public class AppDemo {
    private  AndroidDriver  driver;
 
//    @BeforeMethod
	@BeforeMethod(alwaysRun=true)
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "ContactManager.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.example.android.contactmanager");
        capabilities.setCapability("appActivity", ".ContactManager");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
 
//    @AfterMethod
	@AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        driver.quit();
    }
 
    @Test(groups={"addContact"})
    public void addContact(){
        //WebElement el = driver.findElement(By.name("Add Contact"));
    	WebElement el = driver.findElement(By.id("com.example.android.contactmanager:id/addContactButton"));
        el.click();
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(1).sendKeys("10086");
        textFieldsList.get(2).sendKeys("Some@example.com");
        driver.swipe(100, 500, 100, 100, 2);
        driver.findElementByName("Save").click();
    }
}