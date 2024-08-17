package MovieTests;

import Screens.HomeScreen;
import Screens.MovieDetails;
import Test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01_CheckTheMovieNameInHomeScreenTheSameInMovieScreen extends BaseTest {

    @BeforeMethod
    public void intializer(){
        homeScreen = new HomeScreen(appiumDriver);
        movieDetails =new MovieDetails(appiumDriver);
    }
    @Test
    public void CheckTheMovieNameInHomeScreenTheSameInMovieScreen(){
        homeScreen.checkMovieNameIsDisplayed();
        String movieNameInHomeScreen=homeScreen.getMovieName();
        homeScreen.clickOnMovieItem();
        movieDetails.checkMovieNameIsDisplayed();
        String movieNameInMovieDetails=movieDetails.getMovieName();
        Assert.assertEquals(movieNameInHomeScreen,movieNameInMovieDetails);
    }
}
