package com.ski.pageObjects.Institution;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ski.helper.logger.LoggerHelper;
import com.ski.helper.waitHelper.WaitHelper;
import com.ski.testBase.DataSource;

public class institutionPage {
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
	
	@FindBy(xpath = ".//*[@id='branch_name']")
	WebElement branch_name;
	
	@FindBy(xpath = "//input[@id='branch_code']")
	WebElement branch_code;

	@FindBy(xpath = "//input[@id='branch_address_line_1']")
	WebElement branch_address_line_1;
	
	@FindBy(xpath = "//input[@id='branch_address_line_2']")
	WebElement branch_address_line_2;

	@FindBy(xpath = "//input[@id='branch_country']")
	WebElement branch_country;
	
	@FindBy(xpath = "//input[@id='branch_state']")
	WebElement branch_state;
	
	@FindBy(xpath = "//input[@id='branch_city']")
	WebElement branch_city;
	
	@FindBy(xpath = "//input[@id='branch_pincode']")
	WebElement branch_pincode;
	
	@FindBy(xpath = "//input[@id='branch_email']")
	WebElement branch_email;
	
	@FindBy(xpath = "//input[@id='branch_website']")
	WebElement branch_website;
	
	@FindBy(xpath = "//input[@id='branch_student_login_prefix']")
	WebElement branch_student_login_prefix;
	
	@FindBy(xpath = "//input[@id='branch_employee_login_prefix']")
	WebElement branch_employee_login_prefix;
	
	@FindBy(xpath = "//input[@id='branch_phone']")
	WebElement branch_phone;
	
	@FindBy(xpath = "//input[@id='branch_fax']")
	WebElement branch_fax;

	@FindBy(xpath = "//input[@class='btn btn-primary pull-right']") 
	WebElement createbutton;
	
	
	
	public institutionPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement(branch_name, DataSource.getExplicitWait());
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
	
	public void enterBranchName(String branch_name) {
		log.info("entering BranchName as : " + branch_name);
		this.branch_name.sendKeys(branch_name);
	}
	
	public void enterBranchcode(String branch_code) {
		log.info("entering branch_code as : " +branch_code);
		this.branch_code.sendKeys(branch_code);
	}
	public void enterBranchAddressline1(String branch_address_line_1) {
		log.info("entering branch_address_line_1 as : " + branch_address_line_1);
		this.branch_address_line_1.sendKeys(branch_address_line_1);
	}
	public void enterBranchAddressline2(String branch_address_line_2) {
		log.info("entering branch_address_line_2 as : " +branch_address_line_2);
		this.branch_address_line_2.sendKeys(branch_address_line_2);
	}
	public void enterBranchCountry(String branch_country) {
		log.info("entering branch_country as : " + branch_country);
		this.branch_country.sendKeys(branch_country);
	}
	public void enterBranchstate(String branch_state) {
		log.info("entering branch_state as : " + branch_state);
		this.branch_state.sendKeys(branch_state);
	}
	public void enterBranchCity(String branch_city) {
		log.info("entering  branch_city as : " + branch_city);
		this.branch_city.sendKeys(branch_city);
	}
	public void enterpincode(String branch_pincode) {
		log.info("entering branch_pincode  as : " + branch_pincode);
		this.branch_pincode.sendKeys(branch_pincode);
	}
	public void enterBranchEmail(String branch_email) {
		log.info("entering branch_email as : " + branch_email);
		this.branch_email.sendKeys(branch_email);
	}
	public void enterBranchwebsite(String branch_website) {
		log.info("entering  branch_website as : " + branch_website);
		this.branch_website.sendKeys(branch_website);
	}
	
	public void enterBranchStudentLogin(String branch_student_login_prefix) {
		log.info("entering enterBranchStudentLogin as : " +branch_student_login_prefix);
		this.branch_student_login_prefix.sendKeys(branch_student_login_prefix);
	}
	
	public void enterBranchemployeelogin(String branch_employee_login_prefix) {
		log.info("entering first name as : " + branch_employee_login_prefix);
		this. branch_employee_login_prefix.sendKeys(branch_employee_login_prefix);
	}
	public void enterBranchphone(String branch_phone) {
		log.info("entering first name as : " +branch_phone);
		this.branch_phone.sendKeys(branch_phone);
	}
	public void enterBranchFax(String branch_fax) {
		log.info("entering first name as : " + branch_fax);
		this.branch_fax.sendKeys(branch_fax);
	}
	
	public void clickInstitutionscreatebutton() {
		log.info("clicking on Institutions createbutton");
		createbutton.click();
	}
	
	public void createInstitution(String userName, String password, String branch_name, String branch_code, String branch_address_line_1, String branch_address_line_2, String branch_country, String branch_state, String branch_city, String branch_pincode, String branch_email,
	String branch_website, String branch_student_login_prefix, String branch_employee_login_prefix, String branch_phone, String branch_fax, String runMode) {
		
		clickSetup();
		clickCollege();
		clickInstitutions();
		enterBranchName(branch_name);
		enterBranchcode(branch_code);
		enterBranchAddressline1(branch_address_line_1);
		enterBranchAddressline2(branch_address_line_2);
		enterBranchCountry(branch_country);
		enterBranchstate(branch_state);
		enterBranchCity(branch_city);
		enterpincode(branch_pincode);
		enterBranchEmail(branch_email);
		enterBranchwebsite(branch_website);
		enterBranchStudentLogin(branch_student_login_prefix);
		enterBranchemployeelogin(branch_employee_login_prefix);
		enterBranchphone(branch_phone);
		enterBranchFax(branch_fax);
		clickInstitutionscreatebutton();

	}}
