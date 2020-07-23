package BusinessFlows;

import PageObjects.LoginPage;
import PageObjects.MainPage;
import PageObjects.MediaLibrary;
import PageObjects.UploadMediaPopup;
import Utils.Common;
import Wrappers.UIActions;
import Wrappers.Validations;
import io.qameta.allure.Step;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class WebWorkFlows extends Common {

    public WebWorkFlows() throws IOException, SAXException, ParserConfigurationException {}


    @Step("Login to Cloudinary")
    public static void login(String email, String password) {
        UIActions.setText(cloudinaryLoginPage.emailInputField, email);
        UIActions.setText(cloudinaryLoginPage.passwordInputField, password);
        UIActions.click(cloudinaryLoginPage.signInButton);
        Validations.isDisplayed(menuBar.welcome);
    }


    @Step("Logout")
    public static void signOut(){
        UIActions.click(mainPage.userAvatar);
        UIActions.click(mainPage.signOutButton);
        Validations.isDisplayed(cloudinaryLoginPage.signInButton);
    }


    public static void uploadAsset(String file, String publicID) {
        UIActions.click(menuBar.mediaLibraryBtn);
        UIActions.click(mediaLibrary.uploadButton);
        UIActions.swithToFrame(driver, uploadMediaPopup.popupIframe);
        UIActions.click(uploadMediaPopup.advancedBtn);
        UIActions.setText(uploadMediaPopup.publicIdInput, publicID);
        UIActions.click(uploadMediaPopup.advancedBtn);
        UIActions.uploadFile(uploadMediaPopup.uploadFileBtn, file);
    }
}
