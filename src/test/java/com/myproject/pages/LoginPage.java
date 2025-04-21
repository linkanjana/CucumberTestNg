
package com.myproject.pages;

import com.myproject.base.BasePage;
import com.myproject.pageElems.LoginPageElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    LoginPageElements loginPageElements;
    public LoginPage(WebDriver driver) {
        super(driver);
        loginPageElements = new LoginPageElements(driver);
    }

    public void login(String username, String password) {
        type(loginPageElements.usernameField, username);
        type(loginPageElements.passwordField, password);
        click(loginPageElements.loginButton);
    }

    public boolean isUserOnDashboard() {
        return true;
    }
}
    