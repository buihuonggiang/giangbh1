package TRAINING.GIANGBH1.pages;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TRAINING.GIANGBH1.steps.serenity.common;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class pfontend{
	WebDriver dr;
	
	@FindBy(css="div.footer input[type=email]")
	public WebElement txtemail;

	@FindBy(css="button.next-btn-primary")
	public WebElement btndangky;

	@FindBy(id = "fullname")
	public WebElement txthoten;

	@FindBy(css = "button#ddlGender span.content-display")
	public WebElement cbgioitinh;

	@FindBy(css = "button#ddlNewsType span.content-display")
	public WebElement cbnewtype;
	
	@FindBy(id = "allow-button")
	public WebElement btndongy;
	
	@FindBy(css = "div#popover div.error")
	public WebElement msgerrorhoten;
	
	//gui mail
	public By extraForm = By.cssSelector("div.extra-subscription-form");
	
	@FindBy(css="button#allow-button")
	public WebElement btnagree;
	
	
	@FindBy(css="div.popover-dialog div.body-message")
	public WebElement lbActivatedNotify;
	
	public  pfontend(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);
		
	}
}
