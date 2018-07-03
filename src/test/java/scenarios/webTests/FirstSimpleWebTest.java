package scenarios.webTests;

import enums.PropertyFile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import setup.Driver;

import java.io.IOException;

@Test(groups = "web")
public class FirstSimpleWebTest extends Driver {

    protected FirstSimpleWebTest() throws IOException {
        super(PropertyFile.WEB);
    }

    @Test(description = "Open website")
    public void webTest() throws Exception {
        driver().get(SUT);
        driverWait().until(ExpectedConditions.urlToBe(SUT+"/"));
        System.out.println("Site opening done");
    }
}
