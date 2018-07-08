package scenarios.webTests;

import enums.PropertyFile;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.webPageObjects.HomePage;
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
        HomePage homePage = new HomePage(driver());

        //Open site
        homePage.open(SUT, driverWait());

        //Check the title of page
        homePage.checkTitle();

        //Check that site contains logo and it is displayed
        homePage.checkLogo();

        //Check that "Domain Names" block is displayed
        homePage.checkDomainNamesBlock();

        //Check that "Number Resources" block is displayed
        homePage.checkNumberResourcesBlock();

        //Check that "Protocol Assignments" block is displayed
        homePage.checkProtocolAssignmentsBlock();

        //Check that block with "Revised Privacy Policy and Terms of Service" is displayed
        homePage.checkRevisedPrivacyPolicyBlock();

        //Check that "Google Search" textBox is displayed
        homePage.checkGoogleSearchTextbox();

        //Check that "Google Search" button is displayed
        homePage.checkGoogleSearchButton();

        //Check that "Google Search" overlay appears
        homePage.checkGoogleSearchOverlay();
    }
}
