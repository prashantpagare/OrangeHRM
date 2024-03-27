package org.orangehrm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.orangehrm.pom.base.BasePage;
import org.orangehrm.pom.objects.AddAndCreateEmployeeDetails;

public class PIMPage extends BasePage {

    private final By addEmployeeBtn = By.xpath("//button[normalize-space()='Add']");
    private final By firstnameTxtFld = By.xpath("//input[@placeholder='First Name']");
    private final By middlenameTxtFld = By.xpath("//input[@placeholder='Middle Name']");
    private final By lastnameTxtFld = By.xpath("//input[@placeholder='Last Name']");
    private final By employeeID = By.xpath("//label[contains(text(),'Employee Id')]/parent::div/following-sibling::div/input");
    private final By switchOnToggle = By.cssSelector(".oxd-switch-input--active");
    private final By setNewUsername = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private final By statusEnable = By.xpath("//label[normalize-space()='Enabled']");
    private final By statusDisable = By.xpath("//label[normalize-space()='Disabled']");
    private final By setNewPassword = By.xpath("(//input[@type='password'])[1]");
    private final By setNewConfirmPassword = By.xpath("(//input[@type='password'])[2]");
    private final By passwordStrengthNotification = By.cssSelector(".orangehrm-password-chip");
    private final By saveBtn = By.xpath("//button[@type='submit']");
    private final By cancelBtn = By.xpath("//button[@type='button']");
    private final By profileLink = By.xpath("//p[@class='oxd-userdropdown-name']");
    private final By logout = By.xpath("//a[normalize-space()='Logout']");
    private final By matchTag = By.xpath("//h6[normalize-space()='Personal Details']");


    public PIMPage(WebDriver driver) {
        super(driver);
    }

    public PIMPage clickOnAddEmployeeButton(){
        driver.findElement(addEmployeeBtn).click();
        return this;
    }

    public PIMPage enterFirstName(String fName){
        driver.findElement(firstnameTxtFld).sendKeys(fName);
        return this;
    }

    public PIMPage enterMiddleName(String mName){
        driver.findElement(middlenameTxtFld).sendKeys(mName);
        return this;
    }

    public PIMPage enterLastName(String lName){
        driver.findElement(lastnameTxtFld).sendKeys(lName);
        return this;
    }

    public PIMPage enterEmployeeID(String empID){
        driver.findElement(employeeID).clear();
        driver.findElement(employeeID).sendKeys(empID);
        return this;
    }

    public PIMPage clickOnCreateLoginSwitch(){
        driver.findElement(switchOnToggle).click();
        return this;
    }

    public PIMPage setNewUsernameForLogin(String newUsername){
        driver.findElement(setNewUsername).sendKeys(newUsername);
        return this;
    }

    public PIMPage setNewPasswordForLogin(String newPassword){
        driver.findElement(setNewPassword).sendKeys(newPassword);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-password-chip")));
        return this;
    }

    public PIMPage setNewConfirmPasswordForLogin(String newConfirmPassword){
        driver.findElement(setNewConfirmPassword).sendKeys(newConfirmPassword);
        return this;
    }

    public PIMPage clickOnStatusAsEnabled(){
        driver.findElement(statusEnable).click();
        return this;
    }

    public PIMPage clickOnStatusAsDisabled(){
        driver.findElement(statusDisable).click();
        return this;
    }

    public PIMPage setAddEmployeeDetails(AddAndCreateEmployeeDetails addAndCreateEmployeeDetails){
        return enterFirstName(addAndCreateEmployeeDetails.getFirstName())
                .enterMiddleName(addAndCreateEmployeeDetails.getMiddleName())
                .enterLastName(addAndCreateEmployeeDetails.getLastName())
                .enterEmployeeID(addAndCreateEmployeeDetails.getEmpID()).
                clickOnCreateLoginSwitch().
                clickOnStatusAsDisabled().
                setNewUsernameForLogin(addAndCreateEmployeeDetails.getNewUserName()).
                setNewPasswordForLogin(addAndCreateEmployeeDetails.getNewPassword()).
                setNewConfirmPasswordForLogin(addAndCreateEmployeeDetails.getNewConfirmPassword());
    }

    public PIMPage clickOnSaveButton(){
        driver.findElement(saveBtn).click();
        return this;
    }

    public PIMPage clickOnCancelButton(){
        driver.findElement(cancelBtn).click();
        return this;
    }

    public PIMPage clickOnLogout(){
        wait.until(ExpectedConditions.elementToBeClickable(profileLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        return this;
    }

    public String verifyProfileHeader(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(matchTag)).getText();
    }






}
