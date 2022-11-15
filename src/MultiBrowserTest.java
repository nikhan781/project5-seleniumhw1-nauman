import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class MultiBrowserTest {
    //Declaring static variable of static type to store browser name to be selected
    static String browser = "Chrome";

    //Declaring static variable of String type to store url
    static String urlWeb = "https://courses.ultimateqa.com/users/sign_in";

    //Initialising static variable of WebDriver type to store web driver value
    static WebDriver muDriver;

    //Creating main method
    public static void main(String[] args) {

        //Using if-else condition statement to set up required browser
        if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            muDriver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.gheko.driver", "drivers/geckodriver.exe");
            muDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
            muDriver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser selection");
        }

        //Opening selected browser inside try-catch block to handle exception
        try {
            //2. Opening the browser
            muDriver.get(urlWeb);
        } catch (Exception e) {
            System.out.println("End of program due to invalid entry");
            //Statement to exit the program in case of exception
            System.exit(0);
        }
        //Maximising browser window upon opening
        muDriver.manage().window().maximize();

        //Providing timeout for complete loading of page
        muDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Printing title of selected browser in console
        System.out.println("title of page is: " + muDriver.getTitle());

        //4. Printing the current url in console
        String urlCu = muDriver.getCurrentUrl();
        System.out.println("The current url is: " + urlCu);

        //5. Printing the source for page in console
        System.out.println("The source of page is: " + muDriver.getPageSource());

        //6. Getting web element for email field and entering the email in the field
        WebElement emailU = muDriver.findElement(By.name("user[email]"));
        emailU.sendKeys("prime@gmail.com");

        //7. Getting web element for password field and entering the password in the field
        WebElement passU = muDriver.findElement(By.name("user[password]"));
        passU.sendKeys("test009");

        //8. Closing the open browser
        muDriver.quit();

    }
}