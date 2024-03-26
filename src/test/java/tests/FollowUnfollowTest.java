package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class FollowUnfollowTest extends BaseTest {

    @Test
    public void FollowUnfollow() {
        System.out.println("1.Navigate to base page URL");
        HeaderContainer headerContainer = new HeaderContainer(driver);
        headerContainer.goToHomePage();
        System.out.println("2.Click 'Login' and sign in");
        headerContainer.navigateToLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successfulLogin("camila", "ass646IKMnaz");
        System.out.println("3.Navigate to the Profile page and obtain the count of following users");
        headerContainer.navigateToProfileSection();
        ProfilePage profilePage = new ProfilePage(driver);
        int initialFollowingCount = profilePage.obtainFollowingUsers();
        profilePage.obtainFollowingUsers();
        System.out.println("4.Navigate to the Home page");
        headerContainer.goToHomePage();
        System.out.println("5.Click the Follow button above the last uploaded post");
        HomePage homePage = new HomePage(driver);
        homePage.clickFollowButton();
        System.out.println("6.Navigate to the Profile section again");
        headerContainer.navigateToProfileSection();
        System.out.println("7.Verify that the following users count has increased with 1");
        int increasedCount = profilePage.obtainFollowingUsers();
        Assert.assertTrue(initialFollowingCount < increasedCount, "The count of followed users is incorrect");
        System.out.println("8.Click on the 'Following' section");
        profilePage.clickFollowingSection();
        System.out.println("9.Click Unfollow button next to the user");
        profilePage.clickUnfollowButton();
        System.out.println("10.Close the modal window");
        profilePage.closeModal();
        System.out.println("11.Verify that the following users count has decreased with 1");
        int decreasedCount = profilePage.obtainFollowingUsers();
        Assert.assertEquals(decreasedCount, initialFollowingCount, "The count of followed users is incorrect");
    }
}
