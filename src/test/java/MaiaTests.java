
/**
 * Created by Ruben on 27/05/2016.
 */


import java.lang.String;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.junit.Assert.fail;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class MaiaTests{
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        driver = new HtmlUnitDriver();
        baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com/";
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
    public void testEstruturaPersonal() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        assertEquals("Rúben Personal Page - SQ", driver.getTitle());
        try {
            assertEquals("Rúben Personal Page - SQ", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Rúben Personal Page - SQ".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("MEICM - STUDENT", driver.findElement(By.cssSelector("h1")).getText());
        try {
            assertEquals("MEICM - STUDENT", driver.findElement(By.cssSelector("h1")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("h1")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @After
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