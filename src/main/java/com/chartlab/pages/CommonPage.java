package com.chartlab.pages;

import com.chartlab.controls.BaseControl;
import com.chartlab.helper.FindBy;
import org.openqa.selenium.WebDriver;

public class CommonPage extends BasePage{
    @FindBy(locator="xpath=//a[text()='Charts']")
    public BaseControl chartsTab;


    public CommonPage(WebDriver driver){
        super(driver);
    }

    public  void clickChartTab(){
        chartsTab.click();

    }

}
