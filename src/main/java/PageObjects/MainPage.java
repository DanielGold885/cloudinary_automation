package PageObjects;

import Utils.Common;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class MainPage extends Common {

    @FindBy(how = How.CSS, using = "div[aria-describedby='tippy-tooltip-1'] *:nth-child(1)")
    public WebElement userAvatar;

    @FindBy(how = How.CSS, using = "a[class='signout btn-orange']")
    public WebElement signOutButton;

}
