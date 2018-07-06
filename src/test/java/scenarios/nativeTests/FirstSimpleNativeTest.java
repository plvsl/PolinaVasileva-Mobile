package scenarios.nativeTests;

import enums.PropertyFile;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
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
        String appPackageName = "com.example.android.contactmanager:id/";

        //Click on "Contact Button"
        By addBtn = By.className("android.widget.Button");
        driver().findElement(addBtn).click();

        //Check that keyboard is presented
        assertTrue(((AndroidDriver) driver()).isKeyboardShown());

        //Check that all fields are displayed
        //Target Account field
        By targetAccount = By.className("android.widget.Spinner");
        assertTrue(driver().findElement(targetAccount).isDisplayed());

        //Contact Name field
        By contactName = By.id(appPackageName + "contactNameEditText");
        assertTrue(driver().findElement(contactName).isDisplayed());

        //Contact Phone field
        By contactPhone = By.id(appPackageName + "contactPhoneEditText");
        assertTrue(driver().findElement(contactPhone).isDisplayed());

        //Contact Email field
        By contactEmail = By.id(appPackageName + "contactEmailEditText");
        assertTrue(driver().findElement(contactEmail).isDisplayed());

        //Check that all titles of fields are displayed and have a correct texts
        By actualTextsBy = By.className("android.widget.TextView");
        List<WebElement> actualTexts = driver().findElements(actualTextsBy);
        List<String> expectedTexts = Arrays.asList("Target Account", "Contact Name",
                "Contact Phone", "Home", "Contact Email", "Home");
        for (WebElement element : actualTexts) {
            assertTrue(element.isDisplayed());
        }
        for (int i = 0; i < actualTexts.size() - 1; i++) {
            assertEquals(actualTexts.get(i + 1).getText(), expectedTexts.get(i));
        }
    }
}


