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


public class DemoWebShopTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @Test
    public void cssSelectorTests(){
        System.out.println("==== *** ==== h2List.size() ==== *** ====");
        // tag -> tag
        List<WebElement> h2List  = driver.findElements(By.cssSelector("h2"));
        System.out.println(h2List.size());

        System.out.println("==== *** ==== dialogNotificationsError.getAttribute(\"title\") ==== *** ====");
        // id -> #id
        WebElement dialogNotificationsError = driver.findElement(By.cssSelector("#dialog-notifications-error"));
        System.out.println(dialogNotificationsError.getAttribute("title"));

        System.out.println("==== *** ==== icoRegister.getText() ==== *** ====");
        //className -> .className
        WebElement icoRegister = driver.findElement(By.cssSelector(".ico-register"));
        System.out.println(icoRegister.getText());

        System.out.println("==== *** ==== inputElement.getAttribute(\"value\") ==== *** ====");
        // name -> [attribute='value']
        WebElement inputElement = driver.findElement(By.cssSelector("[autocomplete='off']"));
        System.out.println(inputElement.getAttribute("value"));

        System.out.println("==== *** ==== contains ==== *** ====");
        // contains -> *
        WebElement elByContains = driver.findElement(By.cssSelector("[href*='jewelry']"));
        System.out.println(elByContains.getText());



        System.out.println("==== *** ==== start ==== *** ====");
        // start -> ^
        WebElement elByStart = driver.findElement(By.cssSelector("[class^='footer-dis']"));
        System.out.println(elByStart.getText());

        System.out.println("==== *** ==== elByEnd ==== *** ====");
        // end to -> $
        WebElement elByEnd = driver.findElement(By.cssSelector("[for$='ers-3']"));
        System.out.println(elByEnd.getText());
    }

    @Test
    public void xpathTests(){
        // xpath --> //*[@attribute='value']
        System.out.println("==== *** ==== h2List.size() ==== *** ====");
        // tag -> //tag
        List<WebElement> h2List  = driver.findElements(By.xpath("//h2"));
        System.out.println(h2List.size());

        System.out.println("==== *** ==== dialogNotificationsError.getAttribute(\"title\") ==== *** ====");
        // id -> //*[@id='value'] //div[@id='dialog-notifications-error']
        WebElement rootElement = driver.findElement(By.xpath("//div[@id='dialog-notifications-error']"));
        System.out.println(rootElement.getAttribute("title"));

        System.out.println("==== *** ==== className ==== *** ====");
        //className -> //*[@class='value']
        WebElement elByClassName = driver.findElement(By.xpath("//a[@class='ico-register']"));
        System.out.println(elByClassName.getText());

        System.out.println("==== *** ==== inputElement.getAttribute(\"value\") ==== *** ====");
        WebElement inputElement = driver.findElement(By.xpath("//*[@autocomplete='off']"));
        System.out.println(inputElement.getAttribute("value"));

        System.out.println("==== *** ==== contains ==== *** ====");
        // contains -> //*[contains(.,'Text')]
        WebElement elByContains = driver.findElement(By.xpath("//a[contains(@href,'jewelry')]"));
        System.out.println(elByContains.getAttribute("name"));

        System.out.println("==== *** ==== start ==== *** ====");
        // start -> //*[starts-with(@attribute,'Text')]
        WebElement elByStart = driver.findElement(By.xpath("//div[starts-with(@class,'footer-dis')]"));
        System.out.println(elByStart.getAttribute("name"));
    }

    @Test
    // find Elements by tag
    public void findElementTagTest() {
        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        System.out.println(h2List.size());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
