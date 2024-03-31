package org.orangehrm.pom.tests;

import org.orangehrm.pom.base.BaseTest;
import org.orangehrm.pom.objects.AddAndCreateEmployeeDetails;
import org.orangehrm.pom.objects.EmployeeLoginCredentials;
import org.orangehrm.pom.pages.DashboardPage;
import org.orangehrm.pom.pages.LoginPage;
import org.orangehrm.pom.pages.MyInfoPage;
import org.orangehrm.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginAsAnEmployeeAndUpdateMyInfo extends BaseTest {

    @Test
    public void LoginAsAnEmployeeAndUpdateMyInfoPage() throws IOException {
        EmployeeLoginCredentials employeeLoginCredentials = JacksonUtils.deserializedJson("EmployeeLoginCredentials.json", EmployeeLoginCredentials.class);

        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().loginIntoApplication(employeeLoginCredentials);
        Assert.assertEquals("Dashboard", dashboardPage.verifyDashboardTitle());

        MyInfoPage myInfoPage = dashboardPage.navigateToMyInfo();
        Assert.assertEquals("Personal Details", myInfoPage.verifyHeadingTitle());
        myInfoPage.waitForLoadingToDisappear()
                .updateEmpFirstname("Jackie").
                updateEmpMiddlename("Chan").
                updateEmpLastname("China").
                enterOtherID("69").
                selectDOB("2024-05-07").
                selectEmpNationality("Indian").
                selectMarriageStatus("Other").
                selectGender("Female").
                clickOnSave();
        Assert.assertEquals("Successfully Updated", myInfoPage.verifySuccessSavedMessage());
    }
}
