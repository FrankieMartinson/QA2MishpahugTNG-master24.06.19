package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomeWebPageAuthHelper extends PageBase {
    @FindBy(id = "profile")
    WebElement profileIcon;

    public HomeWebPageAuthHelper(WebDriver driver) {
        super(driver);
    }

    public HomeWebPageAuthHelper waitUntilPageIsLoaded(){
        waitUntilElementClickable(profileIcon, 20);
        return this;
    }


    public boolean profileIconTitleContainsText(String login) {
        return profileIcon.getAttribute("title").contains(login);
    }
}
