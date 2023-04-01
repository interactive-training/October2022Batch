package ITATest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class VerifyJobsTest {


    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");


        driver = new ChromeDriver(options);
//
//        "1. Launch the ViewCVs.co.uk
//        2.Click on 'Recruiters'
//        3. Enter valid credentials
//        4. Click 'Sign in'
//        5. It will navigate to the recruiters home page
//        6. Click on 'Jobs and applications'                 7. User should navigate to the 'Jobs and applications page'"


        driver.get("https://www.viewcvs.co.uk/index.php");

        //click on recruiters
        driver.findElement(By.linkText("Recruiters")).click();

        //enter credentials
        driver.findElement(By.name("email")).sendKeys("born.testers@gmail.com");
        driver.findElement(By.name("password")).sendKeys("October2022");
        driver.findElement(By.xpath("//button[text()=' Sign in']")).click();


        //verify if user is on the recuriter's page
        String expected_Title = "Recruiter Dashboard - viewcvs.co.uk";
        String actual_Title = driver.getTitle();

//        System.out.println("The title is : "  + actual_Title);
        Assert.assertEquals(actual_Title, expected_Title,"Both titles are not matching"); //junit - (expected, actual)

        Thread.sleep(2000);

        //verify email id is displyed as we passed
        String expectedEmail = "born.testers@gmail.com";
        String actualEmail = driver.findElement(By.xpath("(//div[@class='right'][1]/p/strong[2])[1]")).getText();
        Assert.assertEquals(actualEmail, expectedEmail , "Email value is not showing as expected.");


        //jobs and verification link
        driver.findElement(By.linkText("Jobs & applications")).click();

        //verify manager's page appearing
        String expected_value = "Manage Jobs";
        String actualValue = driver.findElement(By.xpath("//div[text()='Manage Jobs ']")).getText().trim();
        Assert.assertEquals(actualValue, expected_value);

        //2nd way of doing
//        Assert.assertTrue(driver.findElement(By.xpath("//div[text()='Manage Jobs ']")).isDisplayed());


        Thread.sleep(2000);

        driver.close();


    }
}
