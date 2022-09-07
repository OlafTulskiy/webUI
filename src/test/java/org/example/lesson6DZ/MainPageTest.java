package org.example.lesson6DZ;

import lesson6DZ.ApiPage;
import lesson6DZ.AppsPage;
import lesson6DZ.LoginPage;
import lesson6DZ.MainPage;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class MainPageTest extends AbstractTest{

    @Test
    public void loginLogoutTest() {
        MainPage tmp = new MainPage(getWebDriver());
        tmp.clickOnloginIn();
        new LoginPage(getWebDriver()).loginIn("m.dvoryankin@npo-pkrv.ru","123456");

        Assertions.assertEquals("https://developer.accuweather.com/home",driver.getCurrentUrl(),"Not this page");

        tmp.clickOnLogout();
    }

    @Test
    public void MainMenuNavigateTest() {
        MainPage tmp = new MainPage(getWebDriver());
        tmp.clickOnloginIn();
        new LoginPage(getWebDriver()).loginIn("m.dvoryankin@npo-pkrv.ru","123456");

        Assertions.assertEquals("https://developer.accuweather.com/home",driver.getCurrentUrl(),"Not this page");

        tmp.goToApi();
        tmp.goToDoc();
        tmp.GoToMyApps();
        tmp.goToFaq();
        tmp.goToPackage();
        tmp.clickOnLogout();
    }

    @Test
    public void AddNewApps() {
        MainPage tmp = new MainPage(getWebDriver());
        tmp.clickOnloginIn();
        new LoginPage(getWebDriver()).loginIn("m.dvoryankin@npo-pkrv.ru","123456");
        tmp.GoToMyApps();

        Assertions.assertEquals("https://developer.accuweather.com/user/me/apps",driver.getCurrentUrl(),"Not this page");

        AppsPage appsP = new AppsPage(getWebDriver());
        appsP.clickOnBtnAddApp();
        appsP.addApp("Text");
        tmp.clickOnLogout();
    }

    @Test
    public void DeleteApps() {
        MainPage tmp = new MainPage(getWebDriver());
        tmp.clickOnloginIn();
        new LoginPage(getWebDriver()).loginIn("m.dvoryankin@npo-pkrv.ru","123456");
        tmp.GoToMyApps();

        Assertions.assertEquals("Test",driver.findElement(By.xpath("//a [@href=\"#my-apps-collapse0\"]")).getText(),"Not this page");

        new AppsPage(getWebDriver()).deleteApp();
        tmp.clickOnLogout();
    }

    @Test
    public void NavigateOnApipage() {
        MainPage tmp = new MainPage(getWebDriver());
        tmp.clickOnloginIn();
        new LoginPage(getWebDriver()).loginIn("m.dvoryankin@npo-pkrv.ru","123456");
        tmp.goToApi();

        Assertions.assertEquals("https://developer.accuweather.com/accuweather-locations-api/apis",driver.getCurrentUrl(),"Not this page");

        ApiPage ap = new ApiPage(getWebDriver());
        ap.clickOnLocApi();
        ap.clickOnForCastApi();
        tmp.clickOnLogout();

    }










}
