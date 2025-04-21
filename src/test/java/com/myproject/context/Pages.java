package com.myproject.context;

import com.myproject.pages.DropdownPage;
import com.myproject.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Pages {
    public LoginPage loginPage;
    public DropdownPage dropdownPage;

    public LoginPage dashBoardPage;


    public Pages(WebDriver driver) {
        loginPage = new LoginPage(driver);
        dropdownPage = new DropdownPage(driver);
        dashBoardPage = loginPage;
    }
}

