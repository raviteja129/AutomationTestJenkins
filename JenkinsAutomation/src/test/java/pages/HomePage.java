package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver ldriver) {
        this.driver = ldriver;
    }
    @FindBy(how = How.ID, using = "//*[@id='account']/a]")
    WebElement userNameValidation;

    public void homePageValidation() {
        String actualTitle = userNameValidation.getText();
        String extectedTitle = "Account";
        Assert.assertEquals(actualTitle, extectedTitle);
    }
}
