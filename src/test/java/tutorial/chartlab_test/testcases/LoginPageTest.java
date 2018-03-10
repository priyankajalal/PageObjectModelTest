package tutorial.chartlab_test.testcases;


import tutorial.chartlab_test.base.TestBase;
import tutorial.chartlab_test.pages.HomePage;
import tutorial.chartlab_test.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest(){
        super();
    }

    @BeforeMethod
    public void setUp(){
        initialization();
        //Could be written as: LoginPage LoginPage = new LoginPage();
        loginPage = new LoginPage();

    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title = TestBase.getTitle();
        Assert.assertEquals(title,"#1 Free CRM for Any Business: Online Customer Relationship Software");
    }

    @Test(priority = 2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCRMImage();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() throws InterruptedException {
        homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
