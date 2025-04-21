package com.myproject.context;

import com.myproject.utils.ExtentTestManager;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private Pages pages;
    private ExtentTestManager extentTestManager;

    public TestContext(WebDriver driver) {
        this.pages = new Pages(driver);
        this.extentTestManager = new ExtentTestManager();
    }

    public Pages getPages() {
        return pages;
    }

    public ExtentTestManager getExtentTestManager() {
        return extentTestManager;
    }
}

