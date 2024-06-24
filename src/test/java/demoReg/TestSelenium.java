package demoReg;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSelenium {

	@BeforeClass
	public void dummystart() {
		System.out.println("Out");
	}

	@Test(enabled = false, groups = "regression")
	public void myTest() {
		System.out.println("Hello");
	}

	@Test(description = "Dummy")
	public void myTest2() {
		WebDriverManager.chromedriver().setup();

//		ChromeOptions chrome = new ChromeOptions();
//		chrome.addArguments("--headless=new");

		WebDriver driver = new ChromeDriver();
		driver.get("https://platform.text.com/tools/diff-checker");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement ele1 = driver.findElement(By.xpath("//div[@class='diff-checker_fields__4J7h7']/div[1]//textarea"));

		ele1.click();
		ele1.sendKeys("Hello");
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("A").sendKeys("C").keyUp(Keys.CONTROL).perform();

		act.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();

		act.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

		TakesScreenshot sc = (TakesScreenshot) driver;

		File source = sc.getScreenshotAs(OutputType.FILE);

		File target = new File(System.getProperty("user.dir") + "//screenshots//full.jpg");
		source.renameTo(target);

		driver.quit();
	}

}
