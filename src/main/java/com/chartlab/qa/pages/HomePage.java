package com.chartlab.qa.pages;

import com.chartlab.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends TestBase {

    @FindBy(xpath = "//td[contains(text(),'User: Naveen K')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealsLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement tasksLink;

    //Initializing HomePage Objects:
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    public String verifyHomePage(){
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){
        return userNameLabel.isDisplayed();
    }

    public ContactsPage clickOnContactsLink(){
        contactsLink.click();
        return new ContactsPage();
    }

    public DealsPage clickOnDealsLink(){
        dealsLink.click();
        return new DealsPage();
    }

    public TasksPage clickOnTasksLink(){
        tasksLink.click();
        return new TasksPage();
    }
}
