import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project11 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.get("http://a.testaddressbook.com/sign_in");
       // Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.findElement(By.id("session_email")).sendKeys("fatih1234@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("asdf1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.cssSelector("a[href='/addresses']")).click();
        driver.findElement(By.cssSelector("a[href='/addresses/new']")).click();
        address_first_name
    }
}
