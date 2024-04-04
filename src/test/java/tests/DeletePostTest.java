package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;

public class DeletePostTest extends BaseTest {

    @Test
    public void DeletePostTest() {
        System.out.println("1.Go to HomePage and login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("camila", "ass646IKMnaz");
        System.out.println("2.Navigate to the Profile section");
        HeaderContainer headerContainer = new HeaderContainer(driver);
        headerContainer.navigateToProfileSection();
        System.out.println("3.Capture the posts count");
        ProfilePage profilePage = new ProfilePage(driver);
        int initialPostsCount = profilePage.capturePostsCount();
        System.out.println("4.Click on 'New post' icon");
        headerContainer.navigateToNewPostLink();
        System.out.println("5.Click the Browse button to upload a photo");
        File fileToUpload = new File("src/test/java/resources/uploads/deletePost.png");
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.uploadFile(fileToUpload);
        System.out.println("6.Toggle the private option under the uploaded photo");
        newPostPage.clickToggle();
        System.out.println("7.Click 'Submit' button");
        newPostPage.clickSubmitButton();
        System.out.println("8.Click on the already created post and confirm that the photo is visible");
        profilePage.clickPrivateSection();
        profilePage.verifyPhotoIsVisible();
        profilePage.clickUploadedPhoto();
        System.out.println("9.Select 'Delete post' option");
        profilePage.clickDelete();
        System.out.println("10.Verify that 'Are you sure?' confirmation message appears");
        profilePage.deleteConfirmationQuestionAppears();
        System.out.println("11.Select 'Yes' option");
        profilePage.clickYesButton();
        System.out.println("12.Confirm that there is a confirmation message that the photo is successfully deleted");
        profilePage.verifyDeleteNotification();
        System.out.println("13.Verify that the posts count has decreased");
        int updatedPostCount = profilePage.capturePostsCount();
        Assert.assertTrue(updatedPostCount < initialPostsCount, "The post count remains the same; there is no decrease in the number of posts!");

    }
}
