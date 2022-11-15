import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class EdgeBrowserTest {
    public static void main(String[] args) {
        //Declaring the String type variable to store given URL
        String urlEdge = "https://courses.ultimateqa.com/users/sign_in";
        //1.Setting up the browser webdriver
        System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
        //Creating Interface object
        WebDriver edDriver = new EdgeDriver();

        //2. Opening given URL
        edDriver.get(urlEdge);

        //Maximising Edge window upon opening
        edDriver.manage().window().maximize();

        //Timeout for page to load completely
        edDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //3. Printing the title of page
        String titlePage = edDriver.getTitle();
        System.out.println("The title of page is: " + titlePage);

        //4. Printing the current URL
        String currentUlr = edDriver.getCurrentUrl();
        System.out.println("The current URL is: " + currentUlr);

        //5. Printing the page source
        String sourcePage = edDriver.getPageSource();
        System.out.println("Source code of page: " + sourcePage);

        //6. Enter the email in email field
        WebElement userEmail = edDriver.findElement(By.id("user[email]"));
        userEmail.sendKeys("kishan@hotmail.com");

        //7. Enter the password in the password field
        WebElement passwordField = edDriver.findElement(By.name("user[password]"));
        passwordField.sendKeys("pass_123");

        //8. Closing the Edge browser
        edDriver.quit();

    }
}
