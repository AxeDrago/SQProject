import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.junit.Assert.fail;

public class CliftonTest {
    private static WebDriver driver;
    private static String baseUrl;
    private boolean acceptNextAlert = true;
    private static StringBuffer verificationErrors = new StringBuffer();


    @BeforeClass
    public static void setUp() throws Exception {
       //driver = new FirefoxDriver();
       driver = new HtmlUnitDriver();
       //baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com";
       baseUrl = "http://127.0.0.1:8080";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testCliftonTest() throws Exception {
        driver.get(baseUrl);
        try {
            Assert.assertEquals(driver.getTitle(), "SQ Project Pipeline");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
