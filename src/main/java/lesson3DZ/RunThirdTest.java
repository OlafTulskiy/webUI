package lesson3DZ;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RunThirdTest {

    public static void startTest() throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://developer.accuweather.com/");

        WebElement webElementLogin = driver.findElement(By.xpath("//a [@href=\"/user/login\"]"));
        webElementLogin.click();

        WebElement webElementINputReg = driver.findElement(By.xpath("//input [@id = \"edit-name\"]"));
        webElementINputReg.sendKeys("m.dvoryankin@npo-pkrv.ru");

        WebElement webElementInputPass = driver.findElement(By.xpath("//input [@id = \"edit-pass\"]"));
        webElementInputPass.sendKeys("123456");

        WebElement webElementBtnLogIn = driver.findElement(By.xpath("//button [@id = \"edit-submit\"]"));
        webElementBtnLogIn.click();

        WebElement webElementBtnMyApps = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/nav/ul[1]/li[3]/a"));
        webElementBtnMyApps.click();

        WebElement webElementBtnAddApps = driver.findElement(By.xpath("//div [@class=\"add-app-button pull-right\"]"));
        webElementBtnAddApps.click();

        WebElement webElementInputAppName = driver.findElement(By.xpath("//input [@class=\"form-control form-text required machine-name-source\"]"));
        webElementInputAppName.sendKeys("Test");

        WebElement webElementCheckBoxWeatherApi = driver.findElement(By.xpath("//input [@id=\"edit-attribute-create-with-api-weatherapp\"]"));
        webElementCheckBoxWeatherApi.click();

        WebElement webElementBtnCreateApp = driver.findElement(By.xpath("//button [@class=\"btn btn-success form-submit\"]"));
        webElementBtnCreateApp.click();


        WebElement webElementLogout = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/ul[1]/li[2]"));
        webElementLogout.click();

        driver.quit();

    }
}
