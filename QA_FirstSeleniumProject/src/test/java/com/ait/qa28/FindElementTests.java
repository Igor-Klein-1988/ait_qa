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

public class FindElementTests {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/login"); // without history
        // maximaze browser to window
        driver.manage().window().maximize();
        // wait for all elements on the page to load before starting the test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementTagTest() {
        // find ElemenT by tag
        WebElement elementH1 = driver.findElement(By.tagName("h1"));
        System.out.println(elementH1.getText());

        WebElement elementA = driver.findElement(By.tagName("a"));
        System.out.println(elementA.getText());

        // find ElementS by tag
        List<WebElement> elementList = driver.findElements(By.tagName("a"));
        System.out.println(elementList.size());
    }

    @Test
    public void findElementTest() {
        // id
        WebElement rootElement = driver.findElement(By.id("root"));
        System.out.println(rootElement.getText());
        System.out.println("==== *** ==== //// ==== *** ====");

        //className
        WebElement elByClassName = driver.findElement(By.className("login_login__3EHKB"));
        System.out.println(elByClassName.getText());
        System.out.println("==== *** ==== //// ==== *** ====");

        // name
        WebElement elByName = driver.findElement(By.name("email"));
        System.out.println(elByName.getAttribute("name"));
        System.out.println("==== *** ==== //// ==== *** ====");

        // linkText
        driver.findElement(By.linkText("LOGIN"));

        // partialLinkText
       driver.findElement(By.partialLinkText("LOG"));

    }

    @Test
    public void findElementByCssTest() {
        System.out.println("==== *** ==== By.cssSelector(\"h1\") ==== *** ====");
        // tag -> tag
        WebElement elementH1 = driver.findElement(By.cssSelector("h1"));
        System.out.println(elementH1.getText());

        System.out.println("==== *** ==== By.cssSelector(\"#root\") ==== *** ====");
        // id -> #id
        WebElement rootElement = driver.findElement(By.cssSelector("#root"));
        System.out.println(rootElement.getText());

        System.out.println("==== *** ==== By.cssSelector(\".login_login__3EHKB\")) ==== *** ====");
        //className -> .className
        WebElement elByClassName = driver.findElement(By.cssSelector(".login_login__3EHKB"));
        System.out.println(elByClassName.getText());

        System.out.println("==== *** ==== By.cssSelector(\"[name='email']\") ==== *** ====");
        // name -> [attribute='value']
        WebElement elByName = driver.findElement(By.cssSelector("[name='email']"));
        System.out.println(elByName.getAttribute("name"));

        System.out.println("==== *** ==== contains ==== *** ====");
        // contains -> *
        WebElement elByContains = driver.findElement(By.cssSelector("[placeholder*='ssw']"));
        System.out.println(elByContains.getAttribute("name"));

        System.out.println("==== *** ==== start ==== *** ====");
        // start -> ^
        WebElement elByStart = driver.findElement(By.cssSelector("[placeholder^='Pas']"));
        System.out.println(elByStart.getAttribute("name"));

        System.out.println("==== *** ==== elByEnd ==== *** ====");
        // end to -> $
        WebElement elByEnd = driver.findElement(By.cssSelector("[placeholder$='word']"));
        System.out.println(elByEnd.getAttribute("name"));
    }

    @Test
    public void findElementByXpath(){
        // xpath --> //*[@attribute='value']
        System.out.println("==== *** ==== By.xpath(\"//h1\") ==== *** ====");
        // tag -> //tag
        WebElement elementH1 = driver.findElement(By.xpath("//h1"));
        System.out.println(elementH1.getText());

        System.out.println("==== *** ==== By.xpath(\"//div[@id='root']\") ==== *** ====");
        // id -> //*[@id='value']
        WebElement rootElement = driver.findElement(By.xpath("//div[@id='root']"));
        System.out.println(rootElement.getText());

        System.out.println("==== *** ==== By.xpath(\"//div[@class='login_login__3EHKB']\") ==== *** ====");
        //className -> //*[@class='value']
        WebElement elByClassName = driver.findElement(By.xpath("//div[@class='login_login__3EHKB']"));
        System.out.println(elByClassName.getText());

        System.out.println("==== *** ==== contains ==== *** ====");
        // contains -> //*[contains(.,'Text')]
        WebElement elByContains = driver.findElement(By.xpath("//button[contains(.,'Registration')]"));
        System.out.println(elByContains.getAttribute("name"));

        System.out.println("==== *** ==== start ==== *** ====");
        // start -> //*[starts-with(@attribute,'Text')]
        WebElement elByStart = driver.findElement(By.xpath("//button[starts-with(@name,'reg')]"));
        System.out.println(elByStart.getAttribute("name"));
    }

    @Test
    public void xpathParentTests(){

        // parent
        System.out.println("==== *** ==== h1Par ==== *** ====");
        WebElement h1Par = driver.findElement(By.xpath("//h1/parent::*"));
        System.out.println(h1Par.getText());

        // parent + div
        System.out.println("==== *** ==== h1ParDiv ==== *** ====");
        WebElement h1ParDiv = driver.findElement(By.xpath("//h1/parent::div"));
        System.out.println(h1ParDiv.getText());

        // ..
        System.out.println("==== *** ==== h1Par.. ==== *** ====");
        WebElement h1Par2 = driver.findElement(By.xpath("//h1/.."));
        System.out.println(h1Par2.getText());

        // ancestor
        System.out.println("==== *** ==== Ancestor ==== *** ====");
        WebElement h1Ancestor = driver.findElement(By.xpath("//h1/ancestor::*"));
        System.out.println(h1Ancestor.getText());

        // following-sibling
        System.out.println("==== *** ==== following-sibling ==== *** ====");
        WebElement followingSibling = driver.findElement(By.xpath("//h1/following-sibling::*"));
        System.out.println(followingSibling.getText());

        // following-sibling1
        System.out.println("==== *** ==== following-sibling1 ==== *** ====");
        WebElement followingSibling1 = driver.findElement(By.xpath("//h1/following-sibling::a[3]"));
        System.out.println(followingSibling1.getText());


    }

    // after tearDown
    @AfterMethod()
    public void tearDown() {
        driver.quit(); // all tabs & close browser
    }
}
