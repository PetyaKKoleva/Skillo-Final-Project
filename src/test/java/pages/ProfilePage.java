package pages;

import org.bouncycastle.oer.Switch;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class ProfilePage extends BasePage {


    public ProfilePage(WebDriver driver) {
        super(driver);
    }

    Actions actions = new Actions(driver);

    @FindBy(css = "#following>strong")
    static WebElement followingUsers;

    @FindBy(className = "btn-private")
    WebElement privateSection;

    @FindBy(css = "div.post-img")
    WebElement uploadedPhoto;

    @FindBy(css = "div>.fa-lock")
    WebElement padlockLocked;

    @FindBy(css = "div>.fa-unlock")
    WebElement padlockUnlocked;

    @FindBy(css = "[role='alertdialog'][aria-label='Post is now private']")
    WebElement toastPrivate;
    @FindBy(css = "[role='alertdialog'][aria-label='Post is now public']")
    WebElement toastPublic;
    @FindBy(css = "[role='alertdialog'][aria-label='Post Deleted!']")
    WebElement toastDelete;
    @FindBy(css = "[role = 'alertdialog'][aria-label='Post liked']")
    WebElement toastLike;

    @FindBy(className = "btn-public")
    WebElement publicSection;

    @FindBy(className = "fa-plus-square")
    WebElement createNewPost;

    @FindBy(className = "post-user")
    WebElement user;

    @FindBy(css = ".fas.fa-trash-alt")
    WebElement binButton;

    @FindBy(xpath = "//div[@class='delete-confirm']//button[text()='Yes']")
    WebElement yesButton;

    @FindBy(xpath = "//div[@class='delete-confirm']//button[text()='No']")
    WebElement noButton;

    @FindBy(className = "delete-confirm")
    WebElement deleteConfirmation;

    @FindBy(css = "li>strong.profile-stat-count")
    WebElement postsCount;

    @FindBy(css = ".like.far")
    WebElement likeButton;

    @FindBy(css = ".like.far.liked")
    WebElement likeButtonClicked;

    @FindBy(css = ".fa-thumbs-down")
    WebElement dislikeButton;
    @FindBy(css = ".icons-container+div>div:first-child>strong")
    WebElement countLikes;

    @FindBy(css = "button.btn.btn-primary")
    WebElement unfollowButton;

    @FindBy(css = "modal-content")
    WebElement modal;


    public void verifyProfileUrl() {
        wait.until(ExpectedConditions.urlContains("/users"));
    }

    public void clickPrivateSection() {
        wait.until(ExpectedConditions.visibilityOf(privateSection));
        privateSection.click();
    }

    public void clickPublicSection() {
        wait.until(ExpectedConditions.elementToBeClickable(publicSection));
        publicSection.click();
    }

    public void verifyPhotoIsVisible() {
        Assert.assertTrue(uploadedPhoto.isDisplayed());
    }

    public void clickUploadedPhoto() {
        wait.until(ExpectedConditions.visibilityOf(uploadedPhoto));
        uploadedPhoto.click();
    }

    public void verifyDeleteNotification() {
        wait.until(ExpectedConditions.visibilityOf(toastDelete));
        String messageText = toastDelete.getText();
        System.out.println(messageText);
        Assert.assertEquals(messageText, "Post Deleted!", "The message is different from the expected for the private case");
    }

    public void clickDelete() {
        wait.until(ExpectedConditions.visibilityOf(binButton));
        binButton.click();
    }

    public void clickYesButton() {
        wait.until(ExpectedConditions.elementToBeClickable(yesButton));
        yesButton.click();
    }

    public void deleteConfirmationQuestionAppears() {
        Assert.assertTrue(deleteConfirmation.isDisplayed());
    }

    public int capturePostsCount() {
        String postCountText = postsCount.getText();
        return Integer.parseInt(postCountText);
    }

    public void clickLikeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(likeButton));
        likeButton.click();
    }

    public void clickUnlikeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(dislikeButton));
        dislikeButton.click();
    }

    public void verifyLikeButtonNotClicked() {
        try {
            wait.until(ExpectedConditions.invisibilityOf(likeButtonClicked));
        } catch (TimeoutException e) {
            Assert.fail("Like button is still clicked when it should be unclicked!");
        }
    }

    public int obtainFollowingUsers() {
        wait.until(ExpectedConditions.visibilityOf(followingUsers));
        String followedUsers = followingUsers.getText();
        return Integer.parseInt(followedUsers);
    }

    public void clickFollowingSection() {
        wait.until(ExpectedConditions.visibilityOf(followingUsers));
        clickOnElement(followingUsers);
    }

    public void clickUnfollowButton() {
        wait.until(ExpectedConditions.visibilityOf(unfollowButton));
        clickOnElement(unfollowButton);
    }

    public void closeModal() {
        actions.sendKeys(Keys.ESCAPE).build().perform();
        wait.until(ExpectedConditions.invisibilityOf(modal));
    }


}








