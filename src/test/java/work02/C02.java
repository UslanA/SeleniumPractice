package work02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) {
        //Automation Exercise Link Testi
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("WebDriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- adresine gidin
        driver.get("https://www.automationexercise.com/ ");

        //3- Sayfada 147 adet link bulundugunu test edin.
        List<WebElement> linkElementi = driver.findElements(By.tagName("a"));
        int expectedLinksayisi = 147;
        int actualLinkSayisi = linkElementi.size();

        if (actualLinkSayisi == expectedLinksayisi) {
            System.out.println("Link sayisi testi PASSED");
        } else {
            System.out.println("Link sayisi testi FAILED");
        }

        //4- Products linkine tiklayin
        driver.findElement(By.partialLinkText("Products")).click();

        //5- special offer yazisinin gorundugunu test edin
        WebElement imgElementi = driver.findElement(By.id("sale_image"));
        if (imgElementi.isDisplayed()) {
            System.out.println("Special offer yazisi gozukuyor, test PASSED");
        } else {
            System.out.println("Special offer yazisi gozukmuyor, test FAILED");
        }
        //6- Sayfayi kapatin
        driver.close();
    }
}
