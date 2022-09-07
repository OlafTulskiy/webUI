package lesson6DZ;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends AbstractPage{

    @FindBy(xpath = "//a [@href=\"/user/login\"]")
    private WebElement btnLogin;

    @FindBy(xpath = "//a [@href = \"/apis\"]")
    private WebElement btnApi;

    @FindBy(xpath = "//a [@href = \"/documentation\"]")
    private WebElement btnDoc;

    @FindBy(xpath = "//*[@id=\"navbar\"]/div/div/div/nav/ul[1]/li[3]/a")
    private WebElement btnMyApps;

    @FindBy(xpath = "//a [@href = \"/faq-page\"]")
    private WebElement btnFaq;

    @FindBy(xpath = "//a [@href = \"/packages\"]")
    private WebElement btnPackage;

    @FindBy(xpath = "//*[@id=\"navbar\"]/div/div[2]/nav/ul[1]/li[2]")
    private WebElement btnLogout;

    public MainPage(WebDriver driver){
        super(driver);

    }

    public void clickOnloginIn(){

        this.btnLogin.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }

    public void goToApi() {
        btnApi.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));
    }

    public void goToDoc() {
        btnDoc.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }

    public void GoToMyApps() {
        btnMyApps.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }

    public void goToFaq() {
        btnFaq.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }

    public void goToPackage() {
        btnPackage.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }

    public void clickOnLogout() {
        btnLogout.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }


}
