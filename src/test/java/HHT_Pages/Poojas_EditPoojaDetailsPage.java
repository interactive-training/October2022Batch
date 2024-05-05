package HHT_Pages;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class Poojas_EditPoojaDetailsPage {
        public static final Logger log = LogManager.getLogger(Poojas_EditPoojaDetailsPage.class.getName());
        WebDriver driver;

        // Constructor
        public Poojas_EditPoojaDetailsPage(WebDriver driver){
            this.driver = driver;
        }
// By variables

        public String verifyEditPoojaDetailsHeader(){
            return driver.findElement(By.xpath("//div[@id='bar']/h1")).getText();
        }

        public void editPoojaDetails(String EditField, String EditInfo){

            if(EditField.equals("Pooja Title")) {
                driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).clear();
                driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).sendKeys(EditInfo);
                System.out.println("Pooja Title edited");

            } else if(EditField.equals("Pooja Start Date")) {
                driver.findElement(By.xpath("//tr[5]/td[2]/input")).clear();
                driver.findElement(By.xpath("//tr[5]/td[2]/input")).sendKeys(EditInfo);
                System.out.println("Pooja Start Date edited");

            } else if(EditField.equals("Pooja End Date")) {
                driver.findElement(By.xpath("//tr[6]/td[2]/input")).clear();
                driver.findElement(By.xpath("//tr[6]/td[2]/input")).sendKeys(EditInfo);
                System.out.println("Pooja End Date edited");
            }
        }
        public void clicksOnSubmitButtonOfEditPoojaDetailsPage() {
            driver.findElement(By.name("save")).click();
            System.out.println("Edit and submitted");
        }

    }

