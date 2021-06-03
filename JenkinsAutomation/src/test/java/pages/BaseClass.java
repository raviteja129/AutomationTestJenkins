package pages;

import Utilities.BrowserUtilities.BrowserDataFactory;
import Utilities.ConfigUtlities.ConfigDataFactory;
import Utilities.ExcelUtilities.ExcelDataFactory;
import Utilities.HelperUtility.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public WebDriver driver;
    public ConfigDataFactory configDataFactory;
    public ExcelDataFactory excelDataFactory;
    public BrowserDataFactory browserDataFactory;
    public ExtentTest extentTest;
    public ExtentReports report;
    public ExtentHtmlReporter reporter;

    @BeforeSuite
    public void setUpSuite() throws IOException {
        excelDataFactory = new ExcelDataFactory();
        configDataFactory = new ConfigDataFactory();
        File reportDirPath = new File(System.getProperty("user.dir") + "/target/reports");
        if (!reportDirPath.exists()) {
            reportDirPath.mkdir();
            reporter = new ExtentHtmlReporter(new File(reportDirPath+ "/FreeLogin" + Helper.getDateTimeStamp() +".html"));
            reporter.config().setDocumentTitle("Orange HRM Automation Report");
            reporter.config().setReportName("Functional Report");
            reporter.config().setTheme(Theme.DARK);
        }
        else{
            reporter = new ExtentHtmlReporter(new File(reportDirPath+ "/FreeLogin" + Helper.getDateTimeStamp() +".html"));
            reporter.config().setDocumentTitle("Orange HRM Automation Report");
            reporter.config().setReportName("Functional Report");
            reporter.config().setTheme(Theme.DARK);
        }

        report = new ExtentReports();
        report.attachReporter(reporter);
        report.setSystemInfo("AppURL", "https://opensource-demo.orangehrmlive.com");
        report.setSystemInfo("OS", "Windows");
        report.setSystemInfo("ExecutedBy", excelDataFactory.getStringData("LoginPage" ,1,0));
        report.setSystemInfo("Browser", "Mozilla Firefox");
    }

    @BeforeClass
    public void setUp() {
        driver = browserDataFactory.startApplication(configDataFactory.getBrowserConfig(), configDataFactory.getURLConfig());
    }

    @AfterClass
    public void closeAll() {
        browserDataFactory.closeBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenShot(driver);
            extentTest.log(Status.FAIL, "Testcase failed is " + result.getName());
            extentTest.log(Status.FAIL, "Testcase failed is " + result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SKIP) {
            Helper.captureScreenShot(driver);
            extentTest.log(Status.SKIP, "Testcase skipped is " + result.getName());
            extentTest.log(Status.SKIP, "Testcase skipped is " + result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS){
            Helper.captureScreenShot(driver);
            extentTest.log(Status.PASS,"Testcase passed is " + result.getName());
        }
        report.flush();
    }
}
