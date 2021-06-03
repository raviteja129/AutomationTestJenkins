package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseClass {
    @Test
    public void LoginApp() {
        extentTest = report.createTest("Automation Practice - Home Page");
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        extentTest.info("Starting Application");
        loginPage.loginToApplication(excelDataFactory.getStringData("LoginPage" ,1,0), excelDataFactory.getStringData("LoginPage" ,1,1));
        extentTest.pass("Login Success");

        /*extentTest = report.createTest("Automation Practice - HomePage");
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        extentTest.info("Validating HomePage");
        homePage.homePageValidation();
        extentTest.pass("Validating username in HomePage");*/

        /*extentTest = report.createTest("Orange HRM - Add Users");
        AddUsersPage addUsersPage = PageFactory.initElements(driver, AddUsersPage.class);
        extentTest.info("Loaded Add users page");
        addUsersPage.addUsers(excelDataFactory.getStringData("AddUsers", 1,0), excelDataFactory.getStringData("AddUsers", 1,1), excelDataFactory.getStringData("AddUsers", 1,2), excelDataFactory.getStringData("AddUsers", 1,3));
        extentTest.pass("Users added successfully");*/
    }
}
