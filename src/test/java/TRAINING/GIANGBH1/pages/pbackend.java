package TRAINING.GIANGBH1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class pbackend {
	WebDriver dr;

	@FindBy(css = "div.login-form input[type=email]")
	public WebElement txtUsername;

	@FindBy(css = "div.login-form input[type=password]")
	public WebElement txtPassword;

	@FindBy(css = "div.login-form button.btn-login")
	public WebElement btnLogin;
	
	@FindBy(xpath = "//ul[2]/li[4]/a/span")
	public WebElement linkcreatenews;

	@FindBy(css = "button#ddlGroup")
	public WebElement cbgroup;

	@FindBy(css = "input#txtName")
	public WebElement txtname;

	@FindBy(css = "input#txtSubject")
	public WebElement txtsubject;

	@FindBy(css = "div.note-editable.panel-body")
	public WebElement edtbody;

	@FindBy(xpath = "//input[@name=\"myfile\"]")
	public WebElement btnattach;

	@FindBy(css = "button.btn.btn-sm.btn-primary.btn-next")
	public WebElement btnnext;
	
	@FindBy(css = "div:nth-child(7) > .error:nth-child(2)")
	public WebElement txterroname;
	
	@FindBy(css = "div:nth-child(10) > .error:nth-child(2)")
	public WebElement txterrosubject;
	
	@FindBy(xpath="//div[3]/div/ul/li/a")
	public WebElement linkkhongphanloai;
	
	@FindBy(css = "div:nth-child(13) > .error:nth-child(3)")
	public WebElement txterrobody;
	
	@FindBy(css = "div.list-files")
	public WebElement listfile;
	
	@FindBy(css = "div.list-files table tbody tr td.file-icon")
	public WebElement fileicon;
	
	@FindBy(css = "div.list-files table tbody tr td.file-name")
	public WebElement filename;
	
	@FindBy(css = "div.list-files table tbody tr td.file-remove")
	public WebElement fileremove;
	
	@FindBy(css = "button#sendNow")
	public WebElement btnsendnow;
	
	@FindBy(css = "button.btn.btn-sm.btn-primary.btn-save-news")
	public WebElement btnsendlater;
	
	@FindBy(css = "input#input-date")
	public WebElement txtdate;
	
	@FindBy(xpath = "//tr[4]/td")
	public WebElement txtday;
	
	@FindBy(css = "input#input-time")
	public WebElement txttime;
	
	@FindBy(xpath = "//td[2]/ul/li[6]/a")
	public WebElement txtgio;
	
	@FindBy(css = "div.body-message")
	public WebElement msgsend;
	
	@FindBy(xpath = "//ul[2]/li[2]/a/span")
	public WebElement linkdangkynhantin;
	
	@FindBy(css = "table.table.table-hover.table-bordered")
	public WebElement tbSubscriber;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/table/thead/tr/th")
	public WebElement tbcol;
	
	@FindBy(xpath = "/html/body/div[1]/div/div/table/tbody/tr[2]/td")
	public WebElement tbrow;

	public pbackend(WebDriver dr) {
		this.dr = dr;
		PageFactory.initElements(dr, this);

	}
}
