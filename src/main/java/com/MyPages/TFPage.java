package com.MyPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class TFPage extends BasePage {
	WebDriver driver;

	public TFPage(WebDriver driver) {
		this.driver = driver;
	}

	By Header_Locator = By.id("label-first");
	By ToggleButton_Locator = By.name("allbox");
	By DynamiclistItems_Locator = By.xpath("//div['todos-content']/child::*/ul//li//descendant::input");
	By DynamicinglelistItems_Locator = By.xpath("//ul//child::li[1]//input");

	By ListItemInsertBox_Locator = By.cssSelector("input[name='data']");
	By ListItemAddButton_Locator = By.cssSelector("input[name='submit'][value='Add']");
	By RemoveButton_Locator = By.cssSelector("input[name='submit'][value='Remove']");
	String beforePath = "input[name='todo[";
	String afterPath = "]']";
	boolean validation = false;


	public int createRandomNum() {
		return randomGenNum(1000);
	}

	public int randomGenNum2(int inbound, int outbound) {
		return randomGenNum(inbound, outbound);
	}

	public void clickToggleButton() {
		driver.findElement(ToggleButton_Locator).click();
	}

	public List<WebElement> dynamicList() {
		return driver.findElements(DynamiclistItems_Locator);
	}

	public void insertListIem(String ItemList, int ranNum) {
		driver.findElement(ListItemInsertBox_Locator).sendKeys(ItemList + ranNum);
	}

	public WebElement removeButton() {
		driver.findElement(RemoveButton_Locator).click();
		return (driver.findElement(RemoveButton_Locator));
	}

	public void addListItemButton() {
		driver.findElement(ListItemAddButton_Locator).click();
	}

	public void createListItemWithNum() {
		driver.findElement(ListItemInsertBox_Locator).sendKeys(String.valueOf(randomGenNum(500)));
		explicitWait(10, ListItemAddButton_Locator);
		addListItemButton();
	}

	public boolean validationOfAllListItemSelected(int listItemSize,List<WebElement> listItems1) {
		for (int i = 0; i < listItemSize; i++) {
			validation = listItems1.get(i).isSelected();
			}
		return validation;
	}
	public boolean validationOfOneListItemtRemoved1(int listItemSize,List<WebElement> listItems1) {
			
			try {
				int n = randomGenNum2(0, listItemSize);
				listItems1.get(n).click();
				System.out.println("Removed Item: " +listItems1.get(n).getText());
				removeButton();
				validation=true;
				} catch (Exception e) {
				e.printStackTrace();
			}
				return validation;
	}

}



















//WebElement allListItems = driver.findElement(By.cssSelector((beforePath) + i + afterPath));
