package scenarios.nativeTests;

import enums.PropertyFile;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pageObjects.nativePnativePageObjects.AddContactPage;
import pageObjects.nativePnativePageObjects.StartPage;
import setup.Hooks;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

@Test(groups = "native")
public class FirstSimpleNativeTest extends Hooks {

    protected FirstSimpleNativeTest() throws IOException {
        super(PropertyFile.NATIVE);
    }

    @Test(groups = "native", description = "Click on button 'Add contact', check that keyboard is presented, " +
            "check main titles and fields of page")
    public void simplestTest() throws Exception {
        StartPage startPage = new StartPage(driver());
        AddContactPage addContactPage = new AddContactPage(driver());

        //Click on "Contact Button"
        startPage.clickAddContactButton();

        //Check that keyboard is presented
        addContactPage.checkKeyboardShown();

        //Check that all fields are displayed
        //Target Account field
        addContactPage.checkTargetAccountField();
        //Contact Name field
        addContactPage.checkContactNameAccountField();
        //Contact Phone field
        addContactPage.checkContactPhoneAccountField();
        //Contact Email field
        addContactPage.checkContactEmailAccountField();

        //Check that all titles of fields are displayed and have a correct texts
        addContactPage.checkFieldsAreDisplayedAndHaveCorrectTexts();
    }
}


