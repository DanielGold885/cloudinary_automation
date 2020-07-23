package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class MenuBar {

    @FindBy(how = How.CLASS_NAME, using = "title-row")
    public WebElement welcome;

    @FindBy(how = How.XPATH, using = "//b[@data-balloon='Media Library']/a")
    public WebElement mediaLibraryBtn;

}

