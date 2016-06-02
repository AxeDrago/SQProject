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
       baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com";
       //baseUrl = "http://127.0.0.1:8080";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testVerifyTitleNewLayout2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.getTitle(), "Clifton Clunie Personal Page");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }


    @Test
    public void testVerifyMainInfo() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/h3")).getText(),"Clifton Clunie");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/p[1]")).getText(),"Computer System Engineer");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/p[2]")).getText(),"Panama, Panama");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void contactInformation() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[2]/p")).getText(), "clifton.clunie26@gmail.com");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p[2]")).getText(), "@clifton26");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p[3]")).getText(), "@titon26");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @Test
    public void contactInformationLink() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        driver.findElement(By.linkText("@clifton26")).click();
        driver.findElement(By.linkText("@titon26")).click();
    }

    @Test
    public void workHistoryTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[1]")).getText(), "Work History");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[1]")).getText(), "2011");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/h4")).getText(), "Dell Inc");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/h4")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[1]/small")).getText(), "Technical Support");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[1]/small")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[2]/small/span[1]")).getText(), "January 2011 - August 2011 |");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[2]/small/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
            }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[2]/small/span[2]")).getText(), "Panama");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[2]/small/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[2]/p")).getText(), "Development Department");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[2]/p")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @Test
    public void workHistoryTest2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[1]")).getText(), "Work History");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[1]")).getText(), "2015");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/h4")).getText(), "Cibernetica S.A");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/h4")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[1]/small")).getText(), "Business Intelligence Analyst");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[1]/small")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[2]/small/span[1]")).getText(), "April 2014 - August 2015 |");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[2]/small/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[2]/small/span[2]")).getText(), "Panama");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[2]/small/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[2]/p")).getText(), "Global Services Desk");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[2]/p")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void educationHistory() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[2]")).getText(), "Education History");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
          }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[1]")).getText(), "2013");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
          }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/h4")).getText(), "Universidad Tecnologica de Panama");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/h4")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
          }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[1]/small")).getText(), "Computer System Engineering");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[1]/small")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
           }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[2]/small/span[1]")).getText(), "2009-2013 |");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[2]/small/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[2]/small/span[2]")).getText(), "Panama");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[2]/small/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
          }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[2]/p")).getText(), "Bachelor Degree");
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[2]/p")).isDisplayed());
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
