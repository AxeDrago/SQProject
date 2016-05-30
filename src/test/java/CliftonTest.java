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
       baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com/CluniePersonal.html";
       //baseUrl = "http://127.0.0.1:8080/CluniePersonal.html";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


    }

    @Test
    public void testCliftonTest() throws  Exception  {
        driver.get(baseUrl);
        Assert.assertEquals("Clifton Personal Page - SQ", driver.getTitle());
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "MEICM - STUDENT");
            } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//p[2]")).getText(), "Panama");
            } catch (Error e) {
                verificationErrors.append(e.toString());
        }

        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(), "Name:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[2]")).getText(), "Country:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[3]")).getText(), "Address:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[4]")).getText(), "Skills:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[5]")).getText(), "Description:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[6]")).getText(), "Social Media Link:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Comments");
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
