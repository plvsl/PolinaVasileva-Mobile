package setup;

import enums.PropertyFile;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeGroups;

import java.io.IOException;

public class Hooks extends Driver {

    protected Hooks(PropertyFile propertyFile) throws IOException {
        super(propertyFile);
    }

    @BeforeGroups(groups = "native", description = "Prepare driver to run test(s)")
    public void setUpNative() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared for native app");
    }

    @BeforeGroups(groups = "web", description = "Prepare driver to run test(s)")
    public void setUpWeb() throws Exception {
        prepareDriver();
        System.out.println("Driver prepared for web");
    }

    @AfterSuite(groups = {"native", "web"}, description = "Close driver on all tests completion")
    public void tearDown() throws Exception {
        driver().quit(); //CLOSEAPP ?
        System.out.println("Driver closed");
    }
}
