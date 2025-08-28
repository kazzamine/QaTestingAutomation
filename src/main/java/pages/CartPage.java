package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitHelper;

public class CartPage {
    private WebDriver driver;
    private WaitHelper wait;
    public CartPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WaitHelper(driver,50);
    }

    public void checkoutCart(){
        By checkoutBtn=By.id("checkout");
        wait.waitForClickable(checkoutBtn).click();
    }

    public void removeCartItem(String itemName){
        String formattedId=itemName.toLowerCase().replaceAll(" ","-");
        By removeBtn=By.id("remove-"+formattedId);
        wait.waitForClickable(removeBtn).click();
    }
    public boolean isOnCartPage() {
        return driver.getCurrentUrl().contains("/cart.html");
    }
    public boolean itemExists(){
        WebElement cartLits= wait.waitForVisibility(By.id("cart_item"));
        return !cartLits.findElements(By.xpath("./*")).isEmpty();
    }
}
