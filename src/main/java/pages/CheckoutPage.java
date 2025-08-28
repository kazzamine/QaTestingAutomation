package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class CheckoutPage {

    private WebDriver driver;
    private WaitHelper wait;
    private By firstnameField=By.id("first-name");
    private By lastnameField=By.id("last-name");
    private By zipCodeField=By.id("postal-code");
    private By continueBtn=By.id("continue");
    private By finishCheckoutBtn=By.id("finish");
    private By successText=By.className("complete-text");

    public CheckoutPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WaitHelper(driver,5);
    }

    public void fillUpUserInfo(String username,String lastname,String zipCode){
        wait.waitForVisibility(firstnameField).sendKeys(username);
        wait.waitForVisibility(lastnameField).sendKeys(lastname);
        wait.waitForVisibility(zipCodeField).sendKeys(zipCode);
    }

    public void continueClick(){
        wait.waitForClickable(continueBtn).click();
    }

    public void finishCheckout(){
        wait.waitForClickable(finishCheckoutBtn).click();
    }

    public boolean confirmCheckout(){
        WebElement completeText=wait.waitForVisibility(successText);
        String textFinish=completeText.getText().trim();
        return textFinish.contains("Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
}
