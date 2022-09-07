package lesson6DZ;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//input [@id = \"edit-name\"]")
    private WebElement iNputReg;

    @FindBy(xpath = "//input [@id = \"edit-pass\"]")
    private WebElement inputPass;

    @FindBy(xpath = "//button [@id = \"edit-submit\"]")
    private WebElement btnLogIn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginIn(String login, String password){

        Actions loginIn = new Actions(getDriver());
        loginIn
                .sendKeys(this.iNputReg,login)
                .click(this.inputPass)
                .sendKeys(password)
                .click(this.btnLogIn)
                .build()
                .perform();
    }




}
