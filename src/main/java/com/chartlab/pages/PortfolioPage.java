package com.chartlab.pages;


import com.chartlab.controls.BaseControl;
import com.chartlab.controls.EditControl;
import com.chartlab.helper.Config;
import com.chartlab.helper.FindBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PortfolioPage extends BasePage{
    public PortfolioPage(WebDriver driver){
        super(driver);
    }

    @FindBy(locator="xpath=//a[text()='Portfolio']")
    public BaseControl portfolioTab;

    @FindBy(locator="xpath=//button[text()='Create Portfolio']")
    public BaseControl createPortfolioBtn;

    @FindBy(locator="xpath=//input[@id='watchlistNameEnter']")
    public EditControl watchlistName;

    @FindBy(locator="xpath=//button[text()='Add ']")
    public BaseControl addWatchlistBtn;

    @FindBy(locator="xpath=//input[@id='symbol']")
    public EditControl symbolInputBox;

    @FindBy(locator="xpath=//button[text()='Add Symbol']")
    public BaseControl addSymbolBtn;

    public void createPortfolio(String portfolioName) throws InterruptedException {
    createPortfolioBtn.isClickable();
    createPortfolioBtn.click();
    //getDriver().switchTo().alert();
    watchlistName.setText(portfolioName);
    addWatchlistBtn.click();
    }

    public void enterSymbol(String portfolioName,String symbol) throws InterruptedException {
        WebElement portfolio = getDriver().findElement(By.xpath("//ul[@id='tabNav']//li//a[text()='"+portfolioName+"']"));
      Thread.sleep(600);
//        WebDriverWait wait = new WebDriverWait(getDriver(), 50);
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//ul[@id='tabNav']//li//a[text()='"+portfolioName+"']")));
        portfolio.click();
        symbolInputBox.setText(symbol);
        symbolInputBox.setKeys(Keys.ENTER);
        addSymbolBtn.click();

    }

}
