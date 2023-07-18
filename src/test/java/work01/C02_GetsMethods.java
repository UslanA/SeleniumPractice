package work01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_GetsMethods {
    public static void main(String[] args) {
        //1. Yeni bir package olusturalim : day01
        //2. Yeni bir class olusturalim : C03_GetMethods
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //3. Amazon sayfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //4. Sayfa basligini(title) yazdirin
        System.out.println(driver.getTitle());

        //5. Sayfa basliginin “Amazon” icerdigini test edin
        String expectedTitleContent = "Amazon";
        String actualTitle = driver.getTitle();

        if (actualTitle.contains(expectedTitleContent)) {
            System.out.println("Amazon title Testi Passed");
        } else {
            System.out.println("Amazon title Testi Failed");
        }
        //6. Sayfa adresini(url) yazdirin
        System.out.println(driver.getCurrentUrl());

        //7. Sayfa url’inin “amazon” icerdigini test edin.
        String expectedUrlContent = "amazon";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrlContent)) {
            System.out.println("Amazon Url Testi Passed");
        } else {
            System.out.println("Amazon Url Testi Failed");
        }

        //8. Sayfa handle degerini yazdirin
        System.out.println(driver.getWindowHandle());

        //9. Sayfa HTML kodlarinda “alisveris” kelimesi gectigini test edin
        String expectedHTMlcontent = "alisveris";
        String actualHTMLcodes = driver.getPageSource();

        if (actualHTMLcodes.contains(expectedHTMlcontent)) {
            System.out.println("HTML code Testi Passed");
        } else {
            System.out.println("HTML code Testi Failed");
        }

        //10. Sayfayi kapatin.
        driver.close();
    }
}
