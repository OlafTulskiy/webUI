package org.example.lesson6DZ;

import io.github.bonigarcia.wdm.WebDriverManager;
//import org.example.lesson7.MyWebDriverEventListener;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractTest {

    static WebDriver driver;
    @BeforeAll
    static void setDriver(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();


        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://developer.accuweather.com/");
    }

    @BeforeEach
    void initMainPage(){
        Assertions.assertDoesNotThrow( ()-> getWebDriver().navigate().to("https://developer.accuweather.com/"),
                "Страница не доступна");
        Assertions.assertTrue(true);

    }

    @AfterAll
    public static void exit(){

        if(driver !=null) driver.quit();
    }

    public WebDriver getWebDriver(){
        return this.driver;
    }
}
