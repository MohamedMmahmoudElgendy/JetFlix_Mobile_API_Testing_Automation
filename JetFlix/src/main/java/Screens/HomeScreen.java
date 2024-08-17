package Screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends BaseScreen{

    public HomeScreen(AppiumDriver<?> appiumDriver) {
        super(appiumDriver);
    }
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]")
    WebElement MovieName;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Poster Image of Deadpool & Wolverine\"]")
    WebElement MovieItem;

    @FindBy(xpath = "//android.view.View[@content-desc=\"Filter & Sort Movies\"]")
    WebElement FilterIcon;

    public void checkFilterIconIsDisplayed(){
        waitElementToBeDisplayed(FilterIcon);
    }
    public void clickOnFilterIcon(){
        ClickOnWebElement(FilterIcon);
    }

    public void checkMovieNameIsDisplayed(){
    waitElementToBeDisplayed(MovieName);
}
    public void clickOnMovieItem(){
        ClickOnWebElement(MovieItem);
    }
    public String getMovieName(){
       return getText(MovieName);
    }


}
