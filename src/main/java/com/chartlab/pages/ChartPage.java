package com.chartlab.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.chartlab.controls.BaseControl;
import com.chartlab.controls.EditControl;
import com.chartlab.helper.FindBy;
import org.openqa.selenium.interactions.Actions;

public class ChartPage extends CommonPage {

    public ChartPage(WebDriver driver){
        super(driver);
    }

    @FindBy(locator="xpath=//input[@name = 'chartViewSymbolSearch']")
    public EditControl symbolSearchInputBox;

    @FindBy(locator="xpath=//span[@class='overview synopsis_Symbol']")
    public BaseControl symbolNameOnRight;

    @FindBy(locator="xpath=//div[@id='symbolLivePrice_MyChart']")
    public BaseControl symbolNameOnMiddle;

    public String verifySymbolSearchInputBox(){
        //chartsTab.click();
        symbolSearchInputBox.exists();
        String textFound = symbolSearchInputBox.getAttribute();
        return textFound;
    }

    public String verifySymbolNameOnMiddle(){
        return symbolNameOnMiddle.getText();
    }

    public String verifySymbolNameOnRight(){
        return symbolNameOnRight.getText();
    }

    public void enterSymbol(String symbol){
        symbolSearchInputBox.setText(symbol);
        symbolSearchInputBox.setKeys(Keys.TAB);
    }

//    public String[] getSymbolData(){
//        String[] data = symbolNameOnMiddle.getText().split(" ");;
//        String symbol = data[0];
//        String name = data[1];
//        return data;
//
//    }
}
