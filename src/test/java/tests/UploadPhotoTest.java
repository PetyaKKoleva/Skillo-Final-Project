package tests;

import org.testng.annotations.Test;
import pages.HeaderContainer;
import pages.LoginPage;
import pages.NewPostPage;

import java.io.File;

@Test
public class UploadPhotoTest extends BaseTest {
    public void UploadPhotoTestFunctionality() {
        System.out.println("1.Go to HomePage and login");
        HeaderContainer headerContainer = new HeaderContainer(driver);
        headerContainer.goToHomePage();
        headerContainer.navigateToLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("camila", "ass646IKMnaz");
        NewPostPage newPostPage = new NewPostPage(driver);
        System.out.println("2.Navigate to the New post section");
        headerContainer.navigateToNewPostLink();
        System.out.println("3.Verify that the user is on the correct URL");
        newPostPage.verifyNewPostUrl();
        System.out.println("4.Upload a file different from image");
        File fileToUpload = new File("src/test/java/resources/uploads/uploadPhotoNegative");
        newPostPage.uploadFile(fileToUpload);
        System.out.println("5.Verify that there is the correct error message");
        newPostPage.verifyOnlyImagesAllowed();
        System.out.println("6.Click the Submit button");
        newPostPage.clickSubmitButton();
        System.out.println("7.Verify that the correct error message appears");
        newPostPage.verifyCreationPostFailedMessageAppears();
    }
}
