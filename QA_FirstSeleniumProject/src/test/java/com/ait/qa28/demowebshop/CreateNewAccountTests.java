package com.ait.qa28.demowebshop;

import com.ait.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CreateNewAccountTests extends TestBase {

    public static final int FIRST_NAME_INDEX = 0;
    public static final int LAST_NAME_INDEX = 1;
    public static final int GENDER_INDEX = 2;
    public static final int EMAIL_INDEX = 3;
    public static final int PASSWORD_INDEX = 4;

    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        app.getUser().ensureUserIsLoggedOut();
    }

    @DataProvider
    public Iterator<Object[]> registerExistedUserFromSCV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/users.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                    new User()
                            .setFirstName(split[FIRST_NAME_INDEX])
                            .setLastName(split[LAST_NAME_INDEX])
                            .setGender(split[GENDER_INDEX])
                            .setEmail(split[EMAIL_INDEX])
                            .setPassword(split[PASSWORD_INDEX])
            });
            line = reader.readLine();
        }

        return list.iterator();
    }

    @Test(dataProvider = "registerExistedUserFromSCV")
    public void registerExistedUserFromSCVProviderNegativeTest(User user) {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillLoginRegisterForm(user);
        app.getUser().clickOnRegistrationSubmitInput();

        String message = "The specified email already exists";
        By locator = By.xpath("//li[contains(text(),'" + message + "')]");

        Assert.assertTrue(app.getUser().isMessagePresent(locator, message));
    }
}
