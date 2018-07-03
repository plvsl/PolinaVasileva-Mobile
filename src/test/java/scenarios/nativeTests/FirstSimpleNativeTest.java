package scenarios.nativeTests;

import enums.PropertyFile;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

@Test(groups = "native")
public class FirstSimpleNativeTest extends Driver {

    protected FirstSimpleNativeTest() throws IOException {
        super(PropertyFile.NATIVE);
    }

    @Test(description = "Just click on button 'Add contact'")
    public void simplestTest() throws Exception {
        String app_package_name = "com.example.android.contactmanager:id/";
        By add_btn = By.id(app_package_name + "addContactButton");
        driver().findElement(add_btn).click();

        // The result of clicking doesn't checked.
        System.out.println("Simplest Appium test done");
    }
}


