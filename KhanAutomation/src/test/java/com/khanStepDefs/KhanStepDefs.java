package com.khanStepDefs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KhanStepDefs {
	WebDriver driver;
	ArrayList<String> PriceList;
	

@Given("^user go to automation practice home page$")
public void user_go_to_automation_practice_home_page() throws Throwable {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
  driver = new ChromeDriver();
  driver.get("http://automationpractice.com/index.php");
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}


@Then("^user verify the page title as \"([^\"]*)\"$")
public void user_verify_the_page_title_as(String arg1) throws Throwable {
	String etitel = arg1;
	String atitel = driver.getTitle();
	Assert.assertEquals(etitel, atitel);
   
}

@Then("^user click the sign in button on the right$")
public void user_click_the_sign_in_button_on_the_right() throws Throwable {
	driver.findElement(By.xpath("//*[@title='Log in to your customer account']")).click();
	JavascriptExecutor jsc = (JavascriptExecutor) driver;
	jsc.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
   
}

@Then("^user enter valid username and password$")
public void user_enter_valid_username_and_password() throws Throwable {
	driver.findElement(By.xpath("(//*[@name='email'])[1]")).sendKeys("sharfuddin80khan@gmail.com");
	driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("entou07");
    
}

@Then("^user click the sing in button$")
public void user_click_the_sing_in_button() throws Throwable {
	driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]")).click();
   
}

@Then("^user click on the upper left corner Dresses link and display should show (\\d+) dresses$")
public void user_click_on_the_upper_left_corner_Dresses_link_and_display_should_show_dresses(int arg1) throws Throwable {
	driver.findElement(By.xpath("//*[@id='block_top_menu']/ul/li[2]/a")).click();
	JavascriptExecutor jsc = (JavascriptExecutor) driver;
	jsc.executeScript("window.scrollBy(0,500)");
	Thread.sleep(3000);
   
}

@Then("^user Print all the dress prices in descending order on the console$")
public void user_Print_all_the_dress_prices_in_descending_order_on_the_console() throws Throwable {
	JavascriptExecutor jsc = (JavascriptExecutor) driver;
	jsc.executeScript("window.scrollBy(0,800)");

	List<WebElement> DressPrices = driver
			.findElements(By.xpath("//*[@class='product-desc']/following-sibling::div[1]"));

	PriceList = new ArrayList<String>();

	for (int i = 0; i < DressPrices.size(); i++) {
		PriceList.add(DressPrices.get(i).getText().toString());
	}

	Collections.sort(PriceList, Collections.reverseOrder());

	System.out.println("Dress Prices in Descending Order:" + PriceList);
   
}

@Then("^user select the second dress on that current list and remember the price \\(the list may change so it is dynamic\\)$")
public void user_select_the_second_dress_on_that_current_list_and_remember_the_price_the_list_may_change_so_it_is_dynamic() throws Throwable {
	driver.findElement(By.xpath("(//*[contains(text(),'30.50')])[2]")).click();
}

@Then("^user click on the next page Proceed to checkout$")
public void user_click_on_the_next_page_Proceed_to_checkout() throws Throwable {
	driver.findElement(By.xpath("//*[contains(text(),'Proceed to checkout')]")).click();
	Thread.sleep(3000);
}

@When("^user On the next page verify there is a Total price with shipping$")
public void user_On_the_next_page_verify_there_is_a_Total_price_with_shipping() throws Throwable {
	Thread.sleep(3000);
	String actual =driver.findElement(By.xpath("(//*[contains(text(),'$32.50')])[4]")).getText().trim();
	String expected = "$32.50";
	Assert.assertTrue("price don't match", actual.contains(expected));
    
}

@Then("^user click on the sing out button from Mystore and close the window$")
public void user_click_on_the_sing_out_button_from_Mystore_and_close_the_window() throws Throwable {
	driver.findElement(By.xpath("(//*[contains(text(),'Sign out')])[1]")).click();
	driver.close();
   
}



	}


