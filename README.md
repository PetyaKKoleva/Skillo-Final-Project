# Skillo-Final-Project
This is my final Java Maven test automation project for Skillo, utilizing the TestNG framework and Selenium WebDriver. 
The project follows the Page Object Model design pattern and PageFactory.To execute the tests, simply run the command 'mvn clean test'.
In case of test failures, screenshots will be automatically saved in the 'Screenshots' directory for further analysis.
The project includes a suite containing five tests covering different functionalities:

1.Login Test: This is a negative scenario where the user attempts to sign in with invalid credentials.
2.Delete Post Test: This positive scenario involves the user uploading a post and subsequently deleting it.It will fail due to issue in the system.
3.Follow Unfollow Test: In this positive scenario, the user follows and then unfollows another user.
4Like Dislike Test: This scenario tests the like/dislike functionality. It will fail as the like and dislike buttons should not be clicked simultaneously, potentially indicating an issue in the system.
5.Upload Photo Test: This negative scenario tests the user's attempt to upload an invalid file type.


