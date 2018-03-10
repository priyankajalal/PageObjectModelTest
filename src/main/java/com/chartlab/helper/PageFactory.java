package com.chartlab.helper;


import com.chartlab.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Field;

public class PageFactory {

    public static By toLocator(String input) {


        if (input.matches("^xpath=(.*)")) {
            return By.xpath(input.replaceAll("^xpath=", ""));
        } else if (input.matches("^id=(.*)")) {
            return By.id(input.replaceAll("^id=", ""));
        } else if (input.matches("^name=(.*)")) {
            return By.name(input.replaceAll("^name=", ""));
        } else if (input.matches("^css=(.*)")) {
            return By.cssSelector(input.replaceAll("^css=", ""));
        } else {
            return By.id(input);
        }
    }
    public static <T extends BasePage> T init(WebDriver driver, Class<T> pageClass) throws Exception {

        T page = pageClass.getConstructor(WebDriver.class).newInstance(driver);

        for (Field field : pageClass.getFields()) {
            FindBy locator = field.getAnnotation(FindBy.class);
            if (locator != null) {
                Object control = field.getType().
                        getConstructor(BasePage.class, By.class).
                        newInstance(page, toLocator(locator.locator()));
                field.set(page, control);
            }
        }
        return page;

    }

}
