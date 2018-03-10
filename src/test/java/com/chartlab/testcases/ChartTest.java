package com.chartlab.testcases;


import com.chartlab.Data.SymbolData;
import com.chartlab.pages.LoginPage;
import com.chartlab.pages.ChartPage;
import com.chartlab.pages.OverviewPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.chartlab.helper.Config;
import com.chartlab.helper.PageFactory;

public class ChartTest {

    WebDriver driver;
    LoginPage loginPage ;
    ChartPage chartPage;
    @BeforeClass
    public void setUp() throws Exception{
        driver = new ChromeDriver();
        loginPage = PageFactory.init(driver, LoginPage.class);
        loginPage.login();
        chartPage = PageFactory.init(driver, ChartPage.class);
        chartPage.clickChartTab();
    }

    @Test
    public void symbolSearchInputBoxTest() throws Exception {
        Assert.assertEquals(chartPage.verifySymbolSearchInputBox(),
                "MSFT","MSFT is not the default symbol.");
    }

    @Test
    public void verifySymbolNameTest() throws Exception {
        System.out.println(chartPage.verifySymbolNameOnMiddle());
        Assert.assertTrue(chartPage.verifySymbolNameOnMiddle().
                contains(Config.get("defaultSymbol")));
        Assert.assertTrue(chartPage.verifySymbolNameOnRight().
                contains(Config.get("defaultSymbol")));
    }

    @Test
    public void enterSymbolTest() throws Exception {
       chartPage.enterSymbol("AAPL");
    }

//    @Test(dataProvider = "data",dataProviderClass = SymbolData.class)
//    public void verifySymbolData() throws Exception{
//        System.out.println(chartPage.getSymbolData());
//    }
}
