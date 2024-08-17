package Screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MovieDetails extends BaseScreen{
    public MovieDetails(AppiumDriver<?> appiumDriver) {
        super(appiumDriver);
    }
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.widget.ScrollView/android.widget.TextView[1]")
    WebElement MovieName;

    public void checkMovieNameIsDisplayed(){
        waitElementToBeDisplayed(MovieName);
    }

    public String getMovieName(){
        return getText(MovieName);
    }
}
