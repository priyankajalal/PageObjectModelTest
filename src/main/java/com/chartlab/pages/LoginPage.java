package com.chartlab.pages;

import com.chartlab.controls.BaseControl;
import com.chartlab.helper.Config;
import com.chartlab.helper.FindBy;
import org.openqa.selenium.WebDriver;
import com.chartlab.controls.EditControl;

import java.io.IOException;


public class LoginPage extends BasePage {

    @FindBy(locator = "xpath=//input[@id='LoginForm_username']")
    public EditControl userName;

    @FindBy(locator = "xpath=//input[@id='LoginForm_password']")
    public EditControl pass;

    @FindBy(locator = "xpath=//input[@type='submit']")
    public BaseControl submitBtn;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() throws IOException {
        String url = Config.get("url");
        this.getDriver().get(url);
        userName.setText(Config.get("username"));
        pass.setText(Config.get("password"));
        submitBtn.click();

    }
}
