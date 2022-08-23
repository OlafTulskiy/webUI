package lesson3DZ;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RunFourTest {


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

        WebElement webElementRecordOfApp = driver.findElement(By.xpath("//a [@href=\"#my-apps-collapse0\"]"));
        webElementRecordOfApp.click();

        WebElement webElementBtnDeleteApp = driver.findElement(By.xpath("//li [@class=\"hidden-xs apigee-modal-link-delete\"]"));
        webElementBtnDeleteApp.click();

        WebElement webElementBtnSubmitDelete = driver.findElement(By.xpath("//button [@class=\"btn btn-danger form-submit icon-before\"]"));
        webElementBtnSubmitDelete.click();


        WebElement webElementLogout = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/ul[1]/li[2]"));
        webElementLogout.click();

       //Завершаем работу с ресурсом
        driver.quit();

    }
}
