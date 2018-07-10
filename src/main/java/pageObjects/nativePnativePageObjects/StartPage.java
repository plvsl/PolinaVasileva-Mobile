package pageObjects.nativePnativePageObjects;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class StartPage {
    private AppiumDriver driver;

    private By addBtn = By.className("android.widget.Button");

    public StartPage(AppiumDriver appiumDriver) {
        this.driver = appiumDriver;
    }

    public void clickAddContactButton() {
        driver.findElement(addBtn).click();
    }
}
