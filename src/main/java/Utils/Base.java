package Utils;

import PageObjects.MediaLibrary;
import PageObjects.UploadMediaPopup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

    public static WebDriver driver;
    public static Actions actions;
    public static WebDriverWait wait;

    public static PageObjects.LoginPage cloudinaryLoginPage;
    public static PageObjects.MainPage mainPage;
    public static PageObjects.MenuBar menuBar;
    public static MediaLibrary mediaLibrary;
    public static UploadMediaPopup uploadMediaPopup;

}
