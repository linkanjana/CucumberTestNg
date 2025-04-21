
package com.myproject.pages;

import com.myproject.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropdownPage extends BasePage {

    @FindBy(id = "selectid")
    WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void selectLastOption() {
        Select select = new Select(dropdown);
        List<WebElement> options = select.getOptions();
        options.stream()
               .skip(options.size() - 1)
               .findFirst()
               .ifPresent(WebElement::click);
    }
}
    