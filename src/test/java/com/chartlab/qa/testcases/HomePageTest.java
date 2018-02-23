package com.chartlab.qa.testcases;


import com.chartlab.qa.base.TestBase;
import com.chartlab.qa.pages.ContactsPage;
import com.chartlab.qa.pages.HomePage;
import com.chartlab.qa.pages.LoginPage;
import com.chartlab.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.chartlab.qa.util.TestUtil;

public class HomePageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest(){

        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        testUtil = new TestUtil();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
    }

    //Best practice :
    //All tests should be seperated---independent with eachother.
    //Before each test -- launch the browser and login.
    //@Test -- excecute test case
    //After each test -- close the browser.

    @Test(priority = 1)
    public void verifyHomepageTitleTest(){
        String homePageTitle = homePage.verifyHomePage();
        //We can write a message with assertion which will be displayed at time of reporting if Test fails.
        Assert.assertEquals(homePageTitle,"CRMPRO","Home page title not matched");
    }

    @Test(priority = 2)
    public void verifyUserNameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority = 3)
    public void verifyContactsLinkTest(){
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
