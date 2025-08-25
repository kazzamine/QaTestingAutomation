package tests;

import base.TestBase;
import io.qameta.allure.*;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.LoginPage;

@Listeners({AllureTestNg.class})
public class LoginTest extends TestBase {

    @Epic("Authentication")
    @Feature("Login")
    @Story("Valid user login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test successful login with valid credentials")
    @Test
    public void testValidLogin(){
        driver.get("https://www.saucedemo.com/");
        LoginPage loginpage=new LoginPage(driver);
        loginpage.loginFeature("standard_user","secret_sauce");
        String currentUrl=driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"),"login was unsuccessful");
    }
}
