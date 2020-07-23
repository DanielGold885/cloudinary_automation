package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ManageAssetPage {

    @FindBy(how = How.CSS, using = "input[class='ignoreP2h w-100 bg-transparent ba br2 b--white outline-0 f-md black truncate outline-0 -inputStateIndicator___3Y']")
    public WebElement managePageHeadLine;
}
