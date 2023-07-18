package work01;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//1. Yeni bir Class olusturalim.C05_ManageWindowSet
public class C05_ManageWindowSet {
    public static void main(String[] args) {
        System.setProperty("Webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //2. Amazon soyfasina gidelim. https://www.amazon.com/
        driver.get("https://www.amazon.com/");

        //3. Sayfanin konumunu ve boyutlarini yazdirin
        System.out.println("Sayfanin Konumu : " + driver.manage().window().getPosition());
        System.out.println("Sayfanin boyutu : " + driver.manage().window().getSize());

        //4. Sayfanin konumunu ve boyutunu istediginiz sekilde ayarlayin
        Point expectedPosition = new Point(12, 12);
        org.openqa.selenium.Dimension expextedSize = new org.openqa.selenium.Dimension(1070, 660);
        driver.manage().window().setPosition(expectedPosition);
        driver.manage().window().setSize(expextedSize);


        //5. Sayfanin sizin istediginiz konum ve boyuta geldigini test edin
        Point actualPosition = driver.manage().window().getPosition();
        Dimension actualSize = driver.manage().window().getSize();

        if (actualPosition.equals(expectedPosition) && actualSize.equals(expextedSize)) {
            System.out.println("Sayfa boyutu ve konumu testi PASSED ");
        } else {
            System.out.println("Sayfa boyutu ve konumu testi FAIlED ");
        }

        //8. Sayfayi kapatin
        driver.close();
    }
}
