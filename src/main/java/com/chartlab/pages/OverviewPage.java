package com.chartlab.pages;

import com.chartlab.controls.BaseControl;
import com.chartlab.helper.FindBy;
import org.openqa.selenium.WebDriver;

public class OverviewPage extends CommonPage {

    public OverviewPage(WebDriver driver){
        super(driver);
    }

    @FindBy(locator="xpath=//div[@class='container']//b")
    public BaseControl userLabel;

    public boolean isUserLabelDisplayed(){
        return userLabel.isDisplayed();
    }



}
