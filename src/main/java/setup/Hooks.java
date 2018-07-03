package setup;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

@Test(groups = {"native","web"})
public class Hooks extends Driver {

    @BeforeSuite(groups = "native", description = "Prepare driver to run test(s)")
    public void setUpNative() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared for native app");
    }

    @BeforeSuite(groups = "web", description = "Prepare driver to run test(s)")
    public void setUpWeb() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared for web");
    }

    @AfterSuite(description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit();
        System.out.println("Driver closed");
    }

}
