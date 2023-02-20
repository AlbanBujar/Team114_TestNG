package ders11_TestNGFramework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class C03_DependsOnMethods {
WebDriver driver;
    @Test
    public void Test01() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://www.amazon.com");

        String expected = "amazon";
        String actual = driver.getCurrentUrl();

        Assert.assertTrue(actual.contains(expected));

    }

    @Test (dependsOnMethods = "Test01")
    public void aramaKutusuTest() {

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(aramaKutusu.isEnabled());


    }

    @Test (dependsOnMethods = "aramaKutusuTest")
    public void nutellaTest() {
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYaziElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expected = "Nutella";
        String actualYazi = sonucYaziElementi.getText();

        Assert.assertTrue(actualYazi.contains(expected));
    }
}
