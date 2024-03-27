package org.orangehrm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.orangehrm.pom.base.BasePage;
import org.orangehrm.pom.objects.EmployeeLoginCredentials;

public class LoginPage extends BasePage {

    private final By usernameTxtFld = By.xpath("//input[@placeholder='Username']");
    private final By passwordTxtFld = By.xpath("//input[@placeholder='Password']");
    private final By submitBtn = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage load(){
        load("/web/index.php/auth/login");
        return this;
    }

    public LoginPage enterUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameTxtFld)).sendKeys(username);
    return this;
    }

    public LoginPage enterPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxtFld)).sendKeys(password);
        return this;
    }

    public DashboardPage clickOnLogin(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return new DashboardPage(driver);
    }

    public DashboardPage loginIntoApplication(EmployeeLoginCredentials employeeLoginCredentials){
        return enterUsername(employeeLoginCredentials.getUsername()).
                enterPassword(employeeLoginCredentials.getPassword()).clickOnLogin();
    }







}
