import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class FirefoxBrowserTest {

    public static void main(String[] args) {
        //Declaring a String Variable to store target URL
        String urlFire = "https://courses.ultimateqa.com/users/sign_in";
        //1. Setting up Firefox driver
        System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
        //Creating Interface object
        WebDriver fireDriver = new FirefoxDriver();

        //2. Opening URL
        fireDriver.get(urlFire);

        // Maximising the browser window
        fireDriver.manage().window().maximize();

        //Timeout to load the webpage completely
        fireDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Printing the page title
        System.out.println("Page title is: " + fireDriver.getTitle());

        //4. Print current URL i8n console
        System.out.println("The current URL is: " + fireDriver.getCurrentUrl());

        //5. Print page source code
        System.out.println("The source code is: " + fireDriver.getPageSource());

        //6. Getting and entering email
        WebElement emailFiled = fireDriver.findElement(By.id("user[email]"));
        emailFiled.sendKeys("amit@yahoo.com");

        //7. Getting and entering password
        WebElement passField = fireDriver.findElement(By.id("user[password]"));
        passField.sendKeys("pass@123");

        //8. Closing the FireFox browser
        fireDriver.quit();
    }
}
