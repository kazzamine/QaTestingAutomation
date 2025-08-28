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

    String loginUrl="https://www.saucedemo.com/";

    @Epic("Authentication")
    @Feature("Login")
    @Story("Valid user login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test successful login with valid credentials")
    @Test
    public void testValidLogin(){
        driver.get(loginUrl);
        LoginPage loginpage=new LoginPage(driver);
        loginpage.loginFeature("standard_user","secret_sauce");
        String currentUrl=driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory"),"login was unsuccessful");
    }

    //    //error-message-container error
    @Epic("authentification")
    @Feature("login")
    @Story("locked out user")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test unsuccessful login with locked out user")
    @Test
    public void lockedUserLogin(){
        String username="locked_out_user";
        String password="secret_sauce";
        driver.get(loginUrl);
        LoginPage loginpage=new LoginPage(driver);
        loginpage.loginFeature(username,password);

        String currentUrl=driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(""),"user is locked out");
        Assert.assertTrue(loginpage.isErrorTextEqual("Epic sadface: Sorry, this user has been locked out."));
    }

    @Epic("authentification")
    @Feature("login")
    @Story("login wrong credentials")
    @Severity(SeverityLevel.TRIVIAL)
    @Description("Test unsuccessful login with non-existing user")
    @Test
    public void wrongCredLogin()
    {
        String username="non-existing";
        String password="secret_sauce";
        driver.get(loginUrl);
        LoginPage loginpage=new LoginPage(driver);
        loginpage.loginFeature(username,password);

        String currentUrl=driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(""),"user is locked out");
        Assert.assertTrue(loginpage.isErrorTextEqual("Epic sadface: Username and password do not match any user in this service"));
    }

}
