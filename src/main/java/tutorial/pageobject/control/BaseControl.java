package tutorial.pageobject.control;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tutorial.pageobject.pages.BasePage;
import tutorial.pageobject.helper.MyConfiguration;

public class BaseControl {

    private By locator;
    BasePage parent;

    public BaseControl(BasePage parent, By locator) {
        this.parent = parent;
        this.locator = locator;
    }

    public WebDriver getDriver() {
        return parent.getDriver();
    }

    public WebElement getElement() {

        return getDriver().findElement(locator);
    }


    public By getLocator() {
        return locator;
    }


    public boolean exist() {
        WebDriverWait wait = new WebDriverWait(getDriver(), MyConfiguration.TIME_OUT);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public boolean isClickable()  throws Exception{
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(getDriver(), MyConfiguration.TIME_OUT);
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void click() {
        Assert.assertTrue(exist(), "Unable to find element" + this.locator.toString());
        this.getElement().click();
    }

    public String getText() {

        return this.getElement().getText();
    }
    public boolean isDisplayed(){
        Assert.assertTrue(exist(), "Unable to find element" + this.locator.toString());
        return  this.getElement().isDisplayed();
    }


}
