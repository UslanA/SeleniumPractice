package work02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_Locators_ById_ByClassname {
    public static void main(String[] args) {
        //Automation Exercise Category Testi
        //1- Bir test class’i olusturun ilgili ayarlari yapin
        System.setProperty("WebDriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //2- https://www.automationexercise.com/ adresine gidin
        driver.get("https://www.automationexercise.com/");
        //3- Category bolumundeki elementleri locate edin
        List<WebElement> categoryElemnetleri = driver.findElements(By.className("panel-heading"));

        //4- Category bolumunde 3 element oldugunu test edin
        int expectedElementSayisi = 3;
        int actualElementSayisi = categoryElemnetleri.size();

        if (actualElementSayisi == expectedElementSayisi) {
            System.out.println("Category bolumu testi PASSED");
        } else {
            System.out.println("Category bolumu testi FAILED");
        }

        //5- Category isimlerini yazdirin

        for (WebElement each : categoryElemnetleri) {
            System.out.println(each.getText());
        }
        //6- Sayfayi kapatin
        driver.close();
    }
}
