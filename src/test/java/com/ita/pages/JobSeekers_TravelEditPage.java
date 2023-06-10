package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobSeekers_TravelEditPage extends BasePage {
    WebDriver driver;
    public JobSeekers_TravelEditPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    // defect

    public void setTravel(String inputTravel) {
        if (inputTravel.equalsIgnoreCase("Up to 100%")) {
            String[] travel = {"Up to 100%", "Up to 25%", "Up to 50%", "Up to 75%", "No travel required"};
            String travelOption;
            for (int i = 0; i < 6; i++) {
                travelOption = (travel[i]);
                switch (Integer.parseInt(travelOption)) {

                    case 0:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][2]")).click();
                        break;
                    case 1:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][3]")).click();
                        break;
                    case 2:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][4]")).click();
                        break;
                    case 3:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][5]")).click();
                        break;

                    default:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][1]")).click();
                }
            }
        }
    }
}

//    String[] travel = {"No travel required","Up to 100%","Up to 50%","Up to 75%","Up to 25%"};
//    public void setTravel1(String travelchoice) {
//        switch(String[] travel)
//        case "No travel required":
//            driver.findElement(By.xpath("//div[@class='form-group1 rad'][1]")).click();
//        case(travel=[1]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][2]")).click();
//        case(travel=[2]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][3]")).click();
//        case(travel=[3]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][4]")).click();
//        case(travel=[4]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][5]")).click();
//    }

//    By travel = By.id("exampleRadios2").;
//            driver.findElement(travel).click();
//
//    By travel = By.id("exampleRadios2");
//            driver.findElement(travel).click();

// Add Additional Information-Relocate
//    public void setRelocate(){
//        By relocate = By.id("exampleRadios1");
//        driver.findElement(relocate).click();
//    }








