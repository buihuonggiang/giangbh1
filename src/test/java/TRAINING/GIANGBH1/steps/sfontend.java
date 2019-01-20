package TRAINING.GIANGBH1.steps;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import TRAINING.GIANGBH1.pages.pfontend;
import TRAINING.GIANGBH1.steps.serenity.MailReader;
import TRAINING.GIANGBH1.steps.serenity.common;
import TRAINING.GIANGBH1.steps.serenity.common;
import cucumber.api.java.en.*;
import net.serenitybdd.core.annotations.findby.By;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

public class sfontend {
	@Steps 
	common cm;
	pfontend pfe;
	WebDriver dr ;
	String emailContent="";
	MailReader mailReader;
	String url= "http://testmaster.vn";
	
	public sfontend() {
		this.dr = common.driver;
		pfe = new pfontend(this.dr);
	}
	
	@Given("^I staying on the home page$")
	public void i_staying_on_the_home_page() {
		cm.is_home_page(dr,url);
	}
	
	@When("^I provide valid email and I do regist$")
	public void i_provide_valid_email_and_I_do_regist() {
		cm.scrolled_element_into_view(this.dr,pfe.txtemail);
		Random random = new Random();

		// generate a random integer from 0 to 899, then add 100
		int x = random.nextInt(900) + 100;
		cm.input_Text(dr, pfe.txtemail, x+"huonggiang28121991@gmail.com");
		cm.click_button(dr, pfe.btndangky);
	}
	
	@Then("^I should see Fullname null value on form provide information$")
	public void i_should_see_Fullname_null_value_on_form_provide_information() {
		String hoten = cm.get_text(dr, pfe.txthoten);
		cm.outprint("Ho Ten mac dinh: " + hoten);
		Assert.assertEquals(hoten,"");
	}

	@Then("^I should see Gender Unknown value on form provide information$")
	public void i_should_see_Gender_Unknown_value_on_form_provide_information() {
		String gioitinh = cm.get_text(dr, pfe.cbgioitinh);
		cm.outprint("Gioi tinh mac dinh: " + gioitinh);
		Assert.assertEquals(gioitinh,"Không xác định");
	}
	
	@Then("^I should see Newtype all value on form provide information$")
	public void i_should_see_Newtype_all_value_on_form_provide_information() {
		String type = cm.get_text(dr, pfe.cbnewtype);
		cm.outprint("Loại tin mac dinh: " + type);
		Assert.assertEquals(type,"Nhận tất cả các loại tin");
	}
	
	@When("^I provide Fullname null$")
	public void i_provide_Fullname_null() {
		cm.clear_text(dr, pfe.txthoten);
	}

	@When("^I do accept$")
	public void i_do_accept() {
		cm.click_button(dr, pfe.btndongy);
	}

	@Then("^I should see messenger error \"([^\"]*)\" under field fullname$")
	public void i_should_see_messenger_error_under_field_fullname(String arg1) {
		String error = cm.get_text(dr, pfe.msgerrorhoten);
		cm.outprint("Thong bao loi ho ten : "+error);
		Assert.assertEquals(error, arg1);	
	}
	
	
	
	@When("^I provide valid Fullname and valid Gender and valid Newtype$")
	public void i_provide_valid_Fullname_and_valid_Gender_and_valid_Newtype() {
		WebDriverWait waiter = new WebDriverWait(dr, 10);
		WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(pfe.txthoten));
		cm.input_Text(dr,element, "Bui Huong Giang");
	}
	
	@When("^I do agree and wait new mail Confirm registration in Inbox mail$")
	public void i_do_agree_and_wait_new_mail_Confirm_registration_in_Inbox_mail() {
		WebDriverWait waiter = new WebDriverWait(dr, 30);
		WebElement element = waiter.until(ExpectedConditions.elementToBeClickable(pfe.btnagree));
		cm.click_button(dr,element);
		while(true)
		{
			mailReader = new MailReader("huonggiang28121991@gmail.com","Dh171090@");
			if(mailReader.messages.length>0)
			{
				emailContent = mailReader.getContent(mailReader.messages[0]);
				System.out.println(emailContent);
			}
			if(emailContent=="")
				try {
					Thread.sleep(60000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				break;
		}
		
	}


	@When("^I open Activation Link in inbox mail$")
	public void i_open_Activation_Link_in_inbox_mail() {
		String activationLink = cm.getHref(emailContent);
		if(!activationLink.isEmpty())
		{
			dr.get(activationLink);
			dr.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	}

	@Then("^I should see message \"([^\"]*)\"$")
	public void i_should_see_message(String arg1) {
		String msg = cm.get_text(dr, pfe.lbActivatedNotify);
		cm.outprint("Thong bao : "+msg);
		Assert.assertEquals(msg, arg1);	
	}



	

}
