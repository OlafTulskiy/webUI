package lesson3DZ;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class RunSecondTest {


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

        WebElement webElementBtnApi = driver.findElement(By.xpath("//a [@href = \"/apis\"]"));
        webElementBtnApi.click();

        WebElement webElementBtnDoc = driver.findElement(By.xpath("//a [@href = \"/documentation\"]"));
        webElementBtnDoc.click();

        //WebElement webElementBtnMyApps = driver.findElement(By.xpath("//a [@href = \"/user/me/apps\"]"));
        WebElement webElementBtnMyApps = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/nav/ul[1]/li[3]/a"));
        webElementBtnMyApps.click();

        WebElement webElementBtnFaq = driver.findElement(By.xpath("//a [@href = \"/faq-page\"]"));
        webElementBtnFaq.click();

        WebElement webElementBtnPackages = driver.findElement(By.xpath("//a [@href = \"/packages\"]"));
        webElementBtnPackages.click();

        WebElement webElementLogout = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/ul[1]/li[2]"));
        webElementLogout.click();

        //Завершаем работу с ресурсом
        driver.quit();

    }
}
