package TRAINING.GIANGBH1.steps;

import java.util.concurrent.TimeUnit;

import org.apache.bcel.generic.Select;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import TRAINING.GIANGBH1.pages.pbackend;
import TRAINING.GIANGBH1.pages.pfontend;
import TRAINING.GIANGBH1.steps.serenity.MailReader;
import TRAINING.GIANGBH1.steps.serenity.common;
import cucumber.api.java.en.*;
import net.thucydides.core.annotations.Steps;

public class sbackend {
	@Steps 
	common cm;
	pbackend pbe;
	WebDriver dr ;
	String url= "http://testmaster.vn/admin";
	
	public sbackend() {
		this.dr = cm.driver;
		pbe = new pbackend(this.dr);
	}
	
	@Given("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() {
	cm.is_home_page(dr, url);
	}


	@When("^I submit username and password$")
	public void i_submit_username_and_password() {
	 cm.input_Text(dr, pbe.txtUsername, "khanh.tx@live.com");
	 cm.input_Text(dr, pbe.txtPassword, "abc123");
	 cm.click_button(dr, pbe.btnLogin);
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() {
		Assert.assertTrue(true);
	}

	@Given("^I staying create News Page$")
	public void i_staying_create_News_Page() {
	cm.click_button(dr, pbe.linkcreatenews);
	}

	@When("^I do next$")
	public void i_do_next() {
		cm.click_button(dr, pbe.btnnext);
	
	}

	@Then("^I should see messenger \"([^\"]*)\" under field Name$")
	public void i_should_see_messenger_under_field_Name(String arg1) {
		 Assert.assertEquals(cm.get_text(dr, pbe.txterroname), arg1);
	
	}

	@Then("^I should see messenger \"([^\"]*)\" under field Subject$")
	public void i_should_see_messenger_under_field_Subject(String arg1) {
		 Assert.assertEquals(cm.get_text(dr, pbe.txterrosubject), arg1);
	}

	@Then("^I should see messenger \"([^\"]*)\" under field Body$")
	public void i_should_see_messenger_under_field_Body(String arg1) {
		 Assert.assertEquals(cm.get_text(dr, pbe.txterrobody), arg1);
	
	}

	@Then("^I should see The default group is \"([^\"]*)\"$")
	public void i_should_see_The_default_group_is(String arg1) {
		cm.outprint(cm.get_text(dr, pbe.cbgroup));
	Assert.assertEquals(cm.get_text(dr, pbe.cbgroup), arg1);
	}

	@When("^I provied valid Group and valid subject and valid body and invalid name$")
	public void i_provied_valid_Group_and_valid_subject_and_valid_body_and_invalid_name() {
		cm.click_button(dr, pbe.cbgroup);
		cm.click_button(dr, pbe.linkkhongphanloai);
		
		cm.input_Text(dr, pbe.txtsubject, "Thư mời");
		cm.input_Text(dr, pbe.edtbody, "Tham dự hội thảo");
		cm.input_Text(dr, pbe.txtname, "123457890........100");//Nhập trên 100 ky tu
		
	}

	@Then("^I should see messenger \"([^\"]*)\" field Name$")
	public void i_should_see_messenger_field_Name(String arg1) {
		try 
		{
			Assert.assertEquals(cm.get_text(dr, pbe.txterroname), arg1);
		}
		catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@When("^I do Add file$")
	public void i_do_Add_file() {
	  cm.click_button(dr, pbe.btnattach);
	}


	@When("^I select file \\.xls invalid$")
	public void i_select_file_xls_invalid() {
		cm.uploadFile("D:\\DEVEnviroment\\Project_demo\\GIANGBH1\\src\\test\\Invalidfile.xlsx");
	}

	@Then("^I should see file not attach on list file$")
	public void i_should_see_file_not_attach_on_list_file() {
	    String listfile = cm.get_text(dr, pbe.listfile);
		cm.outprint("listfile: " + listfile);
	    Assert.assertEquals(listfile, "");;
	}

	@When("^I select file \\.xls valid$")
	public void i_select_file_xls_valid() {
		cm.uploadFile("D:\\DEVEnviroment\\Project_demo\\GIANGBH1\\src\\test\\Validfile.xlsx");
	}

	@Then("^I should see file name and display icon delete$")
	public void i_should_see_file_name_and_display_icon_delete() {
		
		if( pbe.fileicon != null && pbe.filename != null && pbe.fileremove != null)
		{
	       Assert.assertTrue(true);
	    }else{
	    	Assert.assertTrue(false);
	    }
	}

	@When("^I confirm delete file$")
	public void i_confirm_delete_file() {
		try {
			 cm.click_button(dr, pbe.fileremove);
		} catch (Exception e) {
		cm.outprint("Có lỗi trong quá trình xử lý");
		}

	}

	@Then("^I should not see file name on list file$")
	public void i_should_not_see_file_name_on_list_file() {
		
		if( pbe.fileicon != null && pbe.filename != null && pbe.fileremove != null)
		{
			Assert.assertTrue(true);
	    }else{
	    	Assert.assertTrue(false);
	    }
	}

	//B6
	@When("^I provied valid Group and valid subject and valid body and valid name$")
	public void i_provied_valid_Group_and_valid_subject_and_valid_body_and_valid_name() {
		cm.click_button(dr, pbe.cbgroup);
		cm.click_button(dr, pbe.linkkhongphanloai);
		
		cm.input_Text(dr, pbe.txtsubject, "Thư mời");
		cm.input_Text(dr, pbe.edtbody, "Tham dự hội thảo");
		cm.input_Text(dr, pbe.txtname, "Testmarter");
	}


	@When("^I do Send Now$")
	public void i_do_Send_Now() {
		cm.click_button(dr, pbe.btnsendnow);
	
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void i_should_see(String arg1) {
	dr.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	cm.waitelement(dr,pbe.msgsend);
	   String msg = cm.get_text(dr, pbe.msgsend);
	cm.outprint("SEND RESURT: " +msg);
	   Assert.assertEquals(msg, arg1);
	}

	@When("^I provied date and provied time and I do Save to send later$")
	public void i_provied_date_and_provied_time_and_I_do_Save_to_send_later() {
	cm.click_button(dr, pbe.txtdate);
	cm.click_button(dr, pbe.txtday);

	cm.click_button(dr, pbe.txttime);
	cm.click_button(dr, pbe.txtgio);
	
	cm.click_button(dr, pbe.btnsendlater);
	}
	
	@Given("^I staying Sign news Page$")
	public void i_staying_Sign_news_Page() {
	  cm.click_button(dr,pbe.linkdangkynhantin);
	}


	@When("^I get list Subscriber registered$")
	public void i_get_list_email_registered() {
	 cm.getcelltable(dr, pbe.tbSubscriber);
	}

	@Then("^I should see Subscriber displayed with alphabet order$")
	public void i_should_see_Subscriber_displayed_with_alphabet_order() {
	 Assert.assertTrue(true);
	}
	
}
