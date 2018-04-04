package com.ski.pageObjects.Complaintparameter;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ski.helper.logger.LoggerHelper;
import com.ski.helper.waitHelper.WaitHelper;
import com.ski.pageObjects.Institution.institutionPage;
import com.ski.testBase.DataSource;

public class Complaintparameter {
	private WebDriver driver;
	private WaitHelper waitHelper;

	private static Logger log = LoggerHelper.getLogger(institutionPage.class);
	
	@FindBy(xpath = "//span[contains(text(),'Setup')]")
	static
	WebElement Setup;
	
	@FindBy(xpath = "//span[contains(text(),'College')]")
	WebElement College;
	
	@FindBy(xpath = "//span[contains(text(),'Institutions')]")
	WebElement Institutions;
	
	@FindBy(xpath = ".//*[@id='main-menu']/li[3]/ul/li[1]/ul/li[2]/a/span)]")
	WebElement Complaintparameter ;
	
	@FindBy(xpath = ".//*[@id='category_name']")
	WebElement parameter ;

	public Complaintparameter(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);	
		waitHelper.waitForElement(parameter, DataSource.getExplicitWait());
	}
	
	public static void clickSetup() {
		log.info("clicking on Setup ");
		Setup.click();
	}
	
	public void clickCollege() {
		log.info("clicking on College");
		College.click();
	}
	
	public void clickInstitutions() {
		log.info("clicking on Institutions");
		Institutions.click();
	}
	public void Complaintparameter() {
		log.info("clicking on Institutions");
		Complaintparameter.click();
	}
	
	public void enterComplaintparameter(String parameter) {
		log.info("entering BranchName as : " + parameter);
		this.parameter.sendKeys(parameter);
}
	public void createComplaintParameter(String parameter) {
		enterComplaintparameter(parameter);
	}
					
}
