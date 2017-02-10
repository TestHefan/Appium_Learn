package com.appium.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.util.List;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AppLibs {

public WebElement findElement(AndroidDriver driver,String localstyle,String value){
	
	WebElement result = null;
	switch(localstyle)
	{
	case "id": 
		result = driver.findElement(By.id(value));
		break;
	case "name": 
		result = driver.findElement(By.name(value));
		break;
	case "xpath": 
		result = driver.findElement(By.xpath(value));
		break;
	}
	return result;
}

public List<WebElement> findElements(AndroidDriver driver,String localstyle,String value){
	
	List<WebElement> result = null;
	switch(localstyle)
	{
	case "id": 
		result = driver.findElements(By.id(value));
		break;
	case "name": 
		result = driver.findElements(By.name(value));
		break;
	case "xpath": 
		result = driver.findElements(By.xpath(value));
		break;
	}
	return result;
}

public void execute(WebElement element,String exemethod,String value)
{
	
	switch(exemethod)
	{
	case "click": 
		element.click();
		break;
	case "sendKeys": 
		element.sendKeys(value);
		break;

	}
}

public String checktext(AndroidDriver driver,String localstyle,String localvalue,String checkname){
	//WebElement check_element = driver.findElement(By.id(elementID));
	
	List<WebElement> check_elements = findElements(driver,localvalue,localvalue);
	int i=0;
	for(;i<check_elements.size();i++){
	Assert.assertTrue(check_elements.get(i).getAttribute("text").contains(checkname));
	System.out.println("The text is "+check_elements.get(i).getAttribute("text"));
	}
	return check_elements.get(i-1).getAttribute("text");//返回最后一条
}

public WebElement element(AndroidDriver driver,int y){
	WebElement result=null;
	try{
	result= findElement(driver,Xlsfile.readxls("object",1, y),Xlsfile.readxls("object",2, y));
	}
	catch (Exception e){}
	WebElement result1=result;
	return result1;
}

public void filterset(AndroidDriver driver,String sub1,String sub2){
WebElement filter_sex = driver.findElement(By.id("com.yougou:id/textView_sift_"+sub1));
filter_sex.click();
WebElement filter_sex_man = driver.findElement(By.name(sub2));
filter_sex_man.click();
WebElement filter_sex_select = driver.findElement(By.id("com.yougou:id/popup_ok"));
filter_sex_select.click();
}

}
