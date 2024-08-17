package MovieTests;

import Screens.FilterAndSortMovies;
import Screens.HomeScreen;
import Test.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC02_CheckThatReleasDateFilterInTheHomeScreenShouldBeTheDateInTheFuture extends BaseTest {
    @BeforeMethod
    public void intializer(){
        homeScreen = new HomeScreen(appiumDriver);
        filterAndSortMovies=new FilterAndSortMovies(appiumDriver);
    }
    @Test
public void CheckThatReleasDateFilterInTheHomeScreenShouldBeTheDateInTheFuture(){
    homeScreen.checkFilterIconIsDisplayed();
    homeScreen.clickOnFilterIcon();
    filterAndSortMovies.checkFilterAndSortMovieText();
    filterAndSortMovies.checkReleaseDateIsDisplayed();
    filterAndSortMovies.clickOnReleaseDate();
    filterAndSortMovies.checkCloseIconIsDisplayedAndClickOnIt();
    filterAndSortMovies.checkTheDateOfTheMovieInTheFuture();

}
}
