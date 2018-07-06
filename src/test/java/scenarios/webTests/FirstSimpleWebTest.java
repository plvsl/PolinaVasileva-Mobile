package scenarios.webTests;

import enums.PropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Hooks;

import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Test(groups = "web")
public class FirstSimpleWebTest extends Hooks {

    protected FirstSimpleWebTest() throws IOException {
        super(PropertyFile.WEB);
    }

    @Test(groups = "web", description = "Open website, check main div blocks and \"Google Search\"")
    public void webTest() throws Exception {

        //Open site
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT + "/"));
        System.out.println("Site opening done");

        //Check the title of page
        assertEquals(driver().getTitle(), "Internet Assigned Numbers Authority");

        //Check that site contains logo and it is displayed
        By logo = By.cssSelector("h1");
        assertTrue(driver().findElement(logo).getCssValue("background-image")
                .contains("/_img/2015.1/iana-logo-header-notext.svg"));

        assertTrue(driver().findElement(logo).isDisplayed());

        //Check that "Domain Names" block is displayed
        By domainName = By.id("home-panel-domains");
        Assert.assertTrue(driver().findElement(domainName).isDisplayed());

        //Check that "Number Resources" block is displayed
        By numberResources = By.id("home-panel-numbers");
        Assert.assertTrue(driver().findElement(numberResources).isDisplayed());

        //Check that "Protocol Assignments" block is displayed
        By protocolAssignments = By.id("home-panel-protocols");
        Assert.assertTrue(driver().findElement(protocolAssignments).isDisplayed());

        //Check that block with "Revised Privacy Policy and Terms of Service" is displayed
        By privacyPolicy = By.id("home-news");
        Assert.assertTrue(driver().findElement(privacyPolicy).isDisplayed());

        //Check that "Google Search" textBox is displayed
        By textBox = By.id("gsc-i-id1");
        Assert.assertTrue(driver().findElement(textBox).isDisplayed());

        //Check that "Google Search" button is displayed
        By button = By.cssSelector(".gsc-search-button .gsc-search-button-v2");
        Assert.assertTrue(driver().findElement(button).isDisplayed());

        //Check that "Google Search" overlay appears
        driver().findElement(textBox).sendKeys("EPAM");
        driver().findElement(button).click();
        By overlay = By.cssSelector(".gsc-results-wrapper-visible");
        Assert.assertTrue(driver().findElement(overlay).isDisplayed());

        System.out.println("All checks are successful and done");
    }
}
