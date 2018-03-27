package com.ski.pageObjects.Home;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ski.helper.logger.LoggerHelper;
import com.ski.helper.waitHelper.WaitHelper;
import com.ski.pageObjects.Login.loginPage;
import com.ski.testBase.DataSource;

public class homePage {
	private WebDriver driver;
	private WaitHelper waitHelper;

	private static Logger log = LoggerHelper.getLogger(loginPage.class);
	
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	WebElement  Dashboard;
	
	@FindBy(xpath="//span[@class='entypo-logout right']")
	WebElement logout;
	
	
	public homePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement( Dashboard, DataSource.getExplicitWait());
	}
	
	public loginPage clicklogout() {
		log.info("clicking login button");
		logout.click();

		return new loginPage(driver);
	
}}


