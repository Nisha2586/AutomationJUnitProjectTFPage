package com.MyPages;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.Locator;

import utilPages.Readconfig;

public class BasePage {

	static WebDriver driver;
	static Readconfig read = new Readconfig();

	// @Before
	public static WebDriver init() {
		if (read.getBrowser().equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", read.getChromeBrowserPath());
			driver = new ChromeDriver();
		} else if (read.getBrowser().equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", read.getFireFoxBrowserPath());
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver", read.getIEBrowserPath());
			driver = new InternetExplorerDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(read.getBaseUrl());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return driver;
	}

	public int randomGenNum(int outbound) {
		Random ran = new Random();
		return ran.nextInt(outbound);
	}

	public int randomGenNum(int inbound, int outbound) {
		return (new Random().nextInt(outbound - inbound) + inbound);
	}

	public void explicitWait(int sec, WebElement webelement) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(webelement));
	}

	public void explicitWait(int sec, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	@After
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
