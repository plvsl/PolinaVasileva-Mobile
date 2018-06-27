package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverSetup {
    protected WebDriver driver;

    protected void prepareAndroidNative() throws MalformedURLException { // exception required by java.net.URL
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory capabilities
        capabilities.setCapability("device","Android"); // mandatory???????
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformVersion", "8.1");
        //capabilities.setCapability("deviceName","e081dc16");
        capabilities.setCapability("platformName","Android");

        // path to app
        // Copy the application (.apk), which will become AUT, to the specified location,
        // e.g. "resources" folder of the project
        File appDir = new File("C:\\Users\\Polina\\Desktop\\AutoTest\\PolinaVasileva-Mobile\\src\\main\\resources");
        File app = new File(appDir, "contactmanager.apk");

        //other caps
        capabilities.setCapability("app", app.getAbsolutePath());

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    protected void prepareAndroidWeb() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1");
        capabilities.setCapability("chromedriverExecutableDir","C:\\Users\\Polina\\Desktop\\AutoTest\\PolinaVasileva-Mobile\\src\\main\\resources\\");

        // specific web capabilities
        capabilities.setCapability("browserName", "Chrome");
        //capabilities.setCapability("browserName", "Browser");

        // Init driver for local Appium server with capabilities have been set
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }
}
