package tests;

import base.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.WaitHelper;

public class CheckoutTest extends TestBase {

    @Epic("cart")
    @Feature("checkout cart")
    @Story("checking out cart: success")
    @Severity(SeverityLevel.CRITICAL)
    @Test
    public void checkoutCartTest(){
        driver.get(baseUrl);
        LoginPage loginPage=new LoginPage(driver);
        InventoryPage inventoryPage=new InventoryPage(driver);
        CartPage cartpage=new CartPage(driver);
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        loginPage.loginFeature("standard_user","secret_sauce");
        inventoryPage.addItemToCart("Sauce Labs Backpack");
        inventoryPage.openCart();
        Assert.assertTrue(cartpage.isOnCartPage(),"error not redirected");
//        Assert.assertTrue(cartpage.itemExists());
        cartpage.checkoutCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("/checkout-step-one.html"),"somethig went wrong not redirected");
        checkoutPage.fillUpUserInfo("amine","kazz","111");
        checkoutPage.continueClick();
        checkoutPage.finishCheckout();
        Assert.assertTrue(checkoutPage.confirmCheckout(),"didn't confirm checkout");
    }
    @Epic("cart")
    @Feature("checkout empty cart")
    @Story("checking out cart: fail")
    @Severity(SeverityLevel.TRIVIAL)
    @Test(enabled = false)
    public void checkoutEmptyCartTest(){
        driver.get(baseUrl);
        LoginPage loginPage=new LoginPage(driver);
        InventoryPage inventoryPage=new InventoryPage(driver);
        CartPage cartpage=new CartPage(driver);
        CheckoutPage checkoutPage=new CheckoutPage(driver);
        loginPage.loginFeature("standard_user","secret_sauce");
        inventoryPage.openCart();
        Assert.assertTrue(cartpage.isOnCartPage(),"error not redirected");
//        Assert.assertTrue(cartpage.itemExists());
        cartpage.checkoutCart();
        Assert.assertTrue(driver.getCurrentUrl().contains("/checkout-step-one.html"),"somethig went wrong not redirected");
        checkoutPage.fillUpUserInfo("amine","kazz","111");
        checkoutPage.continueClick();
        checkoutPage.finishCheckout();
        Assert.assertFalse(checkoutPage.confirmCheckout(),"checkout should be only with a full cart");
    }
    @Epic("cart")
    @Feature("remove cart item")
    @Story("remove out cart items")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    public void removeCartItem(){
        driver.get(baseUrl);
        LoginPage loginPage=new LoginPage(driver);
        InventoryPage inventoryPage=new InventoryPage(driver);
        CartPage cartpage=new CartPage(driver);
        loginPage.loginFeature("standard_user","secret_sauce");
        inventoryPage.addItemToCart("Sauce Labs Backpack");
        inventoryPage.openCart();
        Assert.assertTrue(cartpage.isOnCartPage(),"error not redirected");
        cartpage.removeCartItem("Sauce Labs Backpack");

    }
}
