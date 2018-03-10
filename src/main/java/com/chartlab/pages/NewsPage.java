package com.chartlab.pages;

import com.chartlab.helper.FindBy;
import com.chartlab.model.News;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.chartlab.controls.BaseControl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class NewsPage extends BasePage {

    public NewsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(locator = "xpath=//a[text()='News']")
    public BaseControl newsTab;

    @FindBy(locator = "xpath=//a[text()='MarketWatch']")
    public BaseControl marketWatchTab;

    @FindBy(locator = "xpath=//div[@id='tab_MarketWatch']//div[@class='news-left']//table")
    public BaseControl leftNewsCtrl;

    @FindBy(locator = "xpath=//div[@id='tab_MarketWatch']//div[@class='news-right']//table")
    public BaseControl rightNewsCtrl;


    public News getNews() {
        List<String> leftNews = new ArrayList<String>();
        List<String> rightNews = new ArrayList<String>();
        newsTab.click();
        marketWatchTab.click();
        List<WebElement> leftNewsElements = leftNewsCtrl.getElements();
        List<WebElement> rightNewsElements = rightNewsCtrl.getElements();
        for (WebElement element : leftNewsElements) {
            leftNews.add(element.getText());
        }
        for (WebElement element : rightNewsElements) {
            rightNews.add(element.getText());
        }

        News chartLabNews = new News(leftNews, rightNews);

        return chartLabNews;

    }

    public String getNewsDate() throws ParseException {

        List<WebElement> news = leftNewsCtrl.getElements();
        List<Date> newsDates = new ArrayList<Date>();
        for (WebElement newsElement : news){
            WebElement dateElement = newsElement.findElement(By.cssSelector("tbody>tr>td>h4"));
            DateFormat newsDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z");
            Date newsDate = newsDateFormat.parse(dateElement.getText());
            newsDates.add(newsDate);
        }
        Collections.sort(newsDates);
        int lastIndex = newsDates.size()-1;
        String latestNewsDate = new SimpleDateFormat("yyyyMMdd").format(newsDates.get(lastIndex));
        newsDates.get(newsDates.size() - 1);
        return latestNewsDate;

    }

}
