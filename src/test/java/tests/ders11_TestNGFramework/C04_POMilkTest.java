package tests.ders11_TestNGFramework;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;

public class C04_POMilkTest {

     /*
        Page objet model, Java'daki OOP consept'e dayanir
        1- Driver class'inda webdriver olusturup kulanmak icin static yontem kullanilir
        2- Locate'leri page sayfalarinda yapip
           onlara obje olusturarak ulasabiliriz
     */

    @Test(groups = "smoke")
    public void test01() throws InterruptedException {
        // qualitydemy sayfasina gidip

        Driver.getDriver().get("https://www.qualitydemy.com");
        // login linkine tiklayin
        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();
        Thread.sleep(2000);
        qualitydemyPage.ilkLoginLinki.click();

        // dogru kullanici adi ve sifre ile giris yapin
        qualitydemyPage.emailKutusu.sendKeys("anevzatcelik@gmail.com");
        qualitydemyPage.passwordKutusu.sendKeys("Nevzat152032");
        qualitydemyPage.loginButonu.click();

        // giris yapildigini test edin

        //String expected = "qualitydemy";
        //String actual = Driver.getDriver().getCurrentUrl();
       // Assert.assertTrue(actual.contains(expected));  bu sekilde de yapabiliriz

        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isDisplayed());


        Thread.sleep(5000);

        Driver.closeDriver();
    }
}
