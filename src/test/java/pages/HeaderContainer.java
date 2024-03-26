package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HeaderContainer extends BasePage {
    public HeaderContainer(WebDriver driver) {
        super(driver);
    }

    public static final String home_url = "http://training.skillo-bg.com:4200";

    @FindBy(id = "nav-link-profile")
    WebElement profileLink;

    @FindBy(id = "nav-link-new-post")
    WebElement newPostLink;

    @FindBy(id = "nav-link-login")
    WebElement loginLink;
    @FindBy(css = "[role='alertdialog'][aria-label='Successful login!']")
    WebElement signInMessage;

    public void navigateToNewPostLink() {
        wait.until(ExpectedConditions.invisibilityOf(signInMessage));
        wait.until(ExpectedConditions.elementToBeClickable(newPostLink));
        clickOnElement(newPostLink);
    }


    public void navigateToProfileSection() {
        wait.until(ExpectedConditions.visibilityOf(profileLink));
        clickOnElement(profileLink);
    }

    public void navigateToLoginLink() {
        wait.until(ExpectedConditions.visibilityOf(loginLink));
        clickOnElement(loginLink);
    }

    public void goToHomePage() {
        driver.get(home_url);
    }

}

