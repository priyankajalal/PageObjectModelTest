package com.chartlab.testcases;


import com.chartlab.helper.PageFactory;
import com.chartlab.pages.LoginPage;
import com.chartlab.pages.OverviewPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OverviewTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
    }

    @Test
    public void userLabelTest() throws Exception {
        LoginPage LoginPage = PageFactory.init(driver, LoginPage.class);
        LoginPage.login();
        OverviewPage homePage = PageFactory.init(driver, OverviewPage.class);
        Assert.assertTrue(homePage.isUserLabelDisplayed());
    }


}
