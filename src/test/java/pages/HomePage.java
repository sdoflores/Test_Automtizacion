package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    //Variables
    private By opMenuPhones = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private By getOpMenuLaptops = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private By getOpMenuMonitors = By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private By linkSamsungGalaxyS6 = By.xpath("//a[text()='Samsung galaxy s6']");

    private WebDriver driver;

    public HomePage (WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public void seleccionarMenuPhones() throws InterruptedException {
        explicitWaitElementToBeClickable(driver,5,opMenuPhones);
        click(opMenuPhones);
    }
    public void seleccionarGalaxyS6() throws InterruptedException {
        explicitWaitElementToBeClickable(driver,5,linkSamsungGalaxyS6);
        click(linkSamsungGalaxyS6);
    }

}
