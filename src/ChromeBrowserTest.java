import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeBrowserTest {

    public static void main(String[] args) {
        //Declaring a String type local variable
        String urlChrome = "https://courses.ultimateqa.com/users/sign_in";

        //1. Setting up Chrome browser
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        //Creating WebDriver Interface Object
        WebDriver chromeDriver = new ChromeDriver();

        //2. Opening given URL
        chromeDriver.get(urlChrome);

        //Maximise browser upon opening
        chromeDriver.manage().window().maximize();

        //Time given to driver to wait until page is loaded completely
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Get & print title page in console
        String gTitle = chromeDriver.getTitle();
        System.out.println("Page title is: " + gTitle);

        //4. Get & print the current page URL in console
        String url = chromeDriver.getCurrentUrl();
        System.out.println("Current URL is: " + url);

        //5. Print the page source code in console
        String sourcePage = chromeDriver.getPageSource();
        System.out.println("The source code is : " + sourcePage);

        //6. Getting and entering email in email field
        WebElement emailField = chromeDriver.findElement(By.id("user[email]"));
        emailField.sendKeys("nik@gmail.com");

        //7. Getting and entering password in password field
        WebElement passwordField = chromeDriver.findElement(By.id("user[password]"));
        passwordField.sendKeys("pass_123");

        //8. Closing the browser
        chromeDriver.quit();

    }
}
