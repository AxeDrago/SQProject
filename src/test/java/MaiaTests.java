
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
        //baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com/";
        baseUrl = "http://127.0.0.1:8080";
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
            try { if ("Rúben Maia Personal Page".equals(driver.getTitle())) break; } catch (Exception e) {}
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
        assertEquals("Rúben Maia Personal Page", driver.getTitle());
        try {
            assertEquals("Rúben Maia Personal Page", driver.getTitle());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Rúben Maia Personal Page".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }
    }

    @Test
    public void testFooter() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Rúben Maia Personal Page".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.cssSelector("div.footer")));
        try {
            assertTrue(isElementPresent(By.cssSelector("div.col-md-12")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertEquals("Copyright © 2016 Team DCM - All rights reserved.", driver.findElement(By.cssSelector("div.col-md-12")).getText());
        try {
            assertEquals("Copyright © 2016 Team DCM - All rights reserved.", driver.findElement(By.cssSelector("div.col-md-12")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Copyright © 2016 Team DCM - All rights reserved.".equals(driver.findElement(By.cssSelector("div.col-md-12")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector("div.col-md-12"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

    }


    @Test
    public void testSocialTests() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Rúben Maia Personal Page".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.xpath("//p[@id='email']/i")));
        assertTrue(isElementPresent(By.xpath("//p[@id='github']/i")));
        assertEquals("", driver.findElement(By.xpath("//p[@id='linkedin']/i")).getText());
        assertTrue(isElementPresent(By.xpath("//p[@id='twitter']/i")));
        try {
            assertTrue(isElementPresent(By.xpath("//p[@id='email']/i")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//p[@id='github']/i")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//p[@id='linkedin']/i")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//p[@id='twitter']/i")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testLinks() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        try {
            assertEquals("linkedin.com/in/rubenmaia", driver.findElement(By.linkText("linkedin.com/in/rubenmaia")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("linkedin.com/in/rubenmaia")).click();
        driver.get(baseUrl + "/MaiaPersonal.html");
        try {
            assertEquals("@rbnmaia", driver.findElement(By.linkText("@rbnmaia")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("@rbnmaia")).click();
        driver.get(baseUrl + "/MaiaPersonal.html");
        try {
            assertEquals("@ruben_maia", driver.findElement(By.linkText("@ruben_maia")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.linkText("@ruben_maia")).click();
    }

    @Test
    public void testSectionHeaders() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Rúben Maia Personal Page".equals(driver.getTitle())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.id("work_history")));
        try {
            assertTrue(isElementPresent(By.id("work_history")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertTrue(isElementPresent(By.id("edu_history")));
        try {
            assertTrue(isElementPresent(By.id("edu_history")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertTrue(isElementPresent(By.id("skills")));
        try {
            assertTrue(isElementPresent(By.id("skills")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertTrue(isElementPresent(By.id("languages")));
        try {
            assertTrue(isElementPresent(By.id("languages")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testEducationStructure() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        assertTrue(isElementPresent(By.cssSelector("div.timeline-badge.info")));
        assertEquals("2010", driver.findElement(By.cssSelector("div.timeline-badge.info")).getText());
        assertTrue(isElementPresent(By.cssSelector("h4.timeline-title")));
        assertEquals("Instituto Politécnico de Leiria", driver.findElement(By.cssSelector("h4.timeline-title")).getText());
        assertTrue(isElementPresent(By.cssSelector("small.text-muted")));
        assertEquals("Technical Support", driver.findElement(By.cssSelector("small.text-muted")).getText());
        assertTrue(isElementPresent(By.xpath("//p[2]/small")));
        assertEquals("January 2010 - April 2010 | Leiria", driver.findElement(By.xpath("//p[2]/small")).getText());
        assertTrue(isElementPresent(By.cssSelector("div.timeline-body > p")));
        assertEquals("DEI - Technical support", driver.findElement(By.cssSelector("div.timeline-body > p")).getText());
        try {
            assertTrue(isElementPresent(By.cssSelector("div.timeline-badge.info")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("2010", driver.findElement(By.cssSelector("div.timeline-badge.info")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("h4.timeline-title")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Instituto Politécnico de Leiria", driver.findElement(By.cssSelector("h4.timeline-title")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("small.text-muted")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Technical Support", driver.findElement(By.cssSelector("small.text-muted")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//p[2]/small")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("January 2010 - April 2010 | Leiria", driver.findElement(By.xpath("//p[2]/small")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("div.timeline-body > p")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("DEI - Technical support", driver.findElement(By.cssSelector("div.timeline-body > p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testEducationSegment() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.id("edu_history"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.xpath("//ul[2]/li/div")));
        assertEquals("2010", driver.findElement(By.xpath("//ul[2]/li/div")).getText());
        assertTrue(isElementPresent(By.xpath("//ul[2]/li/div[2]/div/h4")));
        assertEquals("Instituto Politécnico de Leiria", driver.findElement(By.xpath("//ul[2]/li/div[2]/div/h4")).getText());
        assertTrue(isElementPresent(By.xpath("//ul[2]/li/div[2]/div/p/small")));
        assertEquals("BSc., Computer Engineering", driver.findElement(By.xpath("//ul[2]/li/div[2]/div/p/small")).getText());
        assertTrue(isElementPresent(By.xpath("//ul[2]/li/div[2]/div/p[2]/small")));
        assertEquals("2010-2015 | Leiria", driver.findElement(By.xpath("//ul[2]/li/div[2]/div/p[2]/small")).getText());
        assertTrue(isElementPresent(By.xpath("//ul[2]/li/div[2]/div[2]/p")));
        assertEquals("Bachelor Degree", driver.findElement(By.xpath("//ul[2]/li/div[2]/div[2]/p")).getText());
        try {
            assertTrue(isElementPresent(By.xpath("//ul[2]/li/div")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("2010", driver.findElement(By.xpath("//ul[2]/li/div")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//ul[2]/li/div[2]/div/h4")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Instituto Politécnico de Leiria", driver.findElement(By.xpath("//ul[2]/li/div[2]/div/h4")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//ul[2]/li/div[2]/div/p/small")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("BSc., Computer Engineering", driver.findElement(By.xpath("//ul[2]/li/div[2]/div/p/small")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//ul[2]/li/div[2]/div/p[2]/small")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("2010-2015 | Leiria", driver.findElement(By.xpath("//ul[2]/li/div[2]/div/p[2]/small")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//ul[2]/li/div[2]/div[2]/p")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertEquals("Bachelor Degree", driver.findElement(By.xpath("//ul[2]/li/div[2]/div[2]/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
    @Test
    public void testProfessionalStructure() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Programming Skills".equals(driver.findElement(By.id("skills")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector("div.col-md-4 > div.grid-block"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        try {
            assertTrue(isElementPresent(By.cssSelector("ul.list-unstyled.list-skills > li")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//li[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//li[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.xpath("//li[4]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertEquals("HTML", driver.findElement(By.cssSelector("span.caption-skill")).getText());
        assertEquals("100%", driver.findElement(By.cssSelector("div.progress-bar")).getText());
        assertEquals("100%", driver.findElement(By.cssSelector("div.progress-bar > span")).getText());
        assertEquals("CSS", driver.findElement(By.xpath("//li[2]/span")).getText());
        assertEquals("80%", driver.findElement(By.xpath("//li[2]/div/div/span")).getText());
        assertEquals("80%", driver.findElement(By.xpath("//li[2]/div/div")).getText());
        assertEquals("PHP", driver.findElement(By.xpath("//li[3]/span")).getText());
        assertEquals("75%", driver.findElement(By.xpath("//li[3]/div/div")).getText());
        assertEquals("75%", driver.findElement(By.xpath("//li[3]/div/div/span")).getText());
        assertEquals("ASP.NET", driver.findElement(By.xpath("//li[4]/span")).getText());
        assertEquals("90%", driver.findElement(By.xpath("//li[4]/div/div")).getText());
        assertEquals("90%", driver.findElement(By.xpath("//li[4]/div/div/span")).getText());
    }
    @Test
    public void testLanguageSkills() throws Exception {
        driver.get(baseUrl + "/MaiaPersonal.html");
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if ("Language Skills".equals(driver.findElement(By.id("languages")).getText())) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try { if (isElementPresent(By.cssSelector("div.col-md-4 > div.grid-block"))) break; } catch (Exception e) {}
            Thread.sleep(1000);
        }

        assertTrue(isElementPresent(By.xpath("//div[3]")));
        assertEquals("NativePortuguese FluentEnglish BasicFrench", driver.findElement(By.xpath("//div[3]")).getText());
        try {
            assertEquals("NativePortuguese FluentEnglish BasicFrench", driver.findElement(By.xpath("//div[3]")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            assertTrue(isElementPresent(By.cssSelector("ul.list-unstyled.list-strip > li")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertEquals("NativePortuguese", driver.findElement(By.cssSelector("ul.list-unstyled.list-strip > li")).getText());
        try {
            assertTrue(isElementPresent(By.xpath("//div[3]/ul/li[2]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertEquals("FluentEnglish", driver.findElement(By.xpath("//div[3]/ul/li[2]")).getText());
        try {
            assertTrue(isElementPresent(By.xpath("//div[3]/ul/li[3]")));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        assertEquals("BasicFrench", driver.findElement(By.xpath("//div[3]/ul/li[3]")).getText());
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