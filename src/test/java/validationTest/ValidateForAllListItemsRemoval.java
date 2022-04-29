package validationTest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.MyPages.BasePage;
import com.MyPages.TFPage;



public class ValidateForAllListItemsRemoval extends BasePage {
	WebDriver driver;
	TFPage tfPage;
	String inputItem = "TestItem";
	boolean validation = false;

	@Test
	public void validateToggleAndItemBoxChecked() throws InterruptedException {
		driver = init();
		tfPage = PageFactory.initElements(driver, TFPage.class);

		//Creation of list items
		Thread.sleep(5000);
		int ranNum = tfPage.createRandomNum();
		tfPage.insertListIem(inputItem, ranNum);
		tfPage.addListItemButton();
		tfPage.createListItemWithNum();

		
		List<WebElement> listItems4 = tfPage.dynamicList();
		tfPage.clickToggleButton();
		tfPage.removeButton();
		Thread.sleep(3000);
		
		List<WebElement> listItems = tfPage.dynamicList();
		Assert.assertEquals(true, listItems.isEmpty());
		System.out.println(
				"validation of all list item could be removed using the remove button and when \"Toggle All\" functionality is on is :"
				+  listItems.isEmpty() );
	}

}
