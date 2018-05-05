package com.chartlab.testcases;


import com.chartlab.helper.Config;
import com.chartlab.helper.PageFactory;
import com.chartlab.pages.LoginPage;
import com.chartlab.pages.PortfolioPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class PortfolioTest {

    WebDriver driver;
    PortfolioPage portfolioPage;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        LoginPage LoginPage = PageFactory.init(driver, LoginPage.class);
        LoginPage.login();
        portfolioPage = PageFactory.init(driver, PortfolioPage.class);
        portfolioPage.portfolioTab.click();
    }

    @Test
    public void createPortfolioTest() throws IOException, InterruptedException {
        portfolioPage.createPortfolio(Config.get("portfolioName"));
    }

    @Test
    public void enterSymbolTest() throws IOException, InterruptedException {

        portfolioPage.enterSymbol(Config.get("portfolioName"),Config.get("portfolioSymbol"));
    }
}
