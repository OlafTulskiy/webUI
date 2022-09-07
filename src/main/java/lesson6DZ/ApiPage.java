package lesson6DZ;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class ApiPage extends AbstractPage{

    @FindBy(xpath = "//a [@href = \"/accuweather-locations-api/apis\"]")
    private WebElement btnLocApi;

    @FindBy(xpath = "//a [@href = \"/accuweather-forecast-api/apis\"]")
    private WebElement btnForCastApi;

    public ApiPage(WebDriver driver){
        super(driver);

    }

    public void clickOnLocApi() {
        btnLocApi.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }

    public void clickOnForCastApi() {
        btnForCastApi.click();
        new WebDriverWait(getDriver(), 3).until(ExpectedConditions.urlContains("accuweather.com"));

    }
}
