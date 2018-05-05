package tutorial.crm.testcases;

import tutorial.crm.BaseClass;
import tutorial.crm.CrmHomePage;
import tutorial.crm.CrmLoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CrmLoginPageTest extends BaseClass {

    CrmLoginPage crmLoginPage;
    CrmHomePage crmHomePage;

    public CrmLoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        crmLoginPage = new CrmLoginPage();
    }

    @Test
    public void crmLogoTest(){
        boolean flag = crmLoginPage.validateCrmLogo();
        Assert.assertTrue(flag);
    }

    @Test
    public void loginTest(){
        crmHomePage = crmLoginPage.Login();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
