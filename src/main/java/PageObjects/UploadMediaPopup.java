package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class UploadMediaPopup {

    @FindBy(how = How.CSS, using = "input[type='file']")
    public WebElement uploadFileBtn;

    @FindBy(how = How.CSS, using = "button[class='btn-advance c-link ml2']")
    public WebElement advancedBtn;

    @FindBy(how = How.CSS, using = "input[data-test='public-id']")
    public WebElement publicIdInput;

    @FindBy(how = How.CSS, using = "iframe[allow='camera']")
    public WebElement popupIframe;

    @FindBy(how = How.CSS, using = "#intercom-frame")
    public WebElement mainPopUpIframe;


}
