package test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.moneycorp.com/en-gb/");
		WebElement languageList = driver.findElement(By.id("language-dropdown-flag"));
		languageList.click();

		driver.findElement(By.xpath("//*[@id=\"nav-languages-overlay\"]/div/ul/li[9]/a")).click();

		WebElement foreignExchangeSolutions = driver
				.findElement(By.xpath("/html/body/section/div[4]/div[3]/div/div/div[1]/div/a"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", foreignExchangeSolutions);
		String foreignExchangeSolutionsURL = "https://www.moneycorp.com/en-us/business/foreign-exchange-solutions/";
		if (!driver.getCurrentUrl().equalsIgnoreCase(foreignExchangeSolutionsURL)) {
			driver.close();
		}

		driver.findElement(By.xpath("/html/body/section/div[1]/header/div[2]/div/div[3]/button[1]")).click();

		WebElement navSearch = driver.findElement(By.id("nav_search"));
		navSearch.sendKeys("international payments");
		navSearch.sendKeys(Keys.ENTER);

		String internationalPaymentsURL = "https://www.moneycorp.com/en-us/search/?q=international+payments";

		if (!driver.getCurrentUrl().equalsIgnoreCase(internationalPaymentsURL)) {
			driver.close();
		}
	}
}
