package org.example.lesson5DZ;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DZ5Test {

    static WebDriver driver;

    @BeforeAll
    static void init(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://developer.accuweather.com/");
        WebElement webElementLogin = driver.findElement(By.xpath("//a [@href=\"/user/login\"]"));
        webElementLogin.click();

        WebElement webElementINputReg = driver.findElement(By.xpath("//input [@id = \"edit-name\"]"));
        webElementINputReg.sendKeys("m.dvoryankin@npo-pkrv.ru");

        WebElement webElementInputPass = driver.findElement(By.xpath("//input [@id = \"edit-pass\"]"));
        webElementInputPass.sendKeys("123456");

        WebElement webElementBtnLogIn = driver.findElement(By.xpath("//button [@id = \"edit-submit\"]"));
        webElementBtnLogIn.click();
    }



    @Test
    void Test1() throws InterruptedException {
        //просто проверяем регистрацию и выход - logout
        //а они уместились в блоках "BeforeEach" и "AfterAll"
        Assertions.assertEquals("https://developer.accuweather.com/home",driver.getCurrentUrl(),"Not this page");
    }

    @Test
    void Test2() {

        Assertions.assertEquals("https://developer.accuweather.com/home",driver.getCurrentUrl(),"Not this page");

        WebElement webElementBtnApi = driver.findElement(By.xpath("//a [@href = \"/apis\"]"));
        webElementBtnApi.click();

        WebElement webElementBtnDoc = driver.findElement(By.xpath("//a [@href = \"/documentation\"]"));
        webElementBtnDoc.click();

        WebElement webElementBtnMyApps = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/nav/ul[1]/li[3]/a"));
        webElementBtnMyApps.click();

        WebElement webElementBtnFaq = driver.findElement(By.xpath("//a [@href = \"/faq-page\"]"));
        webElementBtnFaq.click();

        WebElement webElementBtnPackages = driver.findElement(By.xpath("//a [@href = \"/packages\"]"));
        webElementBtnPackages.click();


    }

    @Test
    void Test3() {

        WebElement webElementBtnMyApps = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/nav/ul[1]/li[3]/a"));
        webElementBtnMyApps.click();

        Assertions.assertEquals("https://developer.accuweather.com/user/me/apps",driver.getCurrentUrl(),"Not this page");

        WebElement webElementBtnAddApps = driver.findElement(By.xpath("//div [@class=\"add-app-button pull-right\"]"));
        webElementBtnAddApps.click();

        WebElement webElementInputAppName = driver.findElement(By.xpath("//input [@class=\"form-control form-text required machine-name-source\"]"));
        webElementInputAppName.sendKeys("Test");

        WebElement webElementCheckBoxWeatherApi = driver.findElement(By.xpath("//input [@id=\"edit-attribute-create-with-api-weatherapp\"]"));
        webElementCheckBoxWeatherApi.click();

        WebElement webElementBtnCreateApp = driver.findElement(By.xpath("//button [@class=\"btn btn-success form-submit\"]"));
        webElementBtnCreateApp.click();
    }

    @Test
    void Test4() {
        WebElement webElementBtnMyApps = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div/div/nav/ul[1]/li[3]/a"));
        webElementBtnMyApps.click();

        Assertions.assertEquals("Test",driver.findElement(By.xpath("//a [@href=\"#my-apps-collapse0\"]")).getText(),"Not this page");

        WebElement webElementRecordOfApp = driver.findElement(By.xpath("//a [@href=\"#my-apps-collapse0\"]"));
        webElementRecordOfApp.click();

        WebElement webElementBtnDeleteApp = driver.findElement(By.xpath("//li [@class=\"hidden-xs apigee-modal-link-delete\"]"));
        webElementBtnDeleteApp.click();

        WebElement webElementBtnSubmitDelete = driver.findElement(By.xpath("//button [@class=\"btn btn-danger form-submit icon-before\"]"));
        webElementBtnSubmitDelete.click();
    }

    @Test
    void Test5() {
        WebElement webElementBtnApi = driver.findElement(By.xpath("//a [@href = \"/apis\"]"));
        webElementBtnApi.click();

        WebElement webElementBtnLocApi = driver.findElement(By.xpath("//a [@href = \"/accuweather-locations-api/apis\"]"));
        webElementBtnLocApi.click();

        Assertions.assertEquals("https://developer.accuweather.com/accuweather-locations-api/apis",driver.getCurrentUrl(),"Not this page");

    }

    @Test
    void Test6() {
        WebElement webElementBtnApi = driver.findElement(By.xpath("//a [@href = \"/apis\"]"));
        webElementBtnApi.click();

        WebElement webElementBtnForCastApi = driver.findElement(By.xpath("//a [@href = \"/accuweather-forecast-api/apis\"]"));
        webElementBtnForCastApi.click();

        Assertions.assertEquals("https://developer.accuweather.com/accuweather-forecast-api/apis",driver.getCurrentUrl(),"Not this page");

    }

    @AfterAll
    static void close(){
        WebElement webElementLogout = driver.findElement(By.xpath("//*[@id=\"navbar\"]/div/div[2]/nav/ul[1]/li[2]"));
        webElementLogout.click();
        driver.quit();
    }
}
