package tutorial.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import tutorial.pageobject.helper.MyPageFactory;
import tutorial.pageobject.pages.HomePage;
import tutorial.pageobject.pages.LoginPage;


public class PageObjectTest {
    WebDriver driver;

    @BeforeClass
    public void setUp() {

        driver = new ChromeDriver();
    }

    @Test
    public void test() throws Exception {
        LoginPage loginPage = MyPageFactory.init(driver, LoginPage.class);
        loginPage.login();
        HomePage homePage = MyPageFactory.init(driver, HomePage.class);
        Assert.assertTrue(homePage.isUserPanelDisplayed());
    }

}
