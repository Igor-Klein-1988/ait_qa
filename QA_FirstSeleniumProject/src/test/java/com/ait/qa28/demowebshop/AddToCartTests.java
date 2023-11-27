package com.ait.qa28.demowebshop;

import com.ait.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        app.getUser().loginAsUser(
                new User()
                        .setEmail("igorAalen@gmail.com")
                        .setPassword("Qwerty007!")
        );
    }

    @Test
    public void checkMessageProductAddedPositiveTest() {
        app.getCart().clickOnProductOnStartPage(3);
        app.getCart().clickOnAddToCartInProductPage();

        String message = "The product has been added to your ";
        By locator = By.cssSelector(".content");

        Assert.assertTrue(app.getCart().isMessagePresent(locator, message));
    }

    @Test
    public void checkAddProductInCartPositiveTest() {
        app.getCart().clickOnProductOnStartPage(3);
        app.getCart().clickOnAddToCartInProductPage();
        app.getCart().clickOnShoppingCartLink();

        Assert.assertTrue(app.getCart().isProductTableInCartPresent());
    }
}
