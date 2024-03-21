package Tests.Day15_testNG_Framework;

import Utilites.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class C02_DependsOnMethods {

    // uc tane method olusturun
    //1- amazontest : amazon anasayfaya gidin url in amazon icerdigini test edelim
    //2- nutellatest : nutella icin arama yapip arama sonuclarinin nutella icerdigini test edin
    //3- ilkurune click yapip urun isminin nutella icerdigini test edin


    @Test
    public void amazonTesti(){
        Driver.getDriver().get("https://www.amazon.com");
        String expectedUrl = "amazon";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        Driver.driverClose();

    }
    @Test (dependsOnMethods = "amazonTesti")
    public void nutellaTesti(){

        WebElement aramaKutusu = Driver.getDriver().findElement(By.xpath("//input[@name='field-keywords']"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYazisi = Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedNutellaYazisi = "Nutella";
        String actualNutellaYazisi = sonucYazisi.getText();
        Assert.assertTrue(actualNutellaYazisi.contains(expectedNutellaYazisi));
        Driver.driverClose();

    }
    @Test (dependsOnMethods = "nutellaTesti")
    public void ilkUrunTesti(){

        WebElement ilkUrun = Driver.getDriver().findElement(By.xpath("(//img[@class='s-image'])[2]"));
        ilkUrun.click();

        WebElement ilkUrunIsmi = Driver.getDriver().findElement(By.xpath("//span[@id='productTitle']"));
        String expectedUrunIsmi = "Nutella";
        String actualUrunIsmi = ilkUrunIsmi.getText();
        Assert.assertTrue(actualUrunIsmi.contains(expectedUrunIsmi));
        Driver.driverClose();

    }
}
