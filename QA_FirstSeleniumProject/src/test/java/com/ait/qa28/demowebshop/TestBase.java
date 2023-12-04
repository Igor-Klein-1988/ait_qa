package com.ait.qa28.demowebshop;

import com.ait.demowebshop.framework.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Arrays;


public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.init();
        System.out.println("Before Suite!");
    }

    @BeforeMethod
    public void startTest(Method method, Object[] p) {
        logger.info("Start test " + method.getName() + " with data: " + Arrays.asList(p));
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("*****Before Test!");
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED: " + result.getMethod().getMethodName());
        }
        logger.info("============================");
    }

    @AfterSuite
    public void tearDown() {
        app.stop();
        System.out.println("After Suite!");
    }
}
