package com.ait.qa28.demowebshop;

import com.ait.demowebshop.framework.ApplicationManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager();

    @BeforeMethod
    public void setUp() {
        app.init();
    }

    @AfterMethod()
    public void tearDown() {
        app.stop();
    }
}
