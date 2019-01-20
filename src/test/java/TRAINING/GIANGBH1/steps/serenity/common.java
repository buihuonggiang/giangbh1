package TRAINING.GIANGBH1.steps.serenity;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.sql.Ref;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import TRAINING.GIANGBH1.pages.pfontend;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.requirements.ChildrenFirstOrderedMap;

public class common {
	public pfontend pfe;
	public static WebDriver driver;
	
	@Before
	public void BeforeScenario() {
		String webdriver = System.getProperty("browser", "chrome");
		switch (webdriver) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\DEVEnviroment\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "D:\\DEVEnviroment\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		default:
            throw new RuntimeException("Unsupported webdriver: " + webdriver);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
	}
	
	@After
	public void AfterScenario(Scenario scenario) {
		driver.quit();
	}
	
	@Step
	public void is_home_page(WebDriver driver,String url) {
		driver.get(url);	
	}
	
	@Step
	public void input_Text(WebDriver driver, WebElement element, String input) {
		element.sendKeys(input);
	}
	
	@Step
	public void click_button(WebDriver driver, WebElement element) {
		element.click();
	}
	
	@Step
	public String get_text(WebDriver driver, WebElement element) {
		return element.getText();
	}
	
	@Step
	public void clear_text(WebDriver driver, WebElement element) {
		element.clear();
	}
	
	@Step
	public void outprint(String value) {
		System.out.println(value);
	}
	
	@Step
	public void scrolled_element_into_view(WebDriver driver, WebElement element) {
		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Step
	private static void setClipboardData(String string) {
		// StringSelection is a class that can be used for copy and paste
		// operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	@Step
	public static void uploadFile(String fileLocation) {
		try {
			// Setting clip board with file location
			setClipboardData(fileLocation);
			// native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			//robot.keyRelease(KeyEvent.VK_V);
			//robot.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(3000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	@Step
	public static void switch_window(WebDriver driver, String windowHandler) {
		
		if (!windowHandler.isEmpty()) {
			driver.switchTo().window(windowHandler);
		} else {
			for (String handle : driver.getWindowHandles()) {
				driver.switchTo().window(handle);
			}
		}
	}

	@Step
	public static boolean checkExistFile(String fileLocation) {
		File f = new File(fileLocation);
		if (f.exists() && !f.isDirectory())
			return true;
		return false;
	}
	@Step
	public static String getHref(String content)
	{
		String str = "<a href=\"http://testmaster.vn/\">Click</a>";
		Pattern p = Pattern.compile("href=\\\"(?<link>.*)\\\"");
		Matcher m = p.matcher(content);
		if (m.find()) {
			return m.group(m.groupCount());
		}
		return "";
	}
	@Step
	public void waitelement(WebDriver driver, WebElement element)
	{
	WebDriverWait waiter = new WebDriverWait(driver, 10);
	waiter.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	@Step
	public void getcelltable(WebDriver driver, WebElement table_element)
	{
		List<WebElement> rows=table_element.findElements(By.xpath("/html/body/div[1]/div/div/table/thead/tr/th"));
		for(int rnum=0;rnum<rows.size();rnum++)
		{
		List<WebElement> columns=rows.get(rnum).findElements(By.xpath("/html/body/div[1]/div/div/table/tbody/tr[2]/td[2]"));
		System.out.println("Number of columns:"+columns.size());
		for(int cnum=0;cnum<columns.size();cnum++)
		{
		System.out.println(columns.get(cnum).getText());
		}
		}

        
	}

}
