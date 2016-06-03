import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by Diogo on 26/05/2016.
 */
public class DiogoTests {

    private static boolean local = false;
    private static WebDriver driver;
    private static String baseUrl;
    private static StringBuffer verificationErrors = new StringBuffer();


    @BeforeClass
    public static void  setUp() throws Exception {
        driver = new HtmlUnitDriver();
        if(local){
            baseUrl = "http://localhost:8080";
        }else{
            baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com";
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testHomeLinkCorrect() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.getTitle().matches(".*" + "Diogo" + ".*"));
    }

    @Test
    public void testHomeLinkIncorrect() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertFalse(driver.getTitle().matches(".*" + "Teste" + ".*"));

    }


    /*First Page Tests!!!!

    @Test
    public void testPersonalPageImage() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElements(By.id("image")).size() != 0);
    }

    @Test
    public void testPersonalPagePersonNameExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3")).isDisplayed());
        assertTrue(driver.findElement(By.id("name")).isDisplayed());
    }



    @Test
    public void testPersonalPagePersonNameIsCorrect() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3")).isDisplayed());
        assertTrue(driver.findElement(By.id("name")).isDisplayed());
        assertTrue(driver.findElement(By.id("name")).getText().matches("Diogo Lopes"));
    }



    @Test
    public void testPersonalPagePersonCountryExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[2]")).isDisplayed());
        assertTrue(driver.findElement(By.id("country")).isDisplayed());
    }



    @Test
    public void testPersonalPagePersonCountryIsCorrect() throws Exception {
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[2]")).isDisplayed());
        assertTrue(driver.findElement(By.id("country")).isDisplayed());
        assertTrue(driver.findElement(By.id("country")).getText().matches("Portugal"));
    }

    @Test
    public void testPersonalPagePersonAddressExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[3]")).isDisplayed());
        assertTrue(driver.findElement(By.id("address")).isDisplayed());
    }



    @Test
    public void testPersonalPagePersonAddressIsCorrect() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[3]")).isDisplayed());
        assertTrue(driver.findElement(By.id("address")).isDisplayed());
        assertTrue(driver.findElement(By.id("address")).getText().matches(".*" + "Portas" + ".*"));
    }


    @Test
    public void testPersonalPagePersonContactsExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[4]")).isDisplayed());
        assertTrue(driver.findElement(By.id("contacts")).isDisplayed());
        assertTrue(driver.findElement(By.id("mobile")).isDisplayed());
        assertTrue(driver.findElement(By.id("email")).isDisplayed());
    }



    @Test
    public void testPersonalPagePersonContactsMobileIsCorrect() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[4]")).isDisplayed());
        assertTrue(driver.findElement(By.id("contacts")).isDisplayed());
        assertTrue(driver.findElement(By.id("mobile")).getText().matches(".*" + "783" + ".*"));
    }

    @Test
    public void testPersonalPagePersonContactsEmailIsCorrect() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[4]")).isDisplayed());
        assertTrue(driver.findElement(By.id("contacts")).isDisplayed());
        assertTrue(driver.findElement(By.id("email")).getText().matches(".*" + "@" + ".* ||" + ".*" + "@" + ".*"));
    }


    @Test
    public void testPersonalPagePersonCurriculumExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[5]")).isDisplayed());
        assertTrue(driver.findElement(By.id("cv")).isDisplayed());
    }



    @Test
    public void testPersonalPagePersonCurriculumIsCorrect() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[5]")).isDisplayed());
        assertTrue(driver.findElement(By.id("cv")).isDisplayed());
        driver.findElement(By.id("cv")).click();
        assertTrue(driver.getTitle().matches(".*"+ "MEGA"+".*"));
    }


    @Test
    public void testPersonalPagePersonSkillsExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[6]")).isDisplayed());
        assertTrue(driver.findElement(By.id("skills")).isDisplayed());
    }

    @Test
    public void testPersonalPagePersonSocialMediaExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[7]")).isDisplayed());
        assertTrue(driver.findElement(By.id("socialM")).isDisplayed());
    }

    @Test
    public void testPersonalPagePersonSocialMediaFacebookIsWorking() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[7]")).isDisplayed());
        assertTrue(driver.findElement(By.id("socialM")).isDisplayed());
        driver.findElement(By.xpath("//a[contains(text(),'Facebook')]")).click();
        assertTrue(driver.getTitle().matches(".*"+"Diogo" + ".*" + "Bernardo" + ".*" + "Facebook" + ".*" ));
    }

    /*@Test
    public void testPersonalPagePersonSocialMediaLinkedInIsWorking() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[7]")).isDisplayed());
        assertTrue(driver.findElement(By.id("socialM")).isDisplayed());
        driver.findElement(By.xpath("//a[contains(text(),'LinkedIn')]")).click();
        assertTrue("" + driver.getTitle() ,driver.getTitle().matches(".*" + "LinkedIn" + ".*" ));
    }

    @Test
    public void testPersonalPagePersonSocialMediaTwitterIsWorking() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElement(By.xpath("//div[@id='description_wrapper']/h3[7]")).isDisplayed());
        assertTrue(driver.findElement(By.id("socialM")).isDisplayed());
        driver.findElement(By.xpath("//a[contains(text(),'Twitter')]")).click();
        assertTrue(driver.getTitle().matches(".*"+ "@DBernardoL" + ".*" + "Twitter" + ".*" ));
    }*/


    /*
    *Second Page Tests
    * */


    @Test
    public void testPersonalPageImage() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue(driver.findElements(By.xpath("//img[@alt='profile image']")).size() != 0);
    }

    @Test
    public void testPersonalPageNameExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element name isn't show",driver.findElement(By.xpath("//h3[@id='name']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//h3[@id='name']")).getText() + "Doesn't match Diogo" ,driver.findElement(By.xpath("//h3[@id='name']")).getText().matches(".*"+ "Diogo" + ".*"));
    }

    @Test
    public void testPersonalPageProfessionExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element profession isn't show",driver.findElement(By.xpath("//p[@id='profession']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='profession']")).getText() + "Doesn't match Software" ,driver.findElement(By.xpath("//p[@id='profession']")).getText().matches(".*"+ "Software" + ".*"));
    }

    @Test
    public void testPersonalPageCountryExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for country isn't show",driver.findElement(By.xpath("//p[2]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[2]")).getText() + "Doesn't match Portugal" ,driver.findElement(By.xpath("//p[2]")).getText().matches(".*"+ "Portugal" + ".*"));
    }

    @Test
    public void testPersonalPageEmailsExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for email isn't show",driver.findElement(By.xpath("//p[@id='email']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='email']")).getText() + " Doesn't have martins5 or martins9" ,driver.findElement(By.xpath("//p[@id='email']")).getText().matches(".*"+ "martins5" + ".*" + "martins9" + ".*"));
    }

    @Test
    public void testPersonalPageLinkGithubExists() throws Exception{


        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for github isn't show",driver.findElement(By.xpath("//p[@id='github']/a")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='github']/a")).getText() + " Doesn't have Github" ,driver.findElement(By.xpath("//p[@id='github']/a")).getText().matches("Github"));
    }

    @Test
    public void testPersonalPageLinkGithubWorks() throws Exception{

        String firstTab = driver.getWindowHandle();

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for github isn't show",driver.findElement(By.xpath("//p[@id='github']/a")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='github']/a")).getText() + " Doesn't have Github" ,driver.findElement(By.xpath("//p[@id='github']/a")).getText().matches("Github"));

        driver.findElement(By.xpath("//p[@id='github']/a")).click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        if(firstTab == tabs.get(0)){
            driver.switchTo().window(tabs.get(1));


            assertTrue( "Expected: AxeDrago (Diogo Lopes) || Reallity: " + driver.getTitle() + tabs ,driver.getTitle().matches(".*" + "AxeDrago" + ".*"));

            driver.close();
            driver.switchTo().window(tabs.get(0));
        }else{

            driver.switchTo().window(tabs.get(0));

            assertTrue( "Expected: AxeDrago (Diogo Lopes) || Reallity: " + driver.getTitle() + tabs ,driver.getTitle().matches(".*" + "AxeDrago" + ".*"));

            driver.close();
            driver.switchTo().window(tabs.get(1));
        }


    }

    @Test
    public void testPersonalPageLinkTwitterExists() throws Exception{

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for LinkedIn isn't show",driver.findElement(By.xpath("//p[@id='twitter']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='twitter']/a")).getText() + " Doesn't have Twitter" ,driver.findElement(By.xpath("//p[@id='twitter']/a")).getText().matches("Twitter"));
    }


    @Test
    public void testPersonalPageLinkTwitterWorks() throws Exception{

        String firstTab = driver.getWindowHandle();

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for LinkedIn isn't show",driver.findElement(By.xpath("//p[@id='twitter']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='twitter']/a")).getText() + " Doesn't have Twitter" ,driver.findElement(By.xpath("//p[@id='twitter']/a")).getText().matches("Twitter"));

        driver.findElement(By.xpath("//p[@id='twitter']/a")).click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        if(tabs.get(0) == firstTab){
            driver.switchTo().window(tabs.get(1));

            assertTrue( "Expected: @DBernardoL || Reallity: " + driver.getTitle() + tabs ,driver.getTitle().matches(".*" + "@DBernardoL" + ".*"));

            driver.close();
            driver.switchTo().window(tabs.get(0));
        }else{
            driver.switchTo().window(tabs.get(0));

            assertTrue( "Expected: @DBernardoL || Reallity: " + driver.getTitle() + tabs ,driver.getTitle().matches(".*" + "@DBernardoL" + ".*"));

            driver.close();
            driver.switchTo().window(tabs.get(1));
        }


    }

    @Test
    public void testPersonalPageLinkCVExists() throws Exception{

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for CV isn't show",driver.findElement(By.xpath("//p[@id='cv']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='cv']/a")).getText() + " Doesn't have CV" ,driver.findElement(By.xpath("//p[@id='cv']/a")).getText().matches(".*" + "CV" + ".*"));
    }


    @Test
    public void testPersonalPageLinkCVWorks() throws Exception {

        String firstTab = driver.getWindowHandle();

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for LinkedIn isn't show", driver.findElement(By.xpath("//p[@id='cv']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//p[@id='cv']/a")).getText() + " Doesn't have CV", driver.findElement(By.xpath("//p[@id='cv']")).getText().matches(".*" + "CV" + ".*"));

        driver.findElement(By.xpath("//p[@id='cv']/a")).click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        if(tabs.get(0) == firstTab){
            driver.switchTo().window(tabs.get(1));

            assertTrue("Expected: MEGA || Reallity: " + driver.getTitle() + tabs, driver.getTitle().matches(".*" + "MEGA" + ".*"));

            driver.close();
            driver.switchTo().window(tabs.get(0));
        }else {
            driver.switchTo().window(tabs.get(0));

            assertTrue("Expected: MEGA || Reallity: " + driver.getTitle() + tabs, driver.getTitle().matches(".*" + "MEGA" + ".*"));

            driver.close();
            driver.switchTo().window(tabs.get(1));
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
