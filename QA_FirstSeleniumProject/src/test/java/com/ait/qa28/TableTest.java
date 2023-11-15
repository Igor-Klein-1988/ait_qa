package com.ait.qa28;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TableTest {
    WebDriver driver;

    // before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/css/css_table.asp");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void tableCssTests(){
        System.out.println("==== *** ==== #customers tr:nth-child(8) td:last-child\" ==== *** ====");
        WebElement canada = driver.findElement(By.cssSelector("#customers tr:nth-child(8) td:last-child"));
        System.out.println(canada.getText());

        System.out.println("==== *** ==== rows.size() ==== *** ====");
        List<WebElement> rows = driver.findElements(By.cssSelector("tr"));
        System.out.println(rows.size());
        System.out.println("==== *** ==== rows: ==== *** ====");
        rows.forEach(e -> System.out.println(e.getText()));
    }

    @Test
    public void xpathParentTests(){

        // parent
        System.out.println("==== *** ==== h1Par ==== *** ====");
        WebElement h1Par = driver.findElement(By.xpath("//h1/parent::*"));
        System.out.println(h1Par.getText());

        // parent + div
        System.out.println("==== *** ==== h1Par ==== *** ====");
        WebElement h1ParDiv = driver.findElement(By.xpath("//h1/parent::div"));
        System.out.println(h1ParDiv.getText());

    }

    // after tearDown
    @AfterMethod()
    public void tearDown() {
        driver.quit(); // all tabs & close browser
    }
}
