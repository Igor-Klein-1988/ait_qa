package com.ait.qa28.demowebshop;

import com.ait.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateNewAccountTests extends TestBase {
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        app.getUser().ensureUserIsLoggedOut();
    }


    @Test
    public void registerExistedUserNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillLoginRegisterForm(
                new User()
                        .setFirstName("Igor")
                        .setLastName("Aalen")
                        .setGender("male")
                        .setEmail("igorAalen@gmail.com")
                        .setPassword("Qwerty007!")

        );
        app.getUser().clickOnRegistrationSubmitInput();

        String message = "The specified email already exists";
        By locator = By.xpath("//li[contains(text(),'" + message + "')]");

        Assert.assertTrue(app.getUser().isMessagePresent(locator, message));
    }
}
