package com.chartlab.pages;


import org.openqa.selenium.WebDriver;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public WebDriver getDriver(){
        return driver;
    }
}
