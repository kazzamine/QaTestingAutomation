package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class LoginPage {
    private WebDriver driver;
    private WaitHelper wait;
    private By username=By.id("user-name");
    private By password=By.id("password");
    private By loginbtn=By.id("login-button");

    public LoginPage(WebDriver driver){
       this.driver=driver;
       this.wait=new WaitHelper(driver,5);
    }

    public void enterUsername(String usernameText){
        WebElement usernameFound= wait.waitForVisibility(username);
        usernameFound.sendKeys(usernameText);
    }
    public void enterPassword(String passwordText){
        driver.findElement(password).sendKeys(passwordText);
    }

    public void clickLogin(){
        WebElement clickLogin=wait.waitForClickable(loginbtn);
        clickLogin.click();
    }

    public void loginFeature(String usernameText,String passwordText) {
        WaitHelper.pause(2);
        enterUsername(usernameText);
        enterPassword(passwordText);
        WaitHelper.pause(2);
        clickLogin();
    }
}
