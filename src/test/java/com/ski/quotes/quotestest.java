package com.ski.quotes;
	import org.testng.SkipException;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.DataProvider;
	import org.testng.annotations.Test;
import com.ski.pageObjects.Home.homePage;
	import com.ski.pageObjects.Login.loginPage;
import com.ski.pageObjects.Quotes.Quotes;
import com.ski.testBase.DataSource;
	import com.ski.testBase.TestBase;
	

	public class quotestest extends TestBase{
				
				static loginPage login;
				homePage home;
				
				@DataProvider(name="testData")
				public Object[][] testData(){
					String[][] data = getExcelData("demo.xlsx", "quotes");
					return data;
				}
				
				@BeforeClass
				public void beforeClass(){
					getApplicationURL(DataSource.OR.getProperty("url"));
					login = new loginPage(driver);
				}
				
				@Test(dataProvider="testData")
				public void createquotes(String userName, String password,String QuotesoftheDay, String runMode){
					if(userName != null) {
						if(runMode.equalsIgnoreCase("n")){
							throw new SkipException("Run mode for this set of data is marked N");
						}
						homePage homePage = login.loginToApplication(userName, password);
						Quotes quotes = home.navigateToQuotes();
						quotes.testcreateQuotes(QuotesoftheDay);
						home.clicklogout();
					}
				}
		}

