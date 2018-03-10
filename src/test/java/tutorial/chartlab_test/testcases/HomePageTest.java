package tutorial.chartlab_test.testcases;


import tutorial.chartlab_test.base.TestBase;
import tutorial.chartlab_test.pages.ContactsPage;
import tutorial.chartlab_test.pages.HomePage;
import tutorial.chartlab_test.pages.LoginPage;
import tutorial.chartlab_test.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
        testUtil.switchToFrame();
    }

    //Best practice :
    //All tests should be seperated---independent with eachother.
    //Before each test -- launch the browser and login.
    //@Test -- excecute test case
    //After each test -- close the browser.

    @Test(priority = 1)
    public void verifyHomepageTitleTest(){
        String homePageTitle = homePage.getTitle();
        //We can write a message with assertion which will be displayed at time of reporting if Test fails.
        Assert.assertEquals(homePageTitle,"CRMPRO","Home page title not matched");
    }

    @Test(priority = 2,enabled = false)
    public void verifyUserNameTest()
    {

        Assert.assertTrue(homePage.verifyCorrectUserName());
    }

    @Test(priority = 3,enabled = false)
    public void verifyContactsLinkTest(){
        contactsPage = homePage.clickOnContactsLink();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
