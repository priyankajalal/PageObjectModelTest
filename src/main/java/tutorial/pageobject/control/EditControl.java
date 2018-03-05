package tutorial.pageobject.control;

import org.openqa.selenium.By;
import tutorial.pageobject.pages.BasePage;

public class EditControl extends BaseControl {

    public EditControl(BasePage parent, By locator) {
        super(parent, locator);
    }

    public void setText(String text) {
        this.exist();
        this.getElement().clear();
        this.getElement().sendKeys(text);

    }

}
