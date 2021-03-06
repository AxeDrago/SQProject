import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
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
    private static JSONObject pageInfo, wIObject,wIObject1,wIObject2,eHObject,sKObject,sKObject1,sKObject2,sKObject3,sKObject4,sKObject5,lIObject,lIObject1,lIObject2,lIObject3;



    @BeforeClass
    public static void setUp() throws Exception {
       //driver = new FirefoxDriver();
       driver = new HtmlUnitDriver();
       baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com";
       //baseUrl = "http://127.0.0.1:8080";
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);


       //java
        pageInfo = parseJson();

        JSONArray workInformationArray = (JSONArray) pageInfo.get("work information");
        JSONArray educatioHistorynArray = (JSONArray) pageInfo.get("education history");
        JSONArray skillsInformationnArray = (JSONArray) pageInfo.get("skillsInformation");
        JSONArray languageInformationArray = (JSONArray) pageInfo.get("languageInformation");

        wIObject = (JSONObject) workInformationArray.get(0);
        wIObject1 = (JSONObject) workInformationArray.get(1);
        wIObject2 = (JSONObject) workInformationArray.get(2);
        eHObject = (JSONObject) educatioHistorynArray.get(0);
        sKObject = (JSONObject) skillsInformationnArray.get(0);
        sKObject1 = (JSONObject) skillsInformationnArray.get(1);
        sKObject2 = (JSONObject) skillsInformationnArray.get(2);
        sKObject3 = (JSONObject) skillsInformationnArray.get(3);
        sKObject4 = (JSONObject) skillsInformationnArray.get(4);
        sKObject5 = (JSONObject) skillsInformationnArray.get(5);
        lIObject = (JSONObject) languageInformationArray.get(0);
        lIObject1 = (JSONObject) languageInformationArray.get(1);
        lIObject2 = (JSONObject) languageInformationArray.get(2);
        lIObject3 = (JSONObject) languageInformationArray.get(3);

        // System.out.print(edObject.get("areaName"));

        System.out.println(pageInfo);


    }

    private static JSONObject parseJson() {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try {

             jsonObject  = (JSONObject) parser.parse(new FileReader("src/main/javascript/json/cliftonPage.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

       return jsonObject;

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
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/h3")).getText(),pageInfo.get("name"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/p[1]")).getText(),pageInfo.get("profession"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[1]/p[2]")).getText(),pageInfo.get("country"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void contactInformation() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("//div[2]/p")).getText(), pageInfo.get("email"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p[2]")).getText(), pageInfo.get("github"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div/div/div/div[2]/p[3]")).getText(), pageInfo.get("twitter"));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }

    @Test
    public void contactInformationLink() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        driver.findElement(By.linkText(pageInfo.get("github").toString())).click();
        driver.findElement(By.linkText(pageInfo.get("twitter").toString())).click();
    }

    @Test
    public void workHistoryTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[1]")).getText(), wIObject.get("areaName"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[1]")).getText(), wIObject2.get("year"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/h4")).getText(), wIObject2.get("company"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/h4")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[1]/small")).getText(), wIObject2.get("position"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[1]/small")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[2]/small/span[1]")).getText(), wIObject2.get("duration"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[2]/small/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
            }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[2]/small/span[2]")).getText(), wIObject2.get("location"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[1]/p[2]/small/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[2]/p")).getText(), wIObject2.get("department"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[2]/li/div[2]/div[2]/p")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }


    }

    @Test
    public void workHistoryTest2() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[1]")).getText(), wIObject.get("areaName"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[1]")).getText(), wIObject1.get("year"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/h4")).getText(), wIObject1.get("company"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/h4")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[1]/small")).getText(), wIObject1.get("position"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[1]/small")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[2]/small/span[1]")).getText(), wIObject1.get("duration"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[2]/small/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[2]/small/span[2]")).getText(), wIObject1.get("location"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[1]/p[2]/small/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[2]/p")).getText(), wIObject1.get("department"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[1]/li/div[2]/div[2]/p")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void educationHistory() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[2]")).getText(), eHObject.get("areaName"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/h3[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
          }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[1]")).getText(), eHObject.get("year"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
          }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/h4")).getText(), eHObject.get("university"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/h4")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
          }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[1]/small")).getText(), eHObject.get("course"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[1]/small")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
           }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[2]/small/span[1]")).getText(), eHObject.get("duration"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[2]/small/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[2]/small/span[2]")).getText(), eHObject.get("location"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[1]/p[2]/small/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
          }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[2]/p")).getText(), eHObject.get("level"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/ul[3]/li/div[2]/div[2]/p")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void imageVerification() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/img")).isDisplayed());
    }

    @Test
    public void programingSkillsTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/h3[1]/span[2]")).getText(), sKObject.get("areaName"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/h3[1]/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
            }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[1]/span")).getText(), sKObject1.get("name"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[1]/span")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
            }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[1]/div/div/span")).getText(),driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[1]/div/div")).getText());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[1]/div/div/span")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[1]/div/div")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[2]/span")).getText(), sKObject2.get("name"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[2]/span")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[2]/div/div/span")).getText(),driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[2]/div/div")).getText());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[2]/div/div/span")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[2]/div/div")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[3]/span")).getText(), sKObject3.get("name"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[3]/span")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[3]/div/div/span")).getText(),driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[3]/div/div")).getText());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[3]/div/div/span")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[3]/div/div")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[4]/span")).getText(), sKObject4.get("name"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[4]/span")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[4]/div/div/span")).getText(),driver.findElement(By.xpath("//html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[4]/div/div")).getText());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[4]/div/div/span")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[4]/div/div")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[5]/span")).getText(), sKObject5.get("name"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[5]/span")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[5]/div/div/span")).getText(),driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[5]/div/div")).getText());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[5]/div/div/span")).isDisplayed());
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[1]/ul/li[5]/div/div")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }

    }
    @Test
    public void languageSkillTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/img")).isDisplayed());
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/h3[2]")).getText(), lIObject.get("areaName"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/h3[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/span[2]")).getText(), lIObject1.get("name"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/span[1]")).getText(), lIObject1.get("type"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[1]/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[2]/span[2]")).getText(), lIObject2.get("name"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[2]/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[2]/span[1]")).getText(), lIObject2.get("type"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[2]/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[3]/span[2]")).getText(), lIObject3.get("name"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[3]/span[2]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[3]/span[1]")).getText(), lIObject3.get("type"));
            assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div[2]/div[3]/ul/li[3]/span[1]")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void footerVerificationTest() throws Exception {
        driver.get(baseUrl);
        driver.findElement(By.xpath("//div[2]/div/a/div/div/img")).click();
        assertTrue(driver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/img")).isDisplayed());
        try {
            Assert.assertEquals(driver.findElement(By.xpath("/html/body/div[3]/div/div/div")).getText(), "Copyright © 2016 Team DCM - All rights reserved.");
            assertTrue(driver.findElement(By.xpath("/html/body/div[3]/div/div/div")).isDisplayed());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/a")).click();

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
