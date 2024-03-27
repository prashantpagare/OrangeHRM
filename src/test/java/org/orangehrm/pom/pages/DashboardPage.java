package org.orangehrm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.orangehrm.pom.base.BasePage;

public class DashboardPage extends BasePage {

    private final By goToPIMModule = By.cssSelector("a[href*='Pim']");
    private final By titleText = By.xpath("//h6[text()='Dashboard']");
    private final By myInfoLink = By.xpath("//span[normalize-space()='My Info']");
    private final By overlay = By.cssSelector(".oxd-loading-spinner");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public PIMPage navigateToPIMModule(){
        wait.until(ExpectedConditions.elementToBeClickable(goToPIMModule)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(overlay));
        return new PIMPage(driver);
    }

    public String verifyDashboardTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleText)).getText();
    }

    public MyInfoPage navigateToMyInfo(){

        wait.until(ExpectedConditions.elementToBeClickable(myInfoLink)).click();
        return new MyInfoPage(driver);
    }

}
