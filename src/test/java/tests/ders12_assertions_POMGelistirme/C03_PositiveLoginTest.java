package tests.ders12_assertions_POMGelistirme;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PositiveLoginTest {

    @Test
    public void qualitTest() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();
        Thread.sleep(2000);

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerliPassword"));

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.basariliGirisElementi.isEnabled());

        Thread.sleep(2000);

        Driver.closeDriver();


    }
}
