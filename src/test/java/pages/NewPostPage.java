package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
public class NewPostPage extends BasePage {


    public NewPostPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = "input[type='file']")
    WebElement fileInput;
    @FindBy(css = "[for='customSwitch2']")
    WebElement toggle;
    @FindBy(id = "create-post")
    WebElement submitButton;
    @FindBy(css = "[role='alertdialog'][aria-label='Creation of post failed!']")
    WebElement toastCreationPostFailed;
    @FindBy(css = "[role='alertdialog'][aria-label='Only files of type image allowed']")
    WebElement toastOnlyImagesAllowed;
    String newPost_URL = "http://training.skillo-bg.com:4200/posts/create";
    public void clickToggle() {
        wait.until((ExpectedConditions.visibilityOf(toggle)));
        toggle.click();
    }

    public void clickSubmitButton() {
        submitButton.click();
    }


    public void verifyCreationPostFailedMessageAppears() {
        wait.until(ExpectedConditions.visibilityOf(toastCreationPostFailed));
        String actualMessage = toastCreationPostFailed.getText();
        String expectedMessage = "Creation of post failed!";
        Assert.assertEquals(actualMessage, expectedMessage, "Not the correct error message");
    }

    public void verifyOnlyImagesAllowed() {
        wait.until(ExpectedConditions.urlToBe(newPost_URL));
        wait.until(ExpectedConditions.visibilityOf(toastOnlyImagesAllowed));
        String actualMessage = toastOnlyImagesAllowed.getText();
        String expectedMessage = "Only files of type image allowed";
        Assert.assertEquals(actualMessage, expectedMessage, "Not the correct error message");
    }

    public void verifyNewPostUrl() {
        wait.until(ExpectedConditions.urlToBe("http://training.skillo-bg.com:4200/posts/create"));
    }

    public void uploadFile(File file) {
        fileInput.sendKeys(file.getAbsolutePath());
    }
}



