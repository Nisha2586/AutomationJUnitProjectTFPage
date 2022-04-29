package validationTest;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.MyPages.BasePage;
import com.MyPages.TFPage;

public class ValidationOfCreatingListAndDeletingSame extends BasePage {
	WebDriver driver;
	TFPage tfPage;
	String inputItem = "TestItem";
	String beforePath = "//ul//child::li[";
	String afterPath = "]//input";
	boolean validation = false;
@Test	
public void validationOfCreatingListItemAndDeleting() throws InterruptedException {
	driver = BasePage.init();
	tfPage = PageFactory.initElements(driver, TFPage.class);
	
	int ranNum = tfPage.createRandomNum();
	tfPage.insertListIem(inputItem, ranNum);
	tfPage.addListItemButton();
	Thread.sleep(5000);
	
	List<WebElement> listItems = tfPage.dynamicList();
	System.out.println();
	for (WebElement w : listItems) {
		System.out.println("List Items Before Removal : " + w.getText());
	}
	String suffix = "" + ranNum;
	try {
		for (int i = 0; i < listItems.size(); i++) {
			WebElement allListItems = driver.findElement(By.xpath((beforePath) + i + afterPath));
			retryingFindClick(allListItems);
			if (allListItems.getText().endsWith(suffix)) {
				System.out.println("Newly Added ListItem : " + allListItems.getText());
				allListItems.click();
				tfPage.removeButton();
				validation=true;
					}break;
		}
			List<WebElement> listItems2 = tfPage.dynamicList();
			if(listItems2.isEmpty()) {
				System.out.println("No More List Items");
			}else {
			for (WebElement w1 : listItems2) {
				System.out.println("List Items After Removed : " + w1.getText());
			}
			
		}
	}catch(Exception e) {e.printStackTrace();}
	
}

public boolean retryingFindClick(WebElement by) {
	int attempts = 0;
	while (attempts < 2) {
		try {
			// driver.findElement(by).click();
			by.click();
			validation = true;
			break;
		} catch (StaleElementReferenceException e) {
		}
		attempts++;
	}
	return validation;
}
}
