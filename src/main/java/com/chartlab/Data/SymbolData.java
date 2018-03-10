package com.chartlab.Data;

import org.testng.annotations.DataProvider;

public class SymbolData {

    @DataProvider(name = "data")
    public static Object[][] testData(String name,float price,float change,float per_change){
        return new Object[][] {{"Microsoft Corporation (MSFT)"},{"96.07"},{"1.64"},{"1.74%"}};
    }
}
