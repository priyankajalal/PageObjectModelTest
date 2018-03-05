package org.crm.qa.testcases;


import org.crm.qa.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CRmHomePageTest extends BaseClass{

    CrmLoginPage crmLoginPage;
    CrmHomePage crmHomePage;
    CrmContactsPage crmContactsPage;
    TestUtil testUtil;

    public CRmHomePageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        crmLoginPage = new CrmLoginPage();
        crmHomePage = new CrmHomePage();
        crmHomePage = crmLoginPage.Login();
        testUtil = new TestUtil();
        testUtil.switchToFrame();
    }

    @Test
    public void TitleTest(){
        verifyTitle("CRMPRO");
    }

    @Test
    public void usernameLabelTest(){
        boolean flag = crmHomePage.usernameLabel();
        Assert.assertTrue(flag);
    }

    @Test
    public void clickContactsLinkTest(){
        crmContactsPage = crmHomePage.clickContactsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
