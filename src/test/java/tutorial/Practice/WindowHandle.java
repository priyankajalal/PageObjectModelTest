package tutorial.Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WindowHandle {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.hdfcbank.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Get parent window handle
        String parent = driver.getWindowHandle();
        System.out.println(parent);

        //Click on Login button which opens a new window
        WebElement submit = driver.findElement(By.xpath("//a[@id='loginsubmit']"));
        WebDriverWait wait = new WebDriverWait(driver,20);
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();

        //Switch to new window handles
        //Using Set not list because we do not want Duplicate window handles
        Set<String> handles = driver.getWindowHandles();
        for(String handle1: handles){
            driver.switchTo().window(handle1);
        }

        WebElement msg = driver.findElement(By.xpath("//h5[text()='Important Messages']"));
        Assert.assertEquals(msg.getText(),"Important Messages");
        driver.close();

        // to switch back to parent window
        driver.switchTo().window(parent);
        WebElement search = driver.findElement(By.xpath("//input[@class='searchbox']"));
        search.sendKeys("hi");
    }
}
