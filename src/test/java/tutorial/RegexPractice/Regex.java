package tutorial.RegexPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String input = "Microsoft Corporation (MSFT)  96.54  2.11 (2.23%)";

        Pattern p1 = Pattern.compile("(\\d{1,2})\\.(\\d{1,2})");
        Matcher m = p1.matcher(input);

        List<String> symbolDetails = new ArrayList<String>();
        while(m.find()){
            symbolDetails.add(m.group());
        }

        Pattern p2 = Pattern.compile("(\\D+)");
        Matcher m2 = p2.matcher(input);

        if(m2.find()){
            String name = m2.group();
            symbolDetails.add(name);
            //System.out.println(name);
        }
//        HashMap<String,String> symbolDetailMap = new HashMap<String,String>();
//        symbolDetailMap.put("name",symbolDetails.get(3));
//        symbolDetailMap.put("price",symbolDetails.get(0));
//        symbolDetailMap.put("change",symbolDetails.get(1));
//        symbolDetailMap.put("per_change",symbolDetails.get(2));

        //System.out.println(symbolDetailMap);


    }
 }
