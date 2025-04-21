package com.myproject.steps;

import com.myproject.pages.LoginPage;
import com.myproject.utils.AllureUtils;
import com.myproject.utils.DriverManager;
import com.myproject.utils.ExtentTestManager;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.qameta.allure.Allure;
import jdk.internal.net.http.common.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.swing.event.TableModelListener;
import java.io.ByteArrayInputStream;

public class LoginSteps {

    private DriverManager driverManager;
    private WebDriver driver;
    private LoginPage loginPage;
    private LoginPage dashboardPage;
    private final ExtentTestManager extentTestManager;


    public LoginSteps(DriverManager driverManager, ExtentTestManager extentTestManager) {
        this.driver = driverManager.getDriver();
        this.extentTestManager = extentTestManager;
        this.loginPage = new LoginPage(driver);
        this.dashboardPage = new LoginPage(driver);
    }

    @When("User logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        // Log message
        String logMessage = "User logging in with username: " + username + " and password: " + password;

        // Attaching the log message to the Allure report
        Allure.addAttachment("Login Attempt", logMessage);

        // You can perform the login logic here
        loginPage.login(username, password);

        // Additional logging after the login
        String successMessage = "Login attempt successful for username: " + username;
        Allure.addAttachment("Login Success", successMessage);
        extentTestManager.getTest().info("Logging in...");
    }

    @Then("Verify user is on the dashboard page")
    public void verify_user_is_on_the_dashboard_page() {
        boolean isOnDashboard = dashboardPage.isUserOnDashboard();

        // Add a log with the result of the verification
        String verificationLog = "User is on dashboard: " + isOnDashboard;
        AllureUtils.attachText("Dashboard Verification", verificationLog);

        // You can also attach screenshots if needed
        if (isOnDashboard) {
            byte[] screenshot = captureScreenshot();  // Replace with actual screenshot capture method
            AllureUtils.attachScreenshot("Dashboard Screenshot", screenshot);
        }
    }

    // Example of a method that captures a screenshot
    private byte[] captureScreenshot() {
        // Replace with your actual screenshot capture logic
        TakesScreenshot tk = (TakesScreenshot) driver;
        return tk.getScreenshotAs(OutputType.BYTES); // For demonstration purposes
    }
}
