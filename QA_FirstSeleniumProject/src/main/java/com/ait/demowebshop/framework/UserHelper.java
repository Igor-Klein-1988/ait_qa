package com.ait.demowebshop.framework;

import com.ait.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void ensureUserIsLoggedOut() {
        if (!isRegisterLinkPresent()) {
            clickOnLogOutLink();
        }
    }

    public void loginAsUser(User user) {
        ensureUserIsLoggedOut();

        clickOnLogInLink();
        fillLoginForm(user);
        clickOnLogInSubmitInput();
    }

    public void clickOnLogOutLink() {
        click(By.xpath("//a[@class='ico-logout']"));
    }

    public boolean isRegisterLinkPresent() {
        return isElementPresent(By.xpath("//a[@class='ico-register']"));
    }

    public boolean isLogInLinkPresent() {
        return isElementPresent(By.xpath("//a[@class='ico-login']"));
    }

    public void clickOnRegistrationLink() {
        click(By.xpath("//a[@class='ico-register']"));
    }

    public void fillLoginRegisterForm(User user) {
        click(By.id("gender-" + user.getGender()));
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnLogInLink() {
        click(By.xpath("//a[@class='ico-login']"));
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.xpath("//a[@class='ico-logout']"));
    }

    public void clickOnLogInSubmitInput() {
        click(By.xpath("//input[@value='Log in']"));
    }

    public void clickOnRegistrationSubmitInput() {
        click(By.id("register-button"));
    }
}
