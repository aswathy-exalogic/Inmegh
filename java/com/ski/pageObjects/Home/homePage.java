package com.ski.pageObjects.Home;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ski.GenericHelper.GenericHelper;
import com.ski.helper.logger.LoggerHelper;
import com.ski.helper.waitHelper.WaitHelper;
import com.ski.pageObjects.Institution.institutionPage;
import com.ski.pageObjects.Login.loginPage;
import com.ski.pageObjects.Quotes.Quotes;
import com.ski.testBase.DataSource;

public class homePage {
	private WebDriver driver;
	private WaitHelper waitHelper;

	private static Logger log = LoggerHelper.getLogger(loginPage.class);
	
	@FindBy(xpath="//span[contains(text(),'Dashboard')]")
	static
	WebElement Dashboard;
	
	@FindBy(xpath="//span[@class='entypo-logout right']")
	WebElement logout;
	
	@FindBy(xpath = "//span[contains(text(),'Setup')]")
	WebElement Setup;
	
	  @FindBy(xpath="//span[contains(text(),'Quote Of The Day']")
	  WebElement QuotesoftheDay;
	
	@FindBy(xpath = "//span[contains(text(),'College')]")
	WebElement College;
	
	@FindBy(xpath = "//span[contains(text(),'Institutions')]")
	WebElement Institutions;
	
	public homePage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
		waitHelper.waitForElement( Dashboard, DataSource.getExplicitWait());
	}
	/*public static boolean verifySuccessLoginMsg() {
	 return new GenericHelper().isDisplayed(Dashboard);
	}*/
	
	public loginPage clicklogout() {
		log.info("clicking login button");
		logout.click();
		return new loginPage(driver);
	}

	public institutionPage navigateToinstitutionPage() {
		log.info("navigating to institution");
		Setup.click();
		College.click();
		Institutions.click();
		return new institutionPage(driver);
	}
	
	
	public Quotes navigateToQuotes() {
		log.info("navigating to QuotesoftheDay");
		 QuotesoftheDay.click();
		return new Quotes(driver);
	}
	}


