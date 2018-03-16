package tutorial.Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ActionContextClick {
    static WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
    }

    @Test
    public static void rightClickTest() {
        By locator = By.cssSelector(".context-menu-one.box");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element=driver.findElement(locator);
        rightClick(element);
        WebElement elementEdit =driver.findElement(By.cssSelector(".context-menu-item.icon.icon-edit>span"));
        elementEdit.click();
    }

    public static void rightClick(WebElement element){
        try {
            Actions action = new Actions(driver);
            action.contextClick(element).build().perform();
        }
        catch (Exception e) {
            System.out.println("Element " + element + " was not clickable "
                    + e.getStackTrace());
        }
    }
}
