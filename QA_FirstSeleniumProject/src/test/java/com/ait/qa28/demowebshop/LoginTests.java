package com.ait.qa28.demowebshop;

import com.ait.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        app.getUser().loginAsUser(
                new User()
                        .setEmail("igorAalen@gmail.com")
                        .setPassword("Qwerty007!")
        );
    }

    @Test
    public void loginRegisteredUserPositiveTest() {
        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }
}
