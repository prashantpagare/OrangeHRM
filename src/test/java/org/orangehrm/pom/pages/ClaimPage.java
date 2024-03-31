package org.orangehrm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.orangehrm.pom.base.BasePage;
import org.testng.annotations.Test;

import java.util.List;

public class ClaimPage extends BasePage {

    private final By matchHeaderName = By.xpath("//h5[normalize-space()='My Claims']");
    private final By claimReq = By.xpath("//h6[normalize-space()='Create Claim Request']");
    private final By submitClaimBtn = By.xpath("//button[normalize-space()='Submit Claim']");
    private final By claimEvent = By.xpath("//label[contains(text(),'Event')]/parent::div/following-sibling::div/div/div/div");
    private final By submitClaimCurrency = By.xpath("//label[contains(text(),'Currency')]/parent::div/following-sibling::div[1]");
    private final By insertRemarksText =  By.cssSelector(".oxd-textarea");
    private final By submitBtn =  By.xpath("//button[@type='submit']");
    private final By cancelBtn =  By.xpath("//button[normalize-space()='Cancel']");
    private final By successToastMessage = By.xpath("//p[contains(.,'Successfully Saved')]");
    private final By finalSubmitClaimBtn= By.xpath("//button[contains(.,' Submit ')]");
    private final By finalCancelClaimBtn = By.xpath("//button[contains(.,' Cancel ')]");
    private final By finalBackClaimBtn = By.xpath("//button[contains(.,' Back ')]");
    private final By claimRefID = By.xpath("//label[contains(text(),'Reference Id')]/parent::div/following-sibling::div[1]");


    public ClaimPage(WebDriver driver) {
        super(driver);
    }

    public String verifyHeadingTitle() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(matchHeaderName)).getText();
    }

    public ClaimPage clickOnSubmitClaimButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitClaimBtn)).click();
        return this;
    }

    public String verifyClaimRequestHeader() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(claimReq)).getText();
    }

    public ClaimPage selectClaimEvent(String event){
        wait.until(ExpectedConditions.elementToBeClickable(claimEvent)).click();
        List<WebElement> claimEvents = driver.findElements(By.xpath("//div[@role='listbox']//div[4]"));
        for(WebElement e : claimEvents){
            if(e.getText().equalsIgnoreCase(event)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
        return this;
    }

    @Test
    public ClaimPage selectClaimCurrency(String currency){
        wait.until(ExpectedConditions.elementToBeClickable(submitClaimCurrency)).click();
        List<WebElement> claimEventz = driver.findElements(By.xpath("//div[@role='listbox']//div"));
        for(WebElement e : claimEventz){
            if(e.getText().equalsIgnoreCase(currency)){
                wait.until(ExpectedConditions.elementToBeClickable(e)).click();
                break;
            }
        }
        return this;
    }

    public ClaimPage enterClaimRemarks(String text){
        wait.until(ExpectedConditions.elementToBeClickable(insertRemarksText)).sendKeys(text);
        return this;
    }

    public ClaimPage clickOnCreateClaim(){
        wait.until(ExpectedConditions.elementToBeClickable(submitBtn)).click();
        return this;
    }

    public ClaimPage clickOnCancelClaim(){
        wait.until(ExpectedConditions.elementToBeClickable(cancelBtn)).click();
        return this;
    }

    public String verifySuccessClaimMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(successToastMessage)).getText();
    }

    public ClaimPage clickOnSubmitClaimRequest(){
        wait.until(ExpectedConditions.elementToBeClickable(finalSubmitClaimBtn)).click();
        return this;
    }

    public ClaimPage clickOnCancelClaimRequest(){
        wait.until(ExpectedConditions.elementToBeClickable(finalCancelClaimBtn)).click();
        return this;
    }

    public ClaimPage clickOnBackClaimRequest(){
        wait.until(ExpectedConditions.elementToBeClickable(finalBackClaimBtn)).click();
        return this;
    }

    public String verifyClaimRefID() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(claimRefID)).getText();
    }
}
