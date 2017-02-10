package com.appium.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.util.List;

import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
 
public class wecash_test {
    private  AndroidDriver  driver;
 
//    @BeforeMethod
	@BeforeMethod(alwaysRun=true)
    public void setUp() throws Exception {
        // set up appium
        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "com.syqy.wecash_4.6.4_30.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName","Android Emulator");
        capabilities.setCapability("platformVersion", "5.0");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("appPackage", "com.syqy.wecash");
        capabilities.setCapability("appActivity", ".IndexActivity");
        capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
 
    @AfterMethod
	@AfterTest
   // @AfterTest(alwaysRun=true)
    public void tearDown() throws Exception {
       //driver.quit();
    }
 
   // @Test(enabled = false)
	public void filterset(String sub1,String sub2){
    
	WebElement filter_sex = driver.findElement(By.id("com.yougou:id/textView_sift_"+sub1));
	filter_sex.click();
	WebElement filter_sex_man = driver.findElement(By.name(sub2));
	filter_sex_man.click();
	WebElement filter_sex_select = driver.findElement(By.id("com.yougou:id/popup_ok"));
	filter_sex_select.click();
	}
	
	public String checkText(String elementID,String keyname){
		//WebElement check_element = driver.findElement(By.id(elementID));
		List<WebElement> check_elements = driver.findElements(By.id(elementID));
		int i=0;
		
		for(;i<check_elements.size();i++){
		AssertJUnit.assertTrue(check_elements.get(i).getAttribute("text").contains(keyname));
		System.out.println("The text is "+check_elements.get(i).getAttribute("text"));
		}
		return check_elements.get(i-1).getAttribute("text");
	}
	
	public int[] appScreen(){
	int width=driver.manage().window().getSize().getWidth();
	int heightScreen=driver.manage().window().getSize().getHeight();
	int[] appWidthAndHight={width,heightScreen};
	System.out.println("width="+appWidthAndHight[0]+"height"+appWidthAndHight[1]);
	return appWidthAndHight;
	}
	
	public void swipeToDown(int duration){
		int starty=this.appScreen()[1]*1/5;
		int endy=this.appScreen()[1]*1/2;
		int x=this.appScreen()[0]*1/2;
		try{
			driver.swipe(x,starty, x, endy, duration);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void swipeToUp(int duration){
		int starty=this.appScreen()[1]*9/10;
		int endy=this.appScreen()[1]*2/10;
		int x=this.appScreen()[0]*1/2;
		try{
			driver.swipe(x,starty, x, endy, duration);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
static String lastname;
	public void swipeToUp_UnitlDisappear(){
		
		boolean flag=true;
		int times=0;
		while(flag){
			times++;
			if(times>5)
			{
			System.out.println("tiems="+times);
			break;
			}

		try{
			System.out.println("try is run!");
			driver.findElement(By.name(lastname));
			swipeToUp(3000);
		}
		catch(Exception e){
			//e.printStackTrace();
			System.out.println("error is done!");
			times=0;
			//swipeToUp_UnitlDisappear(checkText("com.yougou:id/product_name","asics"));
			lastname=checkText("com.yougou:id/product_name","asics");
			System.out.println("Last Name="+lastname);
			//flag=false;
		}
		}
	}
		
    @Test(groups={"testcase"})
    public void testcase() {
        //WebElement el = driver.findElement(By.name("Add Contact"));
    	WebDriverWait wait=new WebDriverWait(driver,60);
    	WebElement e=wait.until(new ExpectedCondition<WebElement>(){
    		//@Override
    		public WebElement apply(WebDriver d){
    		return d.findElement(By.id("android:id/button2"));
    	}
    });
    	
    	WebElement nokjfs = driver.findElement(By.id("android:id/button2"));
    	nokjfs.click();
    	
    	WebElement search = driver.findElement(By.id("com.yougou:id/btn_home_search"));
    	search.click();
    	WebElement searchtext = driver.findElement(By.id("com.yougou:id/search_edit_text"));
    	searchtext.sendKeys("asics");
    	WebElement searchbtn = driver.findElement(By.id("com.yougou:id/text_search_click"));
    	searchbtn.click();
    	WebElement filterbtn = driver.findElement(By.id("com.yougou:id/iv_filter_order"));
    	filterbtn.click();
    	filterset("sex","Фазг");
    	filterset("size","42");
    	WebElement filter_sex_selectfin = driver.findElement(By.id("com.yougou:id/popup_ok"));
    	filter_sex_selectfin.click();
  
    	//checkText("com.yougou:id/product_name","asics");
    	lastname=checkText("com.yougou:id/product_name","asics");
    	swipeToUp_UnitlDisappear();
    	//driver.swipe(300,800,300,200,800);
    	//swipeToUp(5000);

        /*
        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(1).sendKeys("10086");
        textFieldsList.get(2).sendKeys("Some@example.com");
        driver.swipe(100, 500, 100, 100, 2);
        driver.findElementByName("Save").click();
        */
    }
}