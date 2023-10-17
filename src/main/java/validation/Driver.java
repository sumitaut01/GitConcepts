package validation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) throws InterruptedException {

//        WebDriver driver =new ChromeDriver();
//        driver.get("http://www.google.com");
//        Thread.sleep(20000);

        By xx= By.xpath("//td[@class='ggg']");
        String temp=xx.toString();
        System.out.println(temp);
        System.out.println(temp.replace("By.xpath:",""));

        System.out.println(Arrays.toString(temp.split("By.xpath:")));

        System.out.println(xx.toString());




     //   driver.quit();

    }
}
