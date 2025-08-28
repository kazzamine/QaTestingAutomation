package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class TestBase {
    protected WebDriver driver;
    protected String baseUrl="https://www.saucedemo.com/";
    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false); // disables save password prompt
        prefs.put("profile.password_manager_enabled", false); // disables password manager

        options.setExperimentalOption("prefs", prefs);

// Optional arguments to disable infobars and automation prompts
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-infobars");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        driver=new ChromeDriver(options);
        driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
