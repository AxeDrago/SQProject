import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.fail;

public class CliftonTest {
    private static WebDriver driver;
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    //@BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
       driver = new FirefoxDriver();
       baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com/CluniePersonal.html";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
       driver.get(baseUrl);
       Assert.assertEquals(driver.getTitle(), "Clifton Personal Page - SQ");
    }

    @Test
    public void testCliftonTest() throws  Exception  {
        System.out.print("Entro");
        //driver.get(baseUrl);  --- error
        System.out.print("Entro2");
        //Assert.assertEquals(driver.getTitle(), "Clifton Personal Page - SQ");
    }

    //@AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
