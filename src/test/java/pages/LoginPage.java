package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public static final String login_URL = "http://training.skillo-bg.com:4200/users/login";

    @FindBy(id = "defaultLoginFormUsername")
    WebElement usernameField;

    @FindBy(id = "defaultLoginFormPassword")
    WebElement passwordField;

    @FindBy(id = "sign-in-button")
    WebElement signInButton;

    @FindBy(css = "form.form-container")
    WebElement signInForm;

    @FindBy(xpath = "//a[contains(text(), 'Register')]")
    WebElement registerLink;

    @FindBy(className = "toast-message")
    WebElement toastMessage;

    public void successfulLogin(String username, String password) {
        driver.get(login_URL);
        populateUsername(username);
        populatePassword(password);
        clickSignInButton();
    }


    public void getToastMessage(String expectedToastMessage) {
        wait.until(ExpectedConditions.visibilityOf(toastMessage));
        String actualToastMessage = toastMessage.getText();
        Assert.assertEquals(actualToastMessage, expectedToastMessage, "Toast message not as expected, actual is " + actualToastMessage);

    }

    public void populatePassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.sendKeys(password);
    }

    public void populateUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameField));
        usernameField.sendKeys(username);
    }

    public void clickSignInButton() {
        signInButton.click();
    }


    public void verifyLoginUrl() {
        wait.until(ExpectedConditions.urlToBe(login_URL));
    }

    public void verifyVisibilityOfSignInForm() {
        wait.until(ExpectedConditions.visibilityOf(signInForm));
    }

    public void verifyVisibilityOfRegisterLink() {
        wait.until(ExpectedConditions.visibilityOf(registerLink));
    }
}
