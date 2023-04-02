package ITATest.tests;

import ITATest.pages.Credentials;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

public class VerifyJobSeekers {


    WebDriver driver;

    @Test(priority = 0, description = "TEst description goes here todisplay in the report left side of the IDE.")
    public void verifyJObSeekers(){
        System.out.println("Test is my test");


        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        driver = new ChromeDriver(options);
        //maximizze
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.viewcvs.co.uk/index.php");

        //click job seekers
        driver.findElement(By.linkText("Job Seekers")).click();

        Credentials credntials = new Credentials(driver);
        credntials.login("chamtester23@gmail.com", "Welcome@123");


        //click Add button for work experience
        driver.findElement(By.xpath("//div[@class='summary'][4]//a")).click();

        // job seekers page
//        chamtester23@gmail.com
//        Welcome@123

//        didn't work with xpath
        driver.findElement(By.xpath("(//button[@class='add_button'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='edcl'])[10]/a/button")).click();
        driver.findElement(By.xpath("//a[@href='experience.php']/button[text()='ADD']")).click();
        driver.findElement(By.xpath("//a[@href='experience.php']/button")).click();

        //selector's hub relative xpath didn't work
        //driver.findElement(By.xpath("//a[@href='experience.php']//button[@class='add_button'][normalize-space()='ADD']")).click();
        //WebElement workExperienceAddButton= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[9]/div[1]/a[1]/button[1]"));
        //WebElement workExperienceAddButton = driver.findElement(By.xpath("//a[@href='experience.php']//button[@class='add_button']"));
        //workExperienceAddButton.click();
        //driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(8) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(1) > a:nth-child(1) > button:nth-child(1)")).click();

        driver.findElement(By.cssSelector("a[href=experience.php]/button")).click();
    }
}
