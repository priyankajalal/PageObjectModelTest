package com.chartlab.controls;

import com.chartlab.pages.BasePage;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.chartlab.helper.Config;

import java.util.List;

public class BaseControl {
    private By locator;
    BasePage parent;

    public BaseControl(BasePage parent, By locator){
        this.parent = parent;
        this.locator = locator;
    }

    public WebDriver getDriver(){
        return parent.getDriver();
    }

    public By getLocator(){
        return locator;
    }

    public WebElement getElement(){
        return getDriver().findElement(locator);
    }

    public List<WebElement> getElements(){
        return getDriver().findElements(locator);
    }

    public boolean exists(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Config.TIME_OUT);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public boolean isClickable(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Config.TIME_OUT);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException ex) {
            return false;
        }
        return true;
    }

    public void click(){
        Assert.assertTrue(isClickable(), "Unable to find element" + this.locator.toString());
        this.getElement().click();
    }

    public String getText(){
        exists();
        return this.getElement().getText();
    }

    public String getAttribute(){
        return this.getElement().getAttribute("value");
    }

    public boolean isDisplayed(){
        Assert.assertTrue(exists(),"Unable to find Element" +this.locator.toString());
        return this.getElement().isDisplayed();
    }
}
