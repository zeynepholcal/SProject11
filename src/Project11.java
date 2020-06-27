import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class Project11 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D:\\BrowserDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.get("http://a.testaddressbook.com/sign_in");
       // Thread.sleep(3000);
        driver.manage().window().maximize();
        driver.findElement(By.id("session_email")).sendKeys("fatih1234@gmail.com");
        driver.findElement(By.id("session_password")).sendKeys("asdf1234");
        driver.findElement(By.cssSelector("input[value='Sign in']")).click();
        driver.findElement(By.cssSelector("a[href='/addresses']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='/addresses/new']")).click();
        Thread.sleep(1000);

        String name ="Fernando";

        driver.findElement(By.id("address_first_name")).sendKeys(name);
        String lastName="Torres";
         driver.findElement(By.id("address_last_name")).sendKeys(lastName);
        driver.findElement(By.id("address_street_address")).sendKeys("Anfield Rd");
        driver.findElement(By.id("address_secondary_address")).sendKeys("Anfield");
        driver.findElement(By.id("address_city")).sendKeys("Liverpool");

        //Randomly select hte state
        WebElement state = driver.findElement(By.id("address_state"));
        Select select =new Select(state);
        List<WebElement> stateList = select.getOptions();
        Random rand = new Random();
        select.selectByIndex(rand.nextInt(stateList.size()));

        driver.findElement(By.id("address_zip_code")).sendKeys("L4 0TH");
        driver.findElement(By.id("address_country_us")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("03201984");

        driver.findElement(By.id("address_age")).sendKeys("36");
        driver.findElement(By.id("address_website")).sendKeys("https://www.google.com/");
        driver.findElement(By.id("address_phone")).sendKeys("8625747878");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();
        driver.findElement(By.id("address_note")).sendKeys("Never Back Down");
        driver.findElement(By.cssSelector("input[name='commit']")).click();

        //Check the name
        String firstName = driver.findElement(By.cssSelector("span[data-test='first_name']")).getText();
        Assert.assertEquals(name,firstName);

        //Check last name
        String surName = driver.findElement(By.cssSelector("span[data-test='last_name']")).getText();
        Assert.assertEquals(lastName,surName);

        driver.findElement(By.cssSelector("a[href='/addresses']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(6) > a")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("address_first_name")).clear();
        name ="Peter";
        driver.findElement(By.id("address_first_name")).sendKeys(name);
        lastName="Crouch";
        driver.findElement(By.id("address_last_name")).clear();
        driver.findElement(By.id("address_last_name")).sendKeys(lastName);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("a[href='/addresses']")).click();
        Thread.sleep(1000);
        //click on all "Destroy" buttons

        List<WebElement> destroy = driver.findElements(By.xpath("//a[text()='Destroy']"));

//        destroyList(destroy,driver);

            for (int i=0;i<destroy.size();i++) {

                driver.findElement(By.xpath("//a[text()='Destroy']")).click();
                Thread.sleep(500);
                driver.switchTo().alert().accept();
                Thread.sleep(500);
    }

    }
//    public static void destroyList(List<WebElement> dest, WebDriver a) throws InterruptedException {
//
//        for (WebElement webElement : dest) {
//            Thread.sleep(500);
//            webElement.click();
//            Thread.sleep(500);
//           a.switchTo().alert().accept();
//
//        }
//
//    }
}
