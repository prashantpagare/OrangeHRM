package org.orangehrm.pom.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.orangehrm.pom.base.BasePage;
import org.testng.Assert;

import java.util.List;

public class MyInfoPage extends BasePage {

    private final By matchHeaderName = By.xpath("//h6[normalize-space()='Personal Details']");
    private final By empFirstname = By.xpath("//input[@placeholder='First Name']");
    private final By empMiddlename = By.xpath("//input[@placeholder='Middle Name']");
    private final By empLastname = By.xpath("//input[@placeholder='Last Name']");
    private final By empOtherID = By.xpath("//label[contains(text(),'Other Id')]/parent::div/following-sibling::div/input");
    private final By empNationality = By.xpath("//label[contains(text(),'Nationality')]/parent::div/following-sibling::div");
    private final By empMaritalStatus = By.xpath("//label[contains(text(),'Marital Status')]/parent::div/following-sibling::div");
    private final By empGender = By.xpath("//label[normalize-space()='Male']");
    private final By empMilitaryService = By.xpath("//label[contains(text(),'Military Service')]/parent::div/following-sibling::div/input");
    private final By empSmoker = By.xpath("//input[@type='checkbox']");
    private final By empSaveData1 = By.xpath("(//button[@type='submit'])[1]");
    private final By successToastMessage = By.xpath("//p[contains(.,'Successfully Updated')]");


    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    public String verifyHeadingTitle() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(matchHeaderName)).getText();
    }

    public MyInfoPage waitForLoadingToDisappear() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));
        return this;
    }

    public MyInfoPage updateEmpFirstname(String empFname) {

        WebElement empFirstnameElement = wait.until(ExpectedConditions.elementToBeClickable(empFirstname));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(empFirstname)).sendKeys(empFname);
        Assert.assertTrue(empFirstnameElement.isEnabled());

        empFirstnameElement.clear();
        empFirstnameElement.sendKeys(empFname);
        return this;
    }

    public MyInfoPage updateEmpMiddlename(String empMidname) {
        WebElement empMiddlenameElement = wait.until(ExpectedConditions.elementToBeClickable(empMiddlename));
        empMiddlenameElement.sendKeys(empMidname);
        return this;
    }

    public MyInfoPage updateEmpLastname(String empLstname) {
        WebElement empLastnameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(empLastname));
        empLastnameElement.sendKeys(empLstname);
        return this;
    }

    public MyInfoPage enterOtherID(String othID) {
        WebElement empOtherIdElement = wait.until(ExpectedConditions.elementToBeClickable(empOtherID));
        empOtherIdElement.sendKeys(othID);
        return this;
    }

    public MyInfoPage selectEmpNationality(String countryName) {
        wait.until(ExpectedConditions.elementToBeClickable(empNationality)).click();
        List<WebElement> countryNames = driver.findElements(By.cssSelector(".oxd-select-option"));
        for (WebElement country : countryNames) {
            if (country.getText().equalsIgnoreCase(countryName)) {
//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+countryName+"')]"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(country)).click();
                break;
            }
        }
        return this;
    }

    public MyInfoPage selectMarriageStatus(String marriageStatus) {
        wait.until(ExpectedConditions.elementToBeClickable(empMaritalStatus)).click();
        List<WebElement> empMaritalStatus = driver.findElements(By.cssSelector(".oxd-select-option"));
        for (WebElement status : empMaritalStatus) {
            if (status.getText().equalsIgnoreCase(marriageStatus)) {
//                wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'"+countryName+"')]"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(status)).click();
                break;
            }
        }
        return this;
    }

    public MyInfoPage selectGender(String gender) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[normalize-space()='" + gender + "']"))).click();
        return this;
    }

    public MyInfoPage clickOnSave() {
        wait.until(ExpectedConditions.elementToBeClickable(empSaveData1)).click();
        return this;
    }

    public String verifySuccessSavedMessage() {
       return wait.until(ExpectedConditions.presenceOfElementLocated(successToastMessage)).getText();
    }

}