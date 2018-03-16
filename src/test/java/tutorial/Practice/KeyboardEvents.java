package tutorial.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardEvents {
    public static void main(String args[]){
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();

        WebElement text = driver.findElement(By.name("q"));
        Actions action = new Actions(driver);
        action.keyDown(text, Keys.SHIFT).sendKeys("java program")
                .keyUp(text,Keys.SHIFT).doubleClick()
                .contextClick().build().perform();
    //The “Java Code Geeks” keyword is sent to the search box of the google site.
    // Thus, it is changed to UPPERCASE with KeyDown() method and doubleClick()
    // method double clicks on it to highlight the text and contextClick()
    // does event of double click on the text and thus contextual menu is displayed.

    }
}
