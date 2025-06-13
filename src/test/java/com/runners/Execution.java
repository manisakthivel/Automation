package com.runners;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.handlers.BaseClass;
import com.repository.Page;

public class Execution extends BaseClass{
	
	
	Page pg = new Page();
	@Test
	public void runMethod() {
		BaseClass.launchBrowser();
		BaseClass.loadUrl("https://www.flipkart.com/");
		pg.search.sendKeys("watch");
		pg.search.submit();
		System.out.println("Clicked Submit button");
		
		
	}
		
		
	}


