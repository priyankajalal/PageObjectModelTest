package com.chartlab.testcases;

import com.chartlab.Data.SymbolDataProvider;
import com.chartlab.pages.LoginPage;
import com.chartlab.pages.ChartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.chartlab.helper.Config;
import com.chartlab.helper.PageFactory;

import java.util.List;

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

    //@Test
    public void symbolSearchInputBoxTest() throws Exception {
        Assert.assertEquals(chartPage.verifySymbolSearchInputBox(),
                "MSFT","MSFT is not the default symbol.");
    }

    //@Test
    public void verifySymbolNameTest() throws Exception {
        System.out.println(chartPage.verifySymbolNameOnMiddle());
        Assert.assertTrue(chartPage.verifySymbolNameOnMiddle().
                contains(Config.get("defaultSymbol")));
        Assert.assertTrue(chartPage.verifySymbolNameOnRight().
                contains(Config.get("defaultSymbol")));
    }

   // @Test
    public void enterSymbolTest() throws Exception {
        chartPage.enterSymbol("AAPL");
    }
    @DataProvider//(name = "symboldata")
    public  Object[][] testData(){
        //return new Object[][] {{"Microsoft Corporation (MSFT)"},{"96.07"},{"1.64"},{"1.74%"}};
        Object[][] obj=new Object[1][1];
        obj[0][1]="Microsoft Corporation (MSFT)";
        //obj[0][2]= 96.07;
        //obj[0][3]= 1.64;
        //obj[0][4]="1.74%";
        return obj;
    }
    @Test(dataProvider = "testData")
    public void test1(String price){
        System.out.println(price);

    }
    @Test(dataProvider = "symboldata",dataProviderClass = SymbolDataProvider.class)
    public void verifySymbolData(String name,String price,String change,String per_change) throws Exception{
        List<String> data =chartPage.getSymbolData();

        Assert.assertEquals(data.get(0),price.trim());
        Assert.assertEquals(data.get(1),change.trim());
        Assert.assertEquals(data.get(2),per_change.trim());
        Assert.assertEquals(data.get(3),name.trim());
    }
}
