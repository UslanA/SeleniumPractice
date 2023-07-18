package work01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1. Yeni bir class olusturun (TekrarTesti)
public class TekrarTesti {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(14));
        driver.manage().window().maximize();

        //2. Youtube web sayfasına gidin ve sayfa başlığının “youtube” olup olmadığını
        //doğrulayın (verify), eğer değilse doğru başlığı(Actual Title) konsolda yazdirin.
        driver.get("https://www.youtube.com");
        String expectedTitle = "youtube";
        String actualTitle = driver.getTitle();

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("youtube title test PASSED");
        } else {
            System.out.println("youtube title test FAILED \n Actual Title : " + actualTitle);
        }

        //3. Sayfa URL'sinin “youtube” içerip içermediğini (contains) doğrulayın, içermiyorsa
        //doğru URL'yi yazdırın.
        String expectedUrlContained = "youtube";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrlContained)) {
            System.out.println("Youtube Url test PASSED");
        } else {
            System.out.println("Youtube Url test FAILED \n Actual Url : " + actualUrl);
        }

        //4. Daha sonra Amazon sayfasina gidin https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");
        Thread.sleep(2000);

        //5. Youtube sayfasina geri donun
        driver.navigate().back();

        //6. Sayfayi yenileyin
        driver.navigate().refresh();

        //7. Amazon sayfasina donun
        driver.navigate().forward();
        Thread.sleep(2000);

        //8. Sayfayi tamsayfa yapin
        driver.manage().window().fullscreen();

        //9. Ardından sayfa başlığının "Amazon" içerip içermediğini (contains) doğrulayın,
        //Yoksa doğru başlığı(Actual Title) yazdırın.
        String expectedTitleContained = "Amazon";
        actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitleContained)) {
            System.out.println("Amazon title test PASSED");
        } else {
            System.out.println("Amazon title test FAILED \n Actual Title : " + actualTitle);
        }

        //10.Sayfa URL'sinin https://www.amazon.com/ olup olmadığını doğrulayın, degilse
        //doğru URL'yi yazdırın
        String expectedUrl = "https://www.amazon.com/";
        actualUrl = driver.getCurrentUrl();
        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Amazon Url test PASSED");
        } else {
            System.out.println("Amazon Url test FAILED \n Actual Url : " + actualUrl);
        }

        //11.Sayfayi kapatin
        driver.close();
    }
}
