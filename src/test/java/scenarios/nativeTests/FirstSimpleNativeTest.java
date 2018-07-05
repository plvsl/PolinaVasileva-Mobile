package scenarios.nativeTests;

import enums.PropertyFile;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

@Test(groups = "native")
public class FirstSimpleNativeTest extends Driver {

    protected FirstSimpleNativeTest() throws IOException {
        super(PropertyFile.NATIVE);
    }

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";

        //Click on "Contact Button"
        By add_btn =  By.className("android.widget.Button");
        driver().findElement(add_btn).click();

        //Check that keyboard is presented
        Assert.assertTrue(((AndroidDriver)driver()).isKeyboardShown());

        //Check that all fields are displayed
        //Target Account field
        By targetAccount =  By.className("android.widget.Spinner");
        Assert.assertTrue(driver().findElement(targetAccount).isDisplayed());

        //Contact Name field
        By contactName =  By.id(app_package_name + "contactNameEditText");
        Assert.assertTrue(driver().findElement(contactName).isDisplayed());

        //Contact Phone field
        By contactPhone =  By.id(app_package_name + "contactPhoneEditText");
        Assert.assertTrue(driver().findElement(contactPhone).isDisplayed());

        //Contact Email field
        By contactEmail =  By.id(app_package_name + "contactEmailEditText");
        Assert.assertTrue(driver().findElement(contactEmail).isDisplayed());

        //Check that all titles of fields are displayed and have a correct texts
        By realTexts1 =  By.className("android.widget.TextView");
        List<WebElement> actualTexts = Arrays.asList(driver().findElement(realTexts1));
        List<String> expectedTexts = Arrays.asList("Target Account", "Contact Name",
                "Contact Phone", "Contact Email");
        for (WebElement element : actualTexts) {
            Assert.assertTrue(element.isDisplayed());
        }
        for(int i = 0; i < actualTexts.size() - 1; i++) {
            assertEquals(actualTexts.get(i + 1).getText(), expectedTexts.get(i));
        }
        //
    }
}


