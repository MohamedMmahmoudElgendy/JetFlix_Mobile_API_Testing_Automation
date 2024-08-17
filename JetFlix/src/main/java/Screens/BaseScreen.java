package Screens;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfAllElements;

public class BaseScreen {
    AppiumDriver<?> appiumDriver;
    WebDriverWait wait;

    public BaseScreen(AppiumDriver<?> appiumDriver){
        this.appiumDriver = appiumDriver;
        PageFactory.initElements(appiumDriver ,this);
        wait = new WebDriverWait(appiumDriver , 30);
    }


    public void waitElementsToBeDisplayed(List<WebElement> elements){
        wait.until(ExpectedConditions.and(visibilityOfAllElements(elements)));
    }

    public void waitElementToBeDisplayed(WebElement element){
        wait.until(ExpectedConditions.and(visibilityOf(element)));
    }

    public String getText(WebElement element) {
        return element.getText();

    }

    public void ClickOnWebElement(WebElement GenricElement) {
        try {
            GenricElement.click();
        } catch (Exception e) {
            WebElement newElement = wait.until(ExpectedConditions.elementToBeClickable(GenricElement));
            newElement.click();
        }
    }

}
