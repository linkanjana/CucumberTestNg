package com.myproject.utils;



import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {
    private ExtentTest extentTest;

    public void setTest(ExtentTest test) {
        this.extentTest = test;
    }

    public ExtentTest getTest() {
        return this.extentTest;
    }

}
