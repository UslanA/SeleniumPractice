package work02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C03_Locators {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver", "src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1- https://www.amazon.com/ sayfasına gidin.
        driver.get("https://www.amazon.com/");

        //2- Arama kutusuna “city bike” yazip aratin
        WebElement aramaKutusuElemnti = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusuElemnti.sendKeys("city bike" + Keys.ENTER);

        //3- Görüntülenen sonuçların sayısını yazdırın
        List<WebElement> listeleneUrunElementleri =
                driver.findElements(By.xpath("//div[@class='a-section aok-relative s-image-fixed-height']"));
        System.out.println("Goruntulenen sonuclarin sayisi : " + listeleneUrunElementleri.size());


        //4- Listeden ilk urunun resmine tıklayın
        listeleneUrunElementleri.get(0).click();

        Thread.sleep(3000);
        driver.close();
    }
}
