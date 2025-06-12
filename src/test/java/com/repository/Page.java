package com.repository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.handlers.BaseClass;

public class Page extends BaseClass{
	
	
	public Page(){
		
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//input[@name='q']")
	public static WebElement search;
	
	
	
	
	

}
