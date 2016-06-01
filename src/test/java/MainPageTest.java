import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Ruben on 28/05/2016.
 */
public class MainPageTest {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @org.junit.Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com/";
        //baseUrl = "http://127.0.0.1";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testMainPage() throws Exception {
        driver.get(baseUrl + "/");
        assertEquals("SQ Project Pipeline", driver.getTitle());
        try {
            assertEquals("SQ Project Pipeline", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void ImageVerification() throws Exception {
        driver.get(baseUrl);
        TestCase.assertTrue(driver.findElement(By.xpath("/html/body/div/a[1]/div/img")).isDisplayed());
        TestCase.assertTrue(driver.findElement(By.xpath("/html/body/div/a[2]/div/img")).isDisplayed());
        TestCase.assertTrue(driver.findElement(By.xpath("/html/body/div/a[3]/div/img")).isDisplayed());

    }
    @Test
    public void Projects() throws Exception {
        driver.get(baseUrl + "/");
        assertEquals("Projects", driver.findElement(By.cssSelector("h3")).getText());
        try {
            assertEquals("Projects", driver.findElement(By.cssSelector("h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Projects".equals(driver.findElement(By.cssSelector("h3")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Software Quality", driver.findElement(By.cssSelector("li")).getText());
        assertEquals("Context Awareness Systems", driver.findElement(By.xpath("//li[2]")).getText());
        try {
            assertEquals("Software Quality", driver.findElement(By.cssSelector("li")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Context Awareness Systems", driver.findElement(By.xpath("//li[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Software Quality".equals(driver.findElement(By.cssSelector("li")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Context Awareness Systems".equals(driver.findElement(By.xpath("//li[2]")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

    }
    @org.junit.After
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
        } catch (org.openqa.selenium.NoSuchElementException e) {
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
            org.openqa.selenium.Alert alert = driver.switchTo().alert();
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
