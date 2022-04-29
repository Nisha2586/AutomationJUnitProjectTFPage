//package validationTest;
//
//import java.util.concurrent.TimeUnit;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//
//import com.MyPages.BasePage;
//
//import utilPages.Readconfig;
//
//public class TestBase {
//	static WebDriver driver;
//	static Readconfig read;
//	
//	
//	//@BeforeClass
//	public static  WebDriver init() {
//		read = new Readconfig();
//		if (read.getBrowser().equalsIgnoreCase("chrome")) {
//			System.setProperty("webdriver.chrome.driver",read.getChromeBrowserPath() );
//			driver = new ChromeDriver();
//		}
//		else if(read.getBrowser().equalsIgnoreCase("firefox")) {
//			System.setProperty("webdriver.gecko.driver",read.getFireFoxBrowserPath());
//			driver = new FirefoxDriver();		
//		}
//		else  {
//			System.setProperty("webdriver.ie.driver",read.getIEBrowserPath());
//			driver = new InternetExplorerDriver();		
//		}
//		driver.manage().deleteAllCookies();
//		driver.manage().window().maximize();
//		driver.get(read.getBaseUrl());
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		return driver;
//	}
//	
//	@After
//	public void tearDown() {
//		driver.close();
//		driver.quit();
//	}
//}
