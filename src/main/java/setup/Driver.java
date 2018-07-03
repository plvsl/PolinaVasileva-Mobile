package setup;


import com.sun.xml.internal.bind.v2.TODO;
import enums.PropertyFile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Driver extends TestProperties {
    private static AppiumDriver driverSingle;
    private static WebDriverWait waitSingle;


    // Properties to be read
    private String APP; // (mobile) app under testing
    protected String SUT; // site under testing
    private String TEST_PLATFORM;
    private String TEST_PLATFORM_VERSION;
    private String HOST;
    private String DEVICE_NAME;

    Driver() {
    }

    // Constructor initializes properties on driver creation
    protected Driver(PropertyFile propertyFile) throws IOException {
        this.propertyFile = propertyFile;

        switch (propertyFile) {
            case NATIVE:
                APP = getProp("app");
                break;
            case WEB:
                String t_sut = getProp("sut");
                SUT = t_sut == null ? null : "http://" + t_sut;
                break;
        }

        TEST_PLATFORM = getProp("platformName");
        TEST_PLATFORM_VERSION = getProp("platformVersion");
        HOST = getProp("host");
        DEVICE_NAME = getProp("deviceName");
    }

    /**
     * Initialize driver with appropriate capabilities depending on platform and application
     *
     * @throws Exception
     */

    void prepareDriver() throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        File file = new File("src\\main\\resources\\chromedriver.exe");
        capabilities.setCapability("chromedriverExecutableDir", file.getAbsoluteFile().getParent());

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, TEST_PLATFORM);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, TEST_PLATFORM_VERSION);

        // Setup type of application: mobile, web (or hybrid)
        if (APP != null && SUT == null) {
            // Native
            File app = new File(APP);
            capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } else if (SUT != null && APP == null) {
            // Web
            // Setup test platform: Android or iOS. Browser also depends on a platform.
            switch (TEST_PLATFORM) {
                case "Android":
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
                    break;
                case "iOS":
                    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
                    break;
                default:
                    throw new Exception("Unknown mobile platform");
            }
        } else {
            throw new Exception("Unclear type of mobile app");
        }
        // Init driver for local Appium server with capabilities have been set
        driverSingle = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

        // Set an object to handle timeouts
        if (waitSingle == null) {
            waitSingle = new WebDriverWait(driver(), 10);
        }
    }

    protected AppiumDriver driver() throws Exception {
        if (driverSingle == null) {
            prepareDriver();
        }
        return driverSingle;
    }

    protected WebDriverWait driverWait() {
        return waitSingle;
    }
}