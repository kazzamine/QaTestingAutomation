package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitHelper;

public class InventoryPage {
    private WebDriver driver;
    private WaitHelper wait;
    public InventoryPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WaitHelper(driver,50);
    }

    public void addItemToCart(String itemname){
        String formattedId=itemname.toLowerCase().replaceAll(" ","-");
        By addToCartButton = By.id("add-to-cart-" + formattedId);
//        driver.findElement(addToCartButton).click();
        wait.waitForClickable(addToCartButton).click();
    }

    //shopping_cart_link
    public void openCart(){
        By cartBtn=By.className("shopping_cart_link");
        wait.waitForClickable(cartBtn).click();
    }

    public boolean isCartBadgeVisible(){
        WebElement shoppingBadge=wait.waitForVisibility(By.className("shopping_cart_badge"));
        return shoppingBadge.isDisplayed();
    }
}
