import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import static junit.framework.TestCase.assertTrue;
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
    public void testVerifyTitleNewLayout() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.getTitle(), "Clifton Clunie Personal Page");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

/*
    @Test
    public void testCliftonTest() throws Exception {
        driver.get(baseUrl);
        try {
            Assert.assertEquals(driver.getTitle(), "SQ Project Pipeline");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testUserStory1Scenario2() throws Exception {
        driver.get(baseUrl);
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h2")).getText(), "Team Name - DCM:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testUserStory2Scenario2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[2]/div")).click();
        try {
            Assert.assertEquals(driver.getTitle(), "Clifton Personal Page - SQ");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "MEICM - STUDENT");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testUserStory2Scenario3() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[2]/div")).click();
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
            Assert.assertEquals(driver.findElement(By.xpath("//h3[4]")).getText(), "Contacts:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[5]")).getText(), "CV:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[6]")).getText(), "Skills:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[7]")).getText(), "Social Media Link:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//h3[8]")).getText(), "Professional Experience:");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void imageVerification() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//a[2]/div")).click();
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div[1]/img")).isDisplayed());

    }

    @Test
    public void cssVerification() throws Exception {
        driver.get(baseUrl);
        //driver.findElement(By.xpath("//a[2]/div")).click();
        //System.out.print(driver.findElement(By.cssSelector("css=h1")).getCssValue("display"));
    }
*/
    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
