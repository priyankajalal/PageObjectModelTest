package org.crm.qa;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmHomePage extends BaseClass{

    CrmContactsPage contactsPage;

    @FindBy(xpath = "//td[contains(text(),'Naveen K')]")
    WebElement userNameLabel;

    @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactsLink;

    @FindBy(xpath = "//a[text()='New Contact']")
    WebElement newContactLink;

    public CrmHomePage(){
        PageFactory.initElements(driver,this);
    }

    public boolean usernameLabel(){
       return userNameLabel.isDisplayed();
    }

    public CrmContactsPage clickContactsLink(){
        contactsLink.click();
        return new CrmContactsPage();
    }

    public void clickNewContactsLink(){
        Actions action = new Actions(driver);
        action.moveToElement(contactsLink).build().perform();
        newContactLink.click();
    }

}
