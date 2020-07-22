package Utils;

import org.openqa.selenium.support.PageFactory;

public class PageManager extends Base {


    public static void initPageObjectElements() {

        cloudinaryLoginPage = PageFactory.initElements(driver, PageObjects.LoginPage.class);
        mainPage = PageFactory.initElements(driver, PageObjects.MainPage.class);

    }
}
