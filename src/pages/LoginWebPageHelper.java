package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginWebPageHelper extends PageBase {
    @FindBy(id = "signinrequest")
    WebElement signInButton;
    @FindBy(id = "logininput")
    WebElement loginField;
    @FindBy(id = "passwordinput")
    WebElement passwordField;
    @FindBy(id = "wrongloginorpassword")
    WebElement wrongMessage;
    @FindBy(id = "closedsignin")
    WebElement closeLogin;



    public LoginWebPageHelper(WebDriver driver) {
        super(driver);
    }

    public LoginWebPageHelper waitUntilPageIsLoaded(){

        waitUntilElementClickable(signInButton,10);
        return this;
    }


    public LoginWebPageHelper enterLoginPassword(String login, String password) {
        waitUntilElementClickable(signInButton,10);
        enterTextToField(loginField,login);
        enterTextToField(passwordField,password);
        clickButton(signInButton);
        return this;
    }

    public boolean wrongTextIsDisplayed() {
        waitUntilElementIsVisible(wrongMessage,10);
        return wrongMessage.getText().contains("Wrong Authorization!");
    }

    public LoginWebPageHelper closeLoginWindow() {
        clickButton(closeLogin);
        return this;
    }

    public LoginWebPageHelper cancelModalWindowIfNoWrongMessage() {
        if(!wrongMessage.isDisplayed())
            cancelSignInModalWindow();
        return this;
    }
}
