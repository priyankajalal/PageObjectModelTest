package com.chartlab.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.chartlab.controls.BaseControl;
import com.chartlab.controls.EditControl;
import com.chartlab.helper.FindBy;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        symbolSearchInputBox.setKeys(Keys.ENTER);
    }

    public List<String> getSymbolData(){
        String input = symbolNameOnMiddle.getText();

        Pattern p1 = Pattern.compile("(-?\\d{1,2})\\.(\\d{1,2}%?)");
        Matcher m1 = p1.matcher(input);

        List<String> symbolDetails = new ArrayList<String>();
        while(m1.find()){
            symbolDetails.add(m1.group().trim());
        }

        Pattern p2 = Pattern.compile("(\\D+)");
        Matcher m2 = p2.matcher(input);

        if(m2.find()){
            String name = m2.group().trim();
            symbolDetails.add(name);
            //System.out.println(name);
        }

        return symbolDetails;

    }
}
