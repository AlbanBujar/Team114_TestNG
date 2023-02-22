package tests.ders12_assertions_POMGelistirme;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_NegatifLoginTesti {
    @Test
    public void test01() throws InterruptedException {

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));

        QualitydemyPage qualitydemyPage = new QualitydemyPage();
        qualitydemyPage.cookiesKabulButonu.click();
        Thread.sleep(2000);

        qualitydemyPage.ilkLoginLinki.click();
        Thread.sleep(2000);
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUsername"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        Thread.sleep(2000);
        qualitydemyPage.loginButonu.click();
        Thread.sleep(5000);

       String hata = qualitydemyPage.hataliGirisYazisi.getText();
        System.out.println(hata);


        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

    }

    @Test
    public void test02() throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage =new QualitydemyPage();

       qualitydemyPage.cookiesKabulButonu.click();
        Thread.sleep(2000);

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.emailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUsername"));
        Thread.sleep(1000);
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));
        qualitydemyPage.loginButonu.click();
        Thread.sleep(2000);
        Assert.assertTrue(qualitydemyPage.emailKutusu.isEnabled());

        Driver.closeDriver();

    }
}
