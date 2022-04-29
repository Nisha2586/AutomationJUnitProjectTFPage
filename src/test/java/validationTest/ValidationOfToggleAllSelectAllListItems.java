package validationTest;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.MyPages.BasePage;
import com.MyPages.TFPage;

public class ValidationOfToggleAllSelectAllListItems extends BasePage {
	WebDriver driver;
	TFPage tfPage;
	String inputItem = "TestItem";
	boolean validation = false;

	@Test
	public void validateToggleAllAndItemBoxAllChecked() throws InterruptedException {
		driver = BasePage.init();
		tfPage = PageFactory.initElements(driver, TFPage.class);

		//Creation of ListItems
		Thread.sleep(5000);
		tfPage.createListItemWithNum();
		tfPage.createListItemWithNum();
	

		tfPage.clickToggleButton();
		try {
			List<WebElement> listItems = tfPage.dynamicList();
			int listItemSize = listItems.size();
			if (!listItems.isEmpty()) {
				validation =tfPage.validationOfAllListItemSelected(listItemSize,listItems);
			}else {System.out.println("No ListItems found!!!");}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		Assert.assertEquals("All list item checkBoxes are checked on !!", true, validation);
		System.out.println(
				"when the toggle all check box is CHECKED, all check boxes for list items are also CHECKED ON." + validation);
		
	}



}


