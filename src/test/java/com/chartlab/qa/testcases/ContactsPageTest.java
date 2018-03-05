package com.chartlab.qa.testcases;

import com.chartlab.qa.base.TestBase;
import com.chartlab.qa.pages.ContactsPage;
import com.chartlab.qa.pages.HomePage;
import com.chartlab.qa.pages.LoginPage;
import com.chartlab.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {

    public ContactsPageTest(){
        super();
    }

    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;
    String sheetName = "contacts";

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        contactsPage = new ContactsPage();
        testUtil = new TestUtil();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage = homePage.clickOnContactsLink();
    }


    @Test(priority = 1,enabled = false)
    public void verifyContactsLabelTest(){
        Assert.assertTrue(contactsPage.verifyContactsLabel(),"Contacts label is missing on the Page.");
    }

    @Test(priority = 2,enabled = false)
    public void selectContactsByNameTest(){
        contactsPage.selectContactsByName("David Burton");
        contactsPage.selectContactsByName("david huming");
    }

    @DataProvider(name = "ExcelData")
    //if name is not given to DataProvider we can write method name (getExcelTestData) to @Test.
    public Object[][] getExcelTestData(){
        Object data[][] = TestUtil.getTestData(sheetName);
        System.out.println(data);
        return data;
    }

    @Test(priority = 3,dataProvider = "ExcelData")
    public void createNewContactTest(String title, String firstName, String lastName, String company) {
        homePage.clickOnNewContactsLink();
        //contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
        contactsPage.createNewContact(title, firstName, lastName, company);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
