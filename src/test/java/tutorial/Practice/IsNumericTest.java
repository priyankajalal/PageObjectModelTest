package tutorial.Practice;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

public class IsNumericTest {

    public boolean isNumeric(String s){
        Integer.parseInt(s);
        return true;
    }

    @DataProvider(name = "data1")
    public Object[][] provider1(){
        return new Object[][]{
                {123},
                {-123}
        };
    }

    @Test(dataProvider = "data11")
    public void test1(){
        Assert.assertTrue(isNumeric());
    }
}
