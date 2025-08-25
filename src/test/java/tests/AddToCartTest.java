package tests;

import base.TestBase;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;
import utils.WaitHelper;

@Listeners({AllureTestNg.class})
public class AddToCartTest extends TestBase {

    @Test
    public void testAddItemToCart() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        LoginPage loginpage=new LoginPage(driver);
        loginpage.loginFeature("standard_user","secret_sauce");
        WaitHelper.pause(2);
        InventoryPage inventorypage=new InventoryPage(driver);
        inventorypage.addItemToCart("Sauce Labs Backpack");
        Assert.assertTrue(inventorypage.isCartBadgeVisible(),"no item is added to cart");
        WaitHelper.pause(2);
         inventorypage.openCart();
         WaitHelper.pause(5);
         Assert.assertTrue(inventorypage.isOnCartPage(),"error while opening page");

    }


}
