package pageObjects.webPageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePage {
    private AppiumDriver driver;

    private By logo = By.cssSelector("h1");
    private By domainName = By.id("home-panel-domains");
    private By numberResources = By.id("home-panel-numbers");
    private By protocolAssignments = By.id("home-panel-protocols");
    private By privacyPolicy = By.id("home-news");
    private By textBox = By.id("gsc-i-id1");
    private By button = By.cssSelector(".gsc-search-button .gsc-search-button-v2");
    private By buttonG = By.cssSelector(".gsc-orderby");

    public HomePage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    public void open(String sut, WebDriverWait webDriverWait) {
        driver.get(sut);
        webDriverWait.until(ExpectedConditions.urlToBe(sut + "/"));
    }

    public void checkTitle() {
        assertEquals(driver.getTitle(), "Internet Assigned Numbers Authority");
    }

    public void checkLogo() {
        assertTrue(driver.findElement(logo).getCssValue("background-image")
                .contains("/_img/2015.1/iana-logo-header-notext.svg"));
        assertTrue(driver.findElement(logo).isDisplayed());
    }

    public void checkDomainNamesBlock() {
        Assert.assertTrue(driver.findElement(domainName).isDisplayed());
    }

    public void checkNumberResourcesBlock() {
        Assert.assertTrue(driver.findElement(numberResources).isDisplayed());
    }

    public void checkProtocolAssignmentsBlock() {
        Assert.assertTrue(driver.findElement(protocolAssignments).isDisplayed());
    }

    public void checkRevisedPrivacyPolicyBlock() {
        Assert.assertTrue(driver.findElement(privacyPolicy).isDisplayed());
    }

    public void checkGoogleSearchTextbox() {
        Assert.assertTrue(driver.findElement(textBox).isDisplayed());
    }

    public void checkGoogleSearchButton() {
        Assert.assertTrue(driver.findElement(button).isDisplayed());
    }

    public void checkGoogleSearchOverlay() {
        driver.findElement(textBox).sendKeys("EPAM");
        driver.findElement(button).click();
        Assert.assertTrue(driver.findElement(buttonG).isDisplayed());
    }
}
