package com.ski.institution;


import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ski.pageObjects.Home.homePage;
import com.ski.pageObjects.Institution.institutionPage;
import com.ski.pageObjects.Login.loginPage;
import com.ski.testBase.DataSource;
import com.ski.testBase.TestBase;


public class institutiontest extends TestBase {
	static loginPage login;
	homePage home;

	@DataProvider(name = "testData")
	public Object[][] testData() {
		String[][] data = getExcelData("demo.xlsx", "branch");
		return data;
	}

	@BeforeClass
	public void beforeClass() {
		getApplicationURL(DataSource.OR.getProperty("url"));
		login = new loginPage(driver);
	}

	@Test(dataProvider="testData")
	
	public void testinstitution(String userName,String password,String branch_name, String branch_code, String branch_address_line_1, String branch_address_line_2, String branch_country, String branch_state, String branch_city, String branch_pincode, String branch_email,
			String branch_website, String branch_student_login_prefix, String branch_employee_login_prefix, String branch_phone, String branch_fax, String runMode) {
		if(userName != null) {
			if(runMode.equalsIgnoreCase("n")){
				throw new SkipException("Run mode for this set of data is marked N");
			}
			home = login.loginToApplication(userName, password);
			institutionPage inst = home.navigateToinstitutionPage();
			inst.createInstitution(userName, password, branch_name, branch_code, branch_address_line_1, branch_address_line_2, branch_country, branch_state, branch_city, branch_pincode, branch_email, branch_website, branch_student_login_prefix, branch_employee_login_prefix, branch_phone, branch_fax, runMode);
			home.clicklogout();
		}
	}
}
