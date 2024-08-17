package Test;

import Screens.FilterAndSortMovies;
import Screens.HomeScreen;
import Screens.MovieDetails;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    public HomeScreen homeScreen;
    public  MovieDetails movieDetails;
    public FilterAndSortMovies filterAndSortMovies;
    protected  AppiumDriver<?> appiumDriver;

    @BeforeSuite
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "ANDROID");
        desiredCapabilities.setCapability("platformVersion", "12");
        desiredCapabilities.setCapability("udid","R58M21MHALJ");
        desiredCapabilities.setCapability( "automationName", "Appium");
        desiredCapabilities.setCapability("appPackage","com.yasinkacmaz.jetflix.debug");
        desiredCapabilities.setCapability("appActivity","com.yasinkacmaz.jetflix.ui.main.MainActivity");

        appiumDriver = new AppiumDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),desiredCapabilities);
    }


    @AfterSuite
    public void tearDown(){
      appiumDriver.quit();
    }
}
