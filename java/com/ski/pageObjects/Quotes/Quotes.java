package com.ski.pageObjects.Quotes;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ski.helper.logger.LoggerHelper;
import com.ski.helper.waitHelper.WaitHelper;
import com.ski.pageObjects.Home.homePage;
import com.ski.testBase.DataSource;

public class Quotes {
  private WebDriver driver;
  private WaitHelper waitHelper;
  private static Logger log=LoggerHelper.getLogger(Quotes.class);
  
  @FindBy(xpath="//span[contains(text(),'Quote Of The Day')]")
  WebElement QuotesoftheDay;
  
  @FindBy(xpath="//textarea[@id='quotation_quotation']")
  WebElement Quotation;
  
  @FindBy(xpath="//input[@value='Create']")
  WebElement Create;
   
  public Quotes(WebDriver driver)
  {
	  super();
	  this.driver=driver;
	  PageFactory.initElements(driver, this);
	  waitHelper=new WaitHelper(driver);
	  waitHelper.waitForElement(QuotesoftheDay ,DataSource.getExplicitWait());
  }  
	public void clickQuotesoftheDay() {
		log.info("clicking QuotesoftheDay");
		QuotesoftheDay.click();
	}

	public void enterQuotation(String Quotation) {
		log.info("entering setQuotation: " + Quotation);
		this.Quotation.sendKeys(Quotation);
	}
	
	public void  Create() {
		log.info("clicking  Create button");
		 Create.click();
	}
	

	public void testcreateQuotes(String quotation) {
		clickQuotesoftheDay();
		//enterQuotation(Quotation);
		Create();
	}
	



}
