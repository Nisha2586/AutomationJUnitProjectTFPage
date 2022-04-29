package validationTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.MyPages.BasePage;
import com.MyPages.TFPage;

public class ValidationOfRemovingOneListItem extends BasePage{
	WebDriver driver;
	TFPage tfPage;
	String inputItem = "TestItem";
	boolean validation = false;

	@Test
	public void validateSingleListItemRemoved() throws InterruptedException {
		driver = BasePage.init();
		tfPage = PageFactory.initElements(driver, TFPage.class);
		
		//Creation of ListItems
		int ranNum = tfPage.createRandomNum();
		tfPage.insertListIem(inputItem, ranNum);
		tfPage.addListItemButton();
		tfPage.createListItemWithNum();
		Thread.sleep(5000);
		
		//tfPage.clickToggleButton();
		List<WebElement> listItems2 = tfPage.dynamicList();
		for (WebElement w : listItems2) {
			System.out.println("List items before removal :" + w.getText());
		}
		if (!listItems2.isEmpty()) {
			 validation=tfPage.validationOfOneListItemtRemoved1(listItems2.size(), listItems2);
			 Assert.assertEquals(true, validation);
		} 				
	
			System.out.println("Validation of single item removed is done ." + validation);
		
	}

}
