import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

/**
 * Created by Diogo on 26/05/2016.
 */
public class DiogoTests {

    private static boolean local = true;
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









    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
