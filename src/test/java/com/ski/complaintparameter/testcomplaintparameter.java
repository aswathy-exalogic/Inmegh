package com.ski.complaintparameter;

import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ski.pageObjects.Home.homePage;
import com.ski.pageObjects.Institution.institutionPage;
import com.ski.pageObjects.Login.loginPage;
import com.ski.testBase.DataSource;
import com.ski.testBase.TestBase;

public class testcomplaintparameter extends TestBase {
		static loginPage login;
		homePage home;

		@DataProvider(name = "testData")
		public Object[][] testData() {
			String[][] data = getExcelData("demo.xlsx", "complaintparameter");
			return data;
		}

		@BeforeClass
		public void beforeClass() {
			getApplicationURL(DataSource.OR.getProperty("url"));
			login = new loginPage(driver);
		}

		@Test(dataProvider="testData")
		
		public void testinstitution(String userName,String password,String parameter,String runMode) {
			if(userName != null) {
				if(runMode.equalsIgnoreCase("n")){
					throw new SkipException("Run mode for this set of data is marked N");
				}
				home = login.loginToApplication(userName, password);
				institutionPage inst = home.navigateToinstitutionPage();
			//	inst. createComplaintParameter(userName, password, parameter,runMode);
				home.clicklogout();
			}
		}
		}

