package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class LoginPage {

    @FindBy(how = How.CSS, using = "button[id='sign-in']")
    public WebElement signInButton;

    @FindBy(how = How.ID, using = "user_session_email")
    public WebElement emailInputField;

    @FindBy(how = How.ID, using = "user_session_password")
    public WebElement passwordInputField;
}
