package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HeaderContainer;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider(name = "Unsuccessful login")
    public Object[][] loginData() {
        return new Object[][]{
                {"camila", "Incorrect password", "Ivalid password"},
                {"", "123456*", "UsernameOrEmail cannot be empty"},
                {"WrongUsername", "123456", "User not found"},
                {"camila", "", "Password cannot be empty"}
        };
    }

    @Test(dataProvider = "Unsuccessful login")
    public void LoginTest(String username, String password, String expectedToastMessage) {
        System.out.println("1.Navigate to base page URL");
        HeaderContainer headerContainer = new HeaderContainer(driver);
        headerContainer.goToHomePage();
        System.out.println("2.Click on login button in the header");
        headerContainer.navigateToLoginLink();
        System.out.println("3.Verify that the URL is the correct one");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginUrl();
        System.out.println("4.Verify that the 'Sign in' form is visible");
        loginPage.verifyVisibilityOfSignInForm();
        System.out.println("5.Verify that the 'Register' link is visible as well");
        loginPage.verifyVisibilityOfRegisterLink();
        System.out.println("6.Populate username");
        loginPage.populateUsername(username);
        System.out.println("7.Populate password");
        loginPage.populatePassword(password);
        System.out.println("8.Click 'Sign in' button");
        loginPage.clickSignInButton();
        System.out.println("9.Verify that correct error message appears");
        loginPage.getToastMessage(expectedToastMessage);
        System.out.println("10.Verify that the user is on the same URL");
        loginPage.verifyLoginUrl();
    }
}
