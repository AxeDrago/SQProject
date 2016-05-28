/**
 * Created by Clifton on 27/5/16.
 */

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.fail;

public class CliftonTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    //@BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        driver = new FirefoxDriver();
        //baseUrl = "https://en.wikipedia.org/wiki/Table_cell";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    //@Test
    public void testVerififyTitle() throws Exception {
        driver.get("http://localhost:63342/SQProject/SQ_Project/CluniePersonal.html?_ijt=ns3i5lqv71nnnjkc4ee032r1lh");
        try {
            Assert.assertEquals(driver.getTitle(), "Clifton Personal Page - SQ");
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    //@AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
