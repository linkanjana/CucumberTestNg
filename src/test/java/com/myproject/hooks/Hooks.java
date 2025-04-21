package com.myproject.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.myproject.utils.DriverManager;
import com.myproject.utils.ExtentManager;
import com.myproject.utils.ExtentTestManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private DriverManager driverManager;

    ExtentReports report;
    private final ExtentTestManager extentTestManager;

    public Hooks(DriverManager driverManager, ExtentTestManager extentTestManager) {
        report = ExtentManager.getInstance();
        this.driverManager = driverManager;
        this.extentTestManager = extentTestManager;
    }

    @Before
    public void setUp(Scenario scenario) {
        driverManager.initDriver();
        report = ExtentManager.getInstance();
        ExtentTest test = report.createTest(scenario.getName());
        extentTestManager.setTest(test);
    }

    @After
    public void tearDown(Scenario scenario) {
        driverManager.quitDriver();
        if (scenario.isFailed()) {
            extentTestManager.getTest().fail("Scenario Failed: " + scenario.getName());
        } else {
            extentTestManager.getTest().pass("Scenario Passed");
        }
        report.flush();
    }
}
