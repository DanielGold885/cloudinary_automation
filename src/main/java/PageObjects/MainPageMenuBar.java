package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPageMenuBar {

    @FindBy(how = How.CSS, using = "a[class='btn btn-sm btn-default']")
    public WebElement signUpForFreeBtn;
}
