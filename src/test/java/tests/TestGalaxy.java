package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GalaxyPage;
import pages.HomePage;

public class TestGalaxy {
    WebDriver driver;
    String PATH_DRIVER = "./src/test/resources/drivers/chromedriver.exe";
    String TYPE_DRIVER = "webdriver.chrome.driver";
    String URL = "https://www.demoblaze.com/index.html";
    HomePage homePage;
    GalaxyPage galaxyPage;

    @Before
    public void setUp(){
        System.setProperty(TYPE_DRIVER,PATH_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL);
        homePage = new HomePage(driver);
    }
    @Test
    public void testGalxyAgregadoACarito() throws InterruptedException {
         homePage.seleccionarMenuPhones();
         galaxyPage = new GalaxyPage(driver);
         homePage.seleccionarGalaxyS6();
         galaxyPage.addToCart();
         Assert.assertTrue(galaxyPage.explicitWaitToAlertIsPresentBoolean(driver,5));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(10000);
        driver.quit();
    }

}
