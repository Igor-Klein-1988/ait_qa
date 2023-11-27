package com.ait.demowebshop.framework;

import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Getter
public class ApplicationManager {

    @Getter(AccessLevel.NONE)
    WebDriver driver;

    UserHelper user;

    HomePageHelper homePage;

    CartHelper cart;

    public void init() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        homePage = new HomePageHelper(driver);
        cart = new CartHelper(driver);

    }

    public void stop() {
        driver.quit();
    }
}
