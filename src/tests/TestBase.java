package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;


public class TestBase {
    public static final String LOGIN = "marinaA";
    public static final String PASSWORD = "marina1!";

    public WebDriver driver;

    @BeforeMethod
    public void startApplication() throws InterruptedException, MalformedURLException {
        driver = new ChromeDriver();
        driver.get("https://mishpahug.co.il/");
        driver.findElement(By.id("closedIntro")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public void waitUntilElementIsVisible(By locator, int time){
        try {
            new WebDriverWait(driver,time)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void waitUntilElemContainsText(By locator, String value, int time){
        try {
            new WebDriverWait(driver,time)
                    .until(ExpectedConditions.textToBePresentInElementLocated(locator,value));
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
