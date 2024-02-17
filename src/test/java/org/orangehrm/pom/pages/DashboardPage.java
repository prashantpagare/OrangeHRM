package org.orangehrm.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.orangehrm.pom.base.BasePage;

public class DashboardPage extends BasePage {

    private final By goToPIMModule = By.cssSelector("a[href*='Pim']");
    private final By titleText = By.xpath("//h6[text()='Dashboard']");


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public PIMPage navigateToPIMModule(){
        wait.until(ExpectedConditions.elementToBeClickable(goToPIMModule)).click();
        return new PIMPage(driver);
    }

    public String verifyDashboardTitle(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(titleText)).getText();
    }
}
