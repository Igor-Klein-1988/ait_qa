package com.ait.qa28.demowebshop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateAccountTests extends TestBase {
    //precondition: user should be logged out
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.xpath("//a[@class='ico-login']"))) {
            driver.findElement(By.xpath("//a[@class='ico-login']")).click();
        }
    }

    @Test
    public void registerExistedUserNegativeTest() {

        //click on Register
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();

        //enter gender
        driver.findElement(By.id("gender-male")).click();

        //enter FirstName
        driver.findElement(By.id("FirstName")).click();
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Igor");

        //enter LastName
        driver.findElement(By.id("LastName")).click();
        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Aalen");

        //enter email
        driver.findElement(By.id("Email")).click();
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys("igorAalen@gmail.com");

        //enter password
        driver.findElement(By.id("Password")).click();
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Qwerty007!");

        //enter ConfirmPassword
        driver.findElement(By.id("ConfirmPassword")).click();
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Qwerty007!");

        //click on Registration button
        driver.findElement(By.id("register-button")).click();
        //assert message
        String messsage = "The specified email already exists";

        WebElement chackedElement = driver.findElement(By.xpath("//li[contains(text(),'" + messsage + "')]"));

        Assert.assertTrue(chackedElement.isDisplayed());
    }
}
