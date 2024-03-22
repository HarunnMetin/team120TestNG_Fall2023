package Tests.Day16TestNG_Framework;

import Utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class C01_DriverClassKullanimi {

    @Test
    public void amazonTest(){

        //amazona gidelim
        Driver.getDriver().get("https://www.amazon.com");
        //Nutella icin arama yapalim
        WebElement aramaKutusu = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.click();
        //sayfayi kapatin
        Driver.driverClose();
    }
    @Test
    public void youtubeTesti(){

        Driver.getDriver().get("https://www.youtube.com");
    }
}
