package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GalaxyPage extends BasePage {
    private By btnAddToCart = By.xpath("//*[@id=\"tbodyid\"]/div[2]/div/a");
    private WebDriver driver;

    public GalaxyPage (WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public void addToCart () {
        explicitWaitElementToBeClickable(driver,5,btnAddToCart);
        click(btnAddToCart);
    }
    public String getTextAlert()  {
        //explicitWaitToAlertIsPresent(driver,10);
        return getAlertText(driver);
    }
}
