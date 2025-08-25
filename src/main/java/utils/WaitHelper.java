package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHelper {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public WaitHelper(WebDriver driver,Integer seconds){
        this.driver=driver;
        this.driverWait=new WebDriverWait(driver, Duration.ofSeconds(seconds));
    }

    public WebElement waitForVisibility(By locator){
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(By locator){
        return driverWait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public Boolean waitForUrlContains(String partialUrl){
        return driverWait.until(ExpectedConditions.urlContains(partialUrl));
    }


    public Boolean waitForTextPresent(String partialText,By locator){
        return driverWait.until(ExpectedConditions.textToBePresentInElementLocated(locator,partialText));
    }

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
