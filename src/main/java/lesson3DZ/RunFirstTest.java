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


public class RunFirstTest {

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

        //Thread.sleep(10000);
        //Пришлось опробовать 2 типа обращения и странно,что первый не сработал
        //а должен был, т.к. сделал точно как к кнопке login
        //первый вариант работал 1 раз через 6-7 попыток
        //в чем дело непонятно
        //WebElement webElementLogout = driver.findElement(By.xpath("//a [@href=\"/user/logout\"]"));
        WebElement webElementLogout = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/ul[1]/li[2]"));

        //Thread.sleep(10000);
        webElementLogout.click();

        //Thread.sleep(10000l);
        //Завершаем работу с ресурсом
        driver.quit();

    }
}
