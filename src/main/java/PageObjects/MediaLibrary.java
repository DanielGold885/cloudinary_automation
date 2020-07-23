package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MediaLibrary {

    @FindBy(how = How.CSS, using = ".btn-upload")
    public WebElement uploadButton;
}
