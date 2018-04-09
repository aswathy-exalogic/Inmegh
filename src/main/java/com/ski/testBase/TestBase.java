package com.ski.testBase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import com.google.common.io.Files;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.ski.excel.ReadDataFromExcelSheet;
import com.ski.helper.logger.LoggerHelper;
import com.ski.utility.ResourceHelper;

public class TestBase {
	public WebDriver driver;
	 public static ExtentReports extent;
		public static ExtentTest test;
		public ITestResult result;

	public static Logger log = LoggerHelper.getLogger(TestBase.class);
	
	
	static {
		Calendar calender = Calendar.getInstance();
		 SimpleDateFormat formater=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
	 extent = new ExtentReports(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ski\\reports/test" + formater.format(calender.getTime())+".html",false);
	 
	}

	/**
	 * This method will give excel data in 2D array based on sheet Name
	 * 
	 * @param excellocation
	 * @param sheetName
	 * @return
	 */
	public String[][] getExcelData(String excelName, String sheetName) {
		String excellocation=ResourceHelper.getResourcePath("\\src\\main\\resources\\testData/")+ excelName;
		ReadDataFromExcelSheet readDataFromExcelSheet = new ReadDataFromExcelSheet();
		return readDataFromExcelSheet.getExcelData(excellocation, sheetName);
	}
	


	/**
	 * This method will update result in excel sheet.
	 * 
	 * @param excellocation
	 * @param sheetName
	 * @param testCaseName
	 * @param testStatus
	 * @throws IOException
	 */
	public void updateResult(String excellocation, String sheetName, String testCaseName, String testStatus) throws IOException {
		ReadDataFromExcelSheet readDataFromExcelSheet = new ReadDataFromExcelSheet();
		readDataFromExcelSheet.updateResult(excellocation, sheetName, testCaseName, testStatus);
	}

	/**
	 * This method will create browser Objects.
	 * 
	 * @param browser
	 * @return
	 */
	public void getBrowser(String browser) {
		if (System.getProperty("os.name").contains("Window")) {
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\geckodriver.exe");
				this.driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");
				this.driver = new ChromeDriver();
			}
		} else if (System.getProperty("os.name").contains("Mac")) {
			System.out.println(System.getProperty("os.name"));
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/geckodriver");
				this.driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
				this.driver = new ChromeDriver();
			}
		}
	}

	public String getScreenShot(String imageName) throws IOException {
		// in case you don't want to supply screen shot name
		if (imageName.equals("")) {
			imageName = "blank";
		}
		File image = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		String imagelocation = ResourceHelper.getBaseResourcePath() + "\\src\\main\\resources\\screenshot/";

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		String actualImageName = imagelocation + imageName + "_" + formater.format(calendar.getTime()) + ".png";
		
		File destFile = new File(actualImageName);
		
		Files.copy(image, destFile);
		
		return actualImageName;
	}

	/**
	 * This method will help us to get data from properties file
	 * 
	 * @param name
	 * @return
	 */
	public String getData(String name) {
		return DataSource.OR.getProperty(name);
	}
	
	public void getresult(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.SUCCESS) {

			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getName() + " test is failed" + result.getThrowable());
			String screen = getScreenShot("");
			test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}

	@AfterMethod()
	public void afterMethod(ITestResult result) throws IOException {
		getresult(result);
	}

	@BeforeMethod()
	public void beforeMethod(Method result) {
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		//driver.quit();
		extent.endTest(test);
		extent.flush();
	}
		

	@BeforeTest
	public void launchBrowser(){
		getBrowser(getData("browerType"));
		driver.manage().timeouts().implicitlyWait(DataSource.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(DataSource.getPageLoadTime(), TimeUnit.SECONDS);
	}
	
	public void getApplicationURL(String url){
		log.info(url);
		driver.get(url);
		driver.manage().window().maximize();
	}

}