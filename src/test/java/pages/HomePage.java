package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    @FindBy(css = ".follow-buttons>button")
    WebElement followButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickFollowButton() {
        wait.until(ExpectedConditions.visibilityOf(followButton));
        wait.until(ExpectedConditions.elementToBeClickable(followButton));
        clickOnElement(followButton);
    }
}






