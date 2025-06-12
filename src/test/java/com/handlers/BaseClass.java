package com.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;

	public static void launchBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public static void loadUrl(String url) {
		driver.get(url);
	}

	public static WebElement searchElementById(String idValue) {
		return driver.findElement(By.id(idValue));
	}
	public static WebElement searchElementByName(String name) {
		return driver.findElement(By.name(name));
	}

	public static WebElement searchElementByClassName(String className) {
		return driver.findElement(By.className(className));
	}
	public static WebElement searchElementByTagName(String tagName) {
		return driver.findElement(By.tagName(tagName));
	}

	public static WebElement searchElementBylinkText(String linkText) {
		return driver.findElement(By.linkText(linkText));
	}

	public static WebElement searchElementByPartialLinkText(String partialLink) {
		return driver.findElement(By.partialLinkText(partialLink));
	}

	public static WebElement searchElementByxpath(String xpath) {
		return driver.findElement(By.xpath(xpath));
	}

	public static WebElement searchElementByCssSelector(String cssselector) {
		return driver.findElement(By.cssSelector(cssselector));
	}

	public static void validation(String xpath, String expectedText) {
		String actualText = searchElementByxpath(xpath).getText();
		try {
			if(actualText.equalsIgnoreCase(expectedText)) {
				System.out.println("Validation success");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public static void jsClick(WebElement element) {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);

	}
	
	public static void alertMethod() {
		driver.switchTo().alert().accept();
	}

	public static void explicitWait(long sec) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public static void closeDriver() {
		driver.quit();
	}
	
	public static String excelRead(String SheetName, int rowVal, int entercell) throws IOException {
		
		String  outPut="";

		File file =new File("E:\\Meena_Eclipse\\eclipse-workspace-Meena\\Automation\\Testdata.xlsx");
		FileInputStream fis =new FileInputStream(file);
		Workbook wb =new XSSFWorkbook(fis);
		Sheet sheet = wb.getSheet(SheetName);
//		int numberOfRows = sheet.getPhysicalNumberOfRows();
//		for(i=0;i<numberOfRows;i++) {
//			Row row = sheet.getRow(i);
//			int numberOfCells = row.getPhysicalNumberOfCells();
//			for(j=0;j<numberOfCells;j++) {
//				Cell cell = row.getCell(j);
//				CellType cellType = cell.getCellType();
//				if(cellType==CellType.NUMERIC) {
//					if(DateUtil.isCellDateFormatted(cell)) {
//						Date dateCellValue = cell.getDateCellValue();
//						SimpleDateFormat sf =new SimpleDateFormat();
//						outPut = sf.format(dateCellValue);
//						}
//					else {
//						double numericCellValue = cell.getNumericCellValue();
//						int numberValue=(int)numericCellValue;
//						outPut = String.valueOf(numberValue);
//					}
//				}
//				else if(cellType==CellType.STRING) {
//					outPut = cell.getStringCellValue();
//				}
//			}
		Row row = sheet.getRow(rowVal);
		Cell cell = row.getCell(entercell);
		CellType cellType = cell.getCellType();
		if(cellType==CellType.NUMERIC) {
			if(DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat sf =new SimpleDateFormat("dd/MM/yyyy");
				outPut = sf.format(dateCellValue);
				}
			else {
				double numericCellValue = cell.getNumericCellValue();
				int numberValue=(int)numericCellValue;
				outPut = String.valueOf(numberValue);
			}
		}
		else if(cellType==CellType.STRING) {
			outPut = cell.getStringCellValue();
		}
		return outPut;

		}
		}


