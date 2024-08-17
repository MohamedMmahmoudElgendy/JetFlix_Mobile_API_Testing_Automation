package Screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Calendar;

public class FilterAndSortMovies extends BaseScreen{

    public FilterAndSortMovies(AppiumDriver<?> appiumDriver) {
        super(appiumDriver);
    }

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View/android.widget.TextView")
    WebElement FilterAndSortMovieText;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.widget.ScrollView[2]/android.view.View[4]/android.widget.RadioButton")
    WebElement ReleaseDate;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[1]/android.widget.Button")
    WebElement CloseIcon;

    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[2]")
    WebElement DateOfTheMovie;

    public void checkFilterAndSortMovieText(){
        waitElementToBeDisplayed(FilterAndSortMovieText);
    }
    public void checkReleaseDateIsDisplayed(){
        waitElementToBeDisplayed(ReleaseDate);
    }
    public void clickOnReleaseDate(){
        ClickOnWebElement(ReleaseDate);
    }
    public void checkCloseIconIsDisplayedAndClickOnIt(){
        waitElementToBeDisplayed(CloseIcon);
        ClickOnWebElement(CloseIcon);
    }
    public void checkTheDateOfTheMovieInTheFuture(){
        waitElementToBeDisplayed(DateOfTheMovie);
        String dateString=getText(DateOfTheMovie);
        String Year = dateString.substring(0, 4);
        int movieYear = Integer.parseInt(Year);
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if(movieYear > currentYear)
        System.out.println("Movie Year is in The Future");
        else{
            System.out.println("Movie Year is NOT in The Future");
        }

    }

}
