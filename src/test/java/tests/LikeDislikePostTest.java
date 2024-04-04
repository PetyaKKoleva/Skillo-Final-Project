package tests;
import org.testng.annotations.Test;
import pages.HeaderContainer;
import pages.LoginPage;
import pages.NewPostPage;
import pages.ProfilePage;

import java.io.File;

public class LikeDislikePostTest extends BaseTest {


    @Test
    public void LikeDislikeTest() {
        System.out.println("1.Go to HomePage and login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("camila", "ass646IKMnaz");
        System.out.println("2.Click on 'New post' icon");
        HeaderContainer headerContainer = new HeaderContainer(driver);
        headerContainer.navigateToNewPostLink();
        System.out.println("3.Click the Browse button to upload a photo.");
        File fileToUpload = new File("src/test/java/resources/uploads/likeDislike.jpg");
        NewPostPage newPostPage = new NewPostPage(driver);
        newPostPage.uploadFile(fileToUpload);
        System.out.println("4.Toggle the private option under the uploaded photo");
        newPostPage.clickToggle();
        System.out.println("5.Click 'Submit' button");
        newPostPage.clickSubmitButton();
        System.out.println("6.Click on the private section");
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.clickPrivateSection();
        System.out.println("7.Click on the photo");
        profilePage.clickUploadedPhoto();
        System.out.println("8.Click the like button under the photo");
        profilePage.clickLikeButton();
        System.out.println("9.Click the unlike button");
        profilePage.clickUnlikeButton();
        System.out.println("10.Verify that the like button is no longer clicked");
        profilePage.verifyLikeButtonNotClicked();

    }

    }

