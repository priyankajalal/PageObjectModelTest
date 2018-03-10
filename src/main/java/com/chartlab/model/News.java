package com.chartlab.model;

import java.util.List;

/**
 * Created by vinodnayal on 08-03-2018.
 */
public class News {

    private List<String> leftNews;
    private List<String> leftRight;

    public News(List<String> leftNews, List<String> leftRight){
        this.leftNews=leftNews;
        this.leftRight=leftRight;
    }

    public List<String> getLeftNews() {
        return leftNews;
    }

    public List<String> getLeftRight() {
        return leftRight;
    }
}
