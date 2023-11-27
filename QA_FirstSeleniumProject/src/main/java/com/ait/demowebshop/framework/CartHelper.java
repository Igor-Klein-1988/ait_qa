package com.ait.demowebshop.framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartHelper extends BaseHelper {
    public CartHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnProductOnStartPage(int numberOfProducts) {
        click(By.xpath("(//input[@value='Add to cart'])[" + numberOfProducts + "]"));
    }

    public void clickOnAddToCartInProductPage() {
        click(By.cssSelector("[id^='add-to-cart-']"));
    }

    public void clickOnShoppingCartLink() {
        click(By.xpath("//span[@class='cart-qty']"));
    }

    public boolean isProductTableInCartPresent() {
        return isElementPresent(By.cssSelector(".cart-item-row"));
    }
}
