package lesson6DZ;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class AppsPage extends AbstractPage{

    @FindBy(xpath = "//a [@href = \"/apis\"]")
    private WebElement btnAddApps;

    @FindBy(xpath = "//a [@href = \"/documentation\"]")
    private WebElement inputAppName;

    @FindBy(xpath = "//*[@id=\"navbar\"]/div/div/div/nav/ul[1]/li[3]/a")
    private WebElement checkBoxWeatherApi;

    @FindBy(xpath = "//a [@href = \"/faq-page\"]")
    private WebElement btnCreateApp;

    @FindBy(xpath = "//a [@href=\"#my-apps-collapse0\"]")
    private WebElement recordOfApp;

    @FindBy(xpath = "//li [@class=\"hidden-xs apigee-modal-link-delete\"]")
    private WebElement btnDeleteApp;

    @FindBy(xpath = "//button [@class=\"btn btn-danger form-submit icon-before\"]")
    private WebElement btnSubmitDeleteApp;

    public AppsPage(WebDriver driver){
        super(driver);

    }

    public void clickOnBtnAddApp() {
        btnAddApps.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }
    public void addApp(String name) {
        Actions addApp = new Actions(getDriver());
        addApp
                .sendKeys(this.inputAppName,name)
                .click(this.checkBoxWeatherApi)
                .click(this.btnCreateApp)
                .build()
                .perform();

    }

    public void deleteApp() {
        recordOfApp.click();
        btnDeleteApp.click();
        btnSubmitDeleteApp.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("https://developer.accuweather.com/"));

    }
}
