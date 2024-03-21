package Tests.Day15_testNG_Framework;

import org.testng.Assert;
import org.testng.annotations.Test;

public class C01_Priority {

    int a =20;
    int b = 10;

    @Test (priority = 45)
    public void carpmaTesti(){

        //sayilarin carpiminin yuzden buyuk oldugunu test edin
        Assert.assertTrue(a*b>100);
    }
    @Test (priority = 5)
    public void toplamaTesti(){

        //sayilartin toplaminin pozitif bir tamsayi oldugunu test edin

        Assert.assertTrue(a+b>0);
    }
    @Test (priority = -9)
    public void cikarmaTesti(){

        //a ile b nin farkinin mutlak degerinin 100'den kucuk oldugunu test edin
        Assert.assertTrue((a-b)>-100 && (a-b)<100);
    }
}
