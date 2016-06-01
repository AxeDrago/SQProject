
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
        //baseUrl = "http://127.0.0.1:8080";
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
    public void testHeaderStructure() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Rúben Personal Page - SQ".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.id("name")));
        assertTrue(isElementPresent(By.id("profession")));
        assertTrue(isElementPresent(By.id("country")));
        try {
            assertTrue(isElementPresent(By.id("name")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.id("profession")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.id("country")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testPersonal() throws Exception {
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
    }

    /*@Test
    public void testPersonalStructure() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        assertEquals("Name:", driver.findElement(By.cssSelector("h3")).getText());
        try {
            assertEquals("Name:", driver.findElement(By.cssSelector("h3")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Name:".equals(driver.findElement(By.cssSelector("h3")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Country:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[2]")).getText());
        assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[2]")));
        try {
            assertEquals("Country:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[2]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Country:".equals(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[2]")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[3]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Contacts:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[4]")).getText());
        assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[4]")));
        try {
            assertEquals("Contacts:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[4]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[4]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Contacts:".equals(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[4]")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[4]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("CV:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[5]")).getText());
        assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[5]")));
        try {
            assertEquals("CV:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[5]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[5]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("CV:".equals(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[5]")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[5]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Skills:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[6]")).getText());
        assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[6]")));
        try {
            assertEquals("Skills:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[6]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[6]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Skills:".equals(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[6]")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[6]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Social Media Link:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[7]")).getText());
        assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[7]")));
        try {
            assertEquals("Social Media Link:", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[7]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[7]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Social Media Link:".equals(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[7]")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[7]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertEquals("Professional Experience", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[8]")).getText());
        assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[8]")));
        try {
            assertEquals("Professional Experience", driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[8]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[8]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Professional Experience".equals(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[8]")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.xpath("//div[@id='description_wrapper']/h3[8]"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.id("image")));
        try {
            assertTrue(isElementPresent(By.id("image")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("image"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

    }*/

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