package com.chartlab.testcases;

import com.chartlab.helper.PageFactory;
import com.chartlab.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void Test() throws Exception {
        LoginPage LoginPage = PageFactory.init(driver, LoginPage.class);
        LoginPage.login();
    }
}
