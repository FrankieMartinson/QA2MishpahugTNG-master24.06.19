package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomeWebPageAuthHelper;
import pages.HomeWebPageHelper;
import pages.LoginWebPageHelper;

public class LoginPageWebTests extends TestBase {
    private HomeWebPageHelper homeWeb;
    private LoginWebPageHelper loginWeb;
    private HomeWebPageAuthHelper homeWebAuth;

    @BeforeMethod
    public void initPage(){
        homeWeb = PageFactory.initElements(driver,HomeWebPageHelper.class);
        loginWeb = PageFactory.initElements(driver, LoginWebPageHelper.class);
        homeWebAuth = PageFactory.initElements(driver, HomeWebPageAuthHelper.class);

        homeWeb.waitUntilPageIsLoaded();
    }

    @Test
    public void loginPositive()  {
        homeWeb.openLoginPage();
        loginWeb.waitUntilPageIsLoaded()
                .enterLoginPassword(LOGIN,PASSWORD);
        homeWebAuth.waitUntilPageIsLoaded();
        Assert.assertTrue(homeWebAuth.profileIconTitleContainsText(LOGIN));
    }

    @Test
    public void loginNegative() throws InterruptedException {
        homeWeb.openLoginPage();
        loginWeb.waitUntilPageIsLoaded()
                .enterLoginPassword(LOGIN,PASSWORD +"123")
                .cancelModalWindowIfNoWrongMessage();

        int counter=0;
        if(loginWeb.wrongTextIsDisplayed())counter++;

        loginWeb.closeLoginWindow();
        homeWeb.waitUntilPageIsLoaded();
        if (homeWeb.homeIconIsDisplayed()) counter++;
        if(homeWeb.loginIconIsDisplayed()) counter++;
        if(homeWeb.registrationIconIsDisplayed())counter++;
        if(homeWeb.homeAuthIconIsHidden()) counter++;
        if(homeWeb.profileIconIsHidden()) counter++;
        Assert.assertEquals(counter,6);

    }
}
