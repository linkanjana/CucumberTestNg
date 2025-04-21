
package com.myproject.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void type(WebElement element, String text) {
        waitForElementToBeVisible(element);
        element.clear();
        element.sendKeys(text);
    }

    public void waitForElementToBeVisible(WebElement element) {
        new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, 10)
            .until(ExpectedConditions.elementToBeClickable(element));
    }
}
    