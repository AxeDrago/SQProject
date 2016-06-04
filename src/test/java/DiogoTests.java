import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by Diogo on 26/05/2016.
 */
public class DiogoTests {

    private static boolean local = false;
    private static WebDriver driver;
    private static String baseUrl;
    private static StringBuffer verificationErrors = new StringBuffer();
    private static JSONObject pageInfo;


    @BeforeClass
    public static void  setUp() throws Exception {
        driver = new HtmlUnitDriver(true) {
            @Override
            protected WebClient newWebClient(BrowserVersion version) {
                WebClient webClient = super.newWebClient(version);
                webClient.getOptions().setThrowExceptionOnScriptError(false);
                return webClient;
            }
        };
        if(local){
            baseUrl = "http://localhost:8080";
        }else{
            baseUrl = "http://stagingserverqs.westeurope.cloudapp.azure.com";
        }

        pageInfo = parseJson();


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private static JSONObject parseJson() {
        JSONParser parser = new JSONParser();

        JSONObject jsonObject = null;

        try {

            jsonObject  = (JSONObject) parser.parse(new FileReader("src/main/javascript/json/diogoPageInfo.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return jsonObject;
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
        assertTrue("Element for email isn't show",driver.findElement(By.xpath("//span[@id='email']")).isDisplayed());
        assertEquals(pageInfo.get("email"), driver.findElement(By.xpath("//span[@id='email']")).getText());
    }

    @Test
    public void testPersonalPageLinkGithubExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for github isn't show",driver.findElement(By.xpath("//a[@id='github']")).isDisplayed());
        assertEquals(pageInfo.get("github"), driver.findElement(By.xpath("//a[@id='github']")).getText());
    }

    @Test
    public void testPersonalPageLinkGithubWorks() throws Exception{

        String firstTab = driver.getWindowHandle();

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for github isn't show",driver.findElement(By.xpath("//a[@id='github']")).isDisplayed());
        assertEquals(pageInfo.get("github"), driver.findElement(By.xpath("//a[@id='github']")).getText());

        driver.findElement(By.xpath("//a[@id='github']")).click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        if(firstTab.equals(tabs.get(0))){
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
        assertTrue("Element for LinkedIn isn't show",driver.findElement(By.xpath("//a[@id='twitter']")).isDisplayed());
        assertEquals(pageInfo.get("twitter"), driver.findElement(By.xpath("//a[@id='twitter']")).getText());
    }


    @Test
    public void testPersonalPageLinkTwitterWorks() throws Exception{

        String firstTab = driver.getWindowHandle();

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for LinkedIn isn't show",driver.findElement(By.xpath("//a[@id='twitter']")).isDisplayed());
        assertEquals(pageInfo.get("twitter"), driver.findElement(By.xpath("//a[@id='twitter']")).getText());

        driver.findElement(By.xpath("//a[@id='twitter']")).click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        if(tabs.get(0).equals(firstTab)){
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
        assertTrue("Element for CV isn't show",driver.findElement(By.xpath("//a[@id='cv']")).isDisplayed());
        assertEquals(pageInfo.get("cv"), driver.findElement(By.xpath("//a[@id='cv']")).getText());
    }


    @Test
    public void testPersonalPageLinkCVWorks() throws Exception {

        String firstTab = driver.getWindowHandle();

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for CV isn't show",driver.findElement(By.xpath("//a[@id='cv']")).isDisplayed());
        assertEquals(pageInfo.get("cv"), driver.findElement(By.xpath("//a[@id='cv']")).getText());

        driver.findElement(By.xpath("//a[@id='cv']")).click();

        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        if(tabs.get(0).equals(firstTab)){
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

    @Test
    public void testPersonalPageEducationHistoryExists() throws Exception{

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Header for education history isn't working",driver.findElement(By.xpath("//p[@id='edu_history']")).isDisplayed());
        JSONArray educationArray = (JSONArray) pageInfo.get("educationInformation");
        JSONObject edObject = (JSONObject) educationArray.get(0);
        assertEquals(edObject.get("areaName"), driver.findElement(By.xpath("//p[@id='edu_history']")).getText());
    }

    @Test
    public void testPersonalPageEducationHistoryElementsNumber() throws Exception{

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        if(driver.findElement(By.xpath("//p[@id='edu_history']")).isDisplayed()){
            JSONArray educationArray = (JSONArray) pageInfo.get("educationInformation");
            assertEquals("Real: " + driver.findElements(By.xpath("//div[@id='education']/ul/li")).size() , educationArray.size(), driver.findElements(By.xpath("//div[@id='education']/ul/li")).size());
        }
    }


    @Test
    public void testPersonalPageEducationHistoryElementInformation() throws Exception{

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        JSONArray educationArray = (JSONArray) pageInfo.get("educationInformation");
        if(driver.findElement(By.xpath("//p[@id='edu_history']")).isDisplayed() && driver.findElements(By.xpath("//div[@id='education']/ul/li")).size() == educationArray.size() ){
            JSONObject edObject = (JSONObject) educationArray.get(0);
            //Ano Elemento
            assertEquals(edObject.get("year"), driver.findElement(By.xpath("//div[@id='education']/ul/li/div")).getText());
            //Instituto
            assertEquals(edObject.get("school"), driver.findElement(By.xpath("//div[@id='education']/ul/li/div[2]/div/h4")).getText());
            //Curso
            assertEquals(edObject.get("course"), driver.findElement(By.xpath("//div[@id='education']/ul/li/div[2]/div/p/small")).getText());
            //Data
            assertEquals(edObject.get("duration"), driver.findElement(By.xpath("//div[@id='education']/ul/li/div[2]/div/p[2]/small/small")).getText());
            //Location
            assertEquals(edObject.get("location"), driver.findElement(By.xpath("//div[@id='education']/ul/li/div[2]/div/p[2]/small/small[2]")).getText());
            //Nível
            assertEquals(edObject.get("level"), driver.findElement(By.xpath("//div[@id='education']/ul/li/div[2]/div[2]/p")).getText());

        }
    }

    @Test
    public void testPersonalPageProgrammingSkillsExists() throws Exception{

        JSONArray skillsArray = (JSONArray) pageInfo.get("skillsInformation");
        JSONObject skillObject = (JSONObject) skillsArray.get(0);
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Header for programming skills isn't working " + driver.findElement(By.xpath("//div[2]/div/h3/p")).getText() , driver.findElement(By.xpath("//div[2]/div/h3/p")).isDisplayed());
        assertEquals(skillObject.get("areaName"), driver.findElement(By.xpath("//div[2]/div/h3/p")).getText());
    }

    @Test
    public void testPersonalPageEducationProgrammingSkillsElementsNumber() throws Exception{

        JSONArray skillsArray = (JSONArray) pageInfo.get("skillsInformation");
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        if(driver.findElement(By.xpath("//div[2]/div/h3/p")).isDisplayed()){
            assertEquals( skillsArray.size() - 1, driver.findElements(By.xpath("//div[@id='skillsArea']/div/ul/li")).size());
        }
    }

    @Test
    public void testPersonalPageProgrammingSkillsInformation() throws Exception{

        JSONArray skillsArray = (JSONArray) pageInfo.get("skillsInformation");

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        if(driver.findElement(By.xpath("//div[2]/div/h3/p")).isDisplayed() && driver.findElements(By.xpath("//div[@id='skillsArea']/div/ul/li")).size() == skillsArray.size() - 1 ){
            //First Skill
            JSONObject skillObject1 = (JSONObject) skillsArray.get(1);
            assertEquals(skillObject1.get("name"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li/span")).getText());
            assertEquals(skillObject1.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li/div")).getText());
            assertEquals(skillObject1.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li/div/div/span")).getText());

            //Second Skill
            JSONObject skillObject2 = (JSONObject) skillsArray.get(2);
            assertEquals(skillObject2.get("name"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[2]/span")).getText());
            assertEquals(skillObject2.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[2]/div")).getText());
            assertEquals(skillObject2.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[2]/div/div/span")).getText());

            //Third Skill
            JSONObject skillObject3 = (JSONObject) skillsArray.get(3);
            assertEquals(skillObject3.get("name"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[3]/span")).getText());
            assertEquals(skillObject3.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[3]/div")).getText());
            assertEquals(skillObject3.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[3]/div/div/span")).getText());

            //Fourth Skill
            JSONObject skillObject4 = (JSONObject) skillsArray.get(4);
            assertEquals(skillObject4.get("name"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[4]/span")).getText());
            assertEquals(skillObject4.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[4]/div")).getText());
            assertEquals(skillObject4.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[4]/div/div/span")).getText());

            //Fifth Skill
            JSONObject skillObject5 = (JSONObject) skillsArray.get(5);
            assertEquals(skillObject5.get("name"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[5]/span")).getText());
            assertEquals(skillObject5.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[5]/div")).getText());
            assertEquals(skillObject5.get("percentage"), driver.findElement(By.xpath("//div[@id='skillsArea']/div/ul/li[5]/div/div/span")).getText());
        }
    }

    @Test
    public void testPersonalPageLanguageSkillsExists() throws Exception{

        JSONArray languageArray = (JSONArray) pageInfo.get("languageInformation");
        JSONObject languageObject = (JSONObject) languageArray.get(0);
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Header for language skills isn't working " + driver.findElement(By.xpath("//div[2]/h3/p")).getText() , driver.findElement(By.xpath("//div[2]/h3/p")).isDisplayed());
        assertEquals(languageObject.get("areaName"), driver.findElement(By.xpath("//div[2]/h3/p")).getText());

    }

    @Test
    public void testPersonalPageEducationLanguageSkillsElementsNumber() throws Exception{

        JSONArray languageArray = (JSONArray) pageInfo.get("languageInformation");
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        if(driver.findElement(By.xpath("//div[2]/h3/p")).isDisplayed()){
            assertEquals(languageArray.size() - 1, driver.findElements(By.xpath("//div[@id='languageArea']/div/ul/li")).size());
        }
    }

    @Test
    public void testPersonalPageLanguageSkillsInformation() throws Exception{


        JSONArray languageArray = (JSONArray) pageInfo.get("languageInformation");

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        if(driver.findElement(By.xpath("//div[2]/h3/p")).isDisplayed() && driver.findElements(By.xpath("//div[@id='languageArea']/div/ul/li")).size() == languageArray.size() - 1 ){

            //First Skill
            JSONObject languageObject = (JSONObject) languageArray.get(1);
            assertEquals(languageObject.get("name"), driver.findElement(By.xpath("//div[@id='languageArea']/div/ul/li/span[2]")).getText());
            assertEquals(languageObject.get("type"), driver.findElement(By.xpath("//div[@id='languageArea']/div/ul/li/span")).getText());

            //Second Skill
            JSONObject languageObject1 = (JSONObject) languageArray.get(2);
            assertEquals(languageObject1.get("name"), driver.findElement(By.xpath("//div[@id='languageArea']/div/ul/li[2]/span[2]")).getText());
            assertEquals(languageObject1.get("type"), driver.findElement(By.xpath("//div[@id='languageArea']/div/ul/li[2]/span")).getText());

        }
    }

    @Test
    public void testPersonalPageLinkHomeExists() throws Exception{
        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        assertTrue("Element for home isn't show",driver.findElement(By.xpath("//a[@id='teamHome']")).isDisplayed());
        assertEquals(pageInfo.get("teamName"), driver.findElement(By.xpath("//a[@id='teamHome']")).getText());
    }


    @Test
    public void testPersonalPageLinkHomeWorks() throws Exception{

        driver.get(baseUrl + "/");
        driver.findElement(By.xpath("//a/div")).click();
        if(driver.findElement(By.xpath("//a[@id='teamHome']")).isDisplayed()){
            driver.findElement(By.xpath("//a[@id='teamHome']")).click();
            assertEquals("SQ Project Pipeline", driver.getTitle());
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
