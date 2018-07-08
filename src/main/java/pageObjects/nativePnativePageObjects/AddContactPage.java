package pageObjects.nativePnativePageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class AddContactPage {
    private static final String APP_PACKAGE_NAME = "com.example.android.contactmanager:id/";
    private AppiumDriver driver;

    private By targetAccount = By.className("android.widget.Spinner");
    private By actualTextsBy = By.className("android.widget.TextView");
    private By contactName = By.id(APP_PACKAGE_NAME + "contactNameEditText");
    private By contactPhone = By.id(APP_PACKAGE_NAME + "contactPhoneEditText");
    private By contactEmail = By.id(APP_PACKAGE_NAME + "contactEmailEditText");

    public AddContactPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    public void checkKeyboardShown() {
        assertTrue(((AndroidDriver) driver).isKeyboardShown());
    }

    public void checkTargetAccountField() {
        assertTrue(driver.findElement(targetAccount).isDisplayed());
    }

    public void checkContactNameAccountField() {
        assertTrue(driver.findElement(contactName).isDisplayed());
    }

    public void checkContactPhoneAccountField() {
        assertTrue(driver.findElement(contactPhone).isDisplayed());
    }

    public void checkContactEmailAccountField() {
        assertTrue(driver.findElement(contactEmail).isDisplayed());
    }

    public void checkFieldsAreDisplayedAndHaveCorrectTexts() {
        List<WebElement> actualTexts = driver.findElements(actualTextsBy);
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
