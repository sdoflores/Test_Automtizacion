package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BasePage {

    String TYPE_DRIVER = "webdriver.chrome.driver";
    String PATH_DRIVER = "./src/test/resources/drivers/chromedriver.exe";


    private WebDriver driver;


    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver chromeDriverConnection(){
        System.setProperty(TYPE_DRIVER,PATH_DRIVER);
        driver = new ChromeDriver();
        return driver;
    }

    public WebElement findElement (By locator){
        return driver.findElement(locator);
    }

    public List <WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    public String getText(WebElement element){
        return element.getText();
    }

    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public Boolean isDisplayed(By locator){
        try {
           return driver.findElement(locator).isDisplayed();
        }catch (Exception e){
            System.out.printf(e.getMessage());
            return false;
        }
    }

    public void visit (String url){
        driver.get(url);
    }

    public void explicitWaitElementToBeClickable (WebDriver driver,int time,By locator){
        try{
            WebDriverWait eWait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(time));
            eWait.until(ExpectedConditions.elementToBeClickable(locator));
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    public boolean explicitWaitToAlertIsPresentBoolean (WebDriver driver,int time){
        try{
            WebDriverWait eWait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(time));
            eWait.until(ExpectedConditions.alertIsPresent());
            return true;
        }catch (Exception e){
            System.out.printf(e.getMessage());
            return false;
        }
    }

    public void explicitWaitToAlertIsPresent (WebDriver driver,int time){
        try{
            WebDriverWait eWait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(time));
            eWait.until(ExpectedConditions.alertIsPresent());
        }catch (Exception e){
            System.out.printf(e.getMessage());
        }
    }

    public String getAlertText(WebDriver driver)  {
        Alert alert = driver.switchTo().alert();
        return alert.getText();
    }

}
