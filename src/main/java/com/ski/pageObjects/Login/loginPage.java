package com.ski.pageObjects.Login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ski.helper.logger.LoggerHelper;
import com.ski.helper.waitHelper.WaitHelper;
import com.ski.pageObjects.Home.homePage;
import com.ski.testBase.DataSource;

public class loginPage {
	private WebDriver driver;
	private WaitHelper waitHelper;

	private static Logger log = LoggerHelper.getLogger(loginPage.class);
	@FindBy(xpath = "//input[@id='inputEmail']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='inputPassword']")
	WebElement password;
	
	@FindBy(xpath = "//button[@class='btn btn-primary btn-block btn-login']")
	WebElement loginButton;
	
	public loginPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement( userName, DataSource.getExplicitWait());
	}


	public void setUserName(String userName) {
		log.info("entering user Name: " + userName);
		this.userName.sendKeys(userName);
	}

	public void setPassword(String password) {
		log.info("entering password: " + password);
		this.password.sendKeys(password);
	}
	
	public void clickLogin() {
		log.info("clicking login button");
		loginButton.click();
	}
	

	public homePage loginToApplication(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickLogin();
		return new homePage(driver);
	}

	}
