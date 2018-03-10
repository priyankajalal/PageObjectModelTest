package com.chartlab.controls;

import com.chartlab.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class EditControl extends BaseControl {

    public EditControl(BasePage parent, By locator){
        super(parent,locator);
    }

    public void setText(String text){
        this.exists();
        this.getElement().clear();
        this.getElement().sendKeys(text);
    }

    public void setKeys(Keys k){
        this.exists();
        this.getElement().sendKeys(k);
    }
}


