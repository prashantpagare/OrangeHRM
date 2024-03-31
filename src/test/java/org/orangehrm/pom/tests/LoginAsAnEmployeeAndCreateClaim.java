package org.orangehrm.pom.tests;

import org.orangehrm.pom.base.BaseTest;
import org.orangehrm.pom.objects.EmployeeLoginCredentials;
import org.orangehrm.pom.pages.ClaimPage;
import org.orangehrm.pom.pages.DashboardPage;
import org.orangehrm.pom.pages.LoginPage;
import org.orangehrm.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginAsAnEmployeeAndCreateClaim extends BaseTest {

    @Test
    public void createClaimTest() throws IOException {
        EmployeeLoginCredentials employeeLoginCredentials = JacksonUtils.deserializedJson("EmployeeLoginCredentials.json", EmployeeLoginCredentials.class);

        DashboardPage dashboardPage = new LoginPage(getDriver()).
                load().loginIntoApplication(employeeLoginCredentials);
        Assert.assertEquals("Dashboard", dashboardPage.verifyDashboardTitle());

        ClaimPage claimPage = dashboardPage.navigateToClaimPage();
        Assert.assertEquals("My Claims", claimPage.verifyHeadingTitle());

        claimPage.clickOnSubmitClaimButton();
        Assert.assertEquals("Create Claim Request", claimPage.verifyClaimRequestHeader());

        claimPage.
                selectClaimEvent("Travel Allowance").
                selectClaimCurrency("Indian Rupee").
                enterClaimRemarks("Travelled from A to B").
                clickOnCreateClaim();
        Assert.assertEquals("Successfully Saved", claimPage.verifySuccessClaimMessage());
        claimPage.clickOnSubmitClaimRequest();
        Assert.assertEquals("Successfully Saved", claimPage.verifySuccessClaimMessage());
        String id = claimPage.verifyClaimRefID();
        claimPage.clickOnBackClaimRequest();
        Assert.assertEquals(id , claimPage.verifySuccessClaimMessage());
    }
}
