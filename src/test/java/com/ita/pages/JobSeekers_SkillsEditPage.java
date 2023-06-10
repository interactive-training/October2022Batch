package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekers_SkillsEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_SkillsEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By enterSkill = By.id("skills");
    By selectSkillType = By.id("skilltype");

    // Skills Methods
    public void setSkill(String text) {
        driver.findElement(enterSkill).sendKeys(text);
    }

    public void setSkillType(String skillType) {
        WebElement elmSkill = driver.findElement(selectSkillType);
        Select selectObj = new Select(elmSkill);
        selectObj.selectByValue(skillType);
    }



}

