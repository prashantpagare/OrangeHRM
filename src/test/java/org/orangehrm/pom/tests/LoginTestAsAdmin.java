package org.orangehrm.pom.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.orangehrm.pom.base.BaseTest;
import org.orangehrm.pom.objects.AddAndCreateEmployeeDetails;
import org.orangehrm.pom.pages.DashboardPage;
import org.orangehrm.pom.pages.LoginPage;
import org.orangehrm.pom.pages.PIMPage;
import org.orangehrm.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;

public class LoginTestAsAdmin extends BaseTest {


    @Test
    public void LoginAsAdminWithValidCredentials() {

        // Create a LoginPage object and perform actions using its methods
        LoginPage loginPage = new LoginPage(getDriver()).
                load()
                .enterUsername("Admin")  // Enter username "Admin"
                .enterPassword("admin123"); // Enter password "admin123"

        // Click on the login button and navigate to the Dashboard page
        DashboardPage dashboardPage = loginPage.clickOnLogin();

        // Verify the page title is "Dashboard"
        Assert.assertEquals("Dashboard", dashboardPage.verifyDashboardTitle());

    }

    @Test
    public void CreateEmployeeLoginAsAdminInPimModule() throws IOException {
        // Using Jackson
        AddAndCreateEmployeeDetails addAndCreateEmployeeDetails = JacksonUtils.deserializedJson("AddAndCreateEmployee.json", AddAndCreateEmployeeDetails.class);

        LoginAsAdminWithValidCredentials();
        DashboardPage dashboardPage = new DashboardPage(getDriver());
        Assert.assertEquals("Dashboard", dashboardPage.verifyDashboardTitle());
        dashboardPage.navigateToPIMModule();

        PIMPage pimPage = new PIMPage(getDriver()).
                clickOnAddEmployeeButton().
                setAddEmployeeDetails(addAndCreateEmployeeDetails).
                clickOnSaveButton();

        Assert.assertEquals(pimPage.verifyProfileHeader(), "Personal Details");
        pimPage.clickOnLogout();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-password-chip")));
    }


}
