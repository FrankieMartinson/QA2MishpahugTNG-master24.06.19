package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeWebPageHelper extends PageBase {
    @FindBy(id = "idadduser")
    WebElement registrationIcon;

    @FindBy(id = "idsignin")
    WebElement signInButton;

    @FindBy(className = "navi-item")
    List<WebElement> iconLists;

    @FindBy(id = "ihome")
    WebElement homeAuthIcon;

    @FindBy(id = "profile")
    WebElement profileIcon;

    public HomeWebPageHelper(WebDriver driver) {
        super(driver);
    }

    public HomeWebPageHelper waitUntilPageIsLoaded(){
        waitUntilElementClickable(iconLists.get(2),30);
        return this;
    }

    public HomeWebPageHelper openLoginPage() {
        signInButton.click();
        return  this;
    }

    public boolean homeIconIsDisplayed() {
        return iconLists.get(0).isDisplayed();
    }

    public boolean loginIconIsDisplayed() {
        return iconLists.get(1).isDisplayed();
    }

    public boolean registrationIconIsDisplayed() {
        return iconLists.get(2).isDisplayed();
    }

    public boolean homeAuthIconIsHidden() {
        return !homeAuthIcon.isDisplayed();
    }

    public boolean profileIconIsHidden() {
        return !profileIcon.isDisplayed();
    }


}
