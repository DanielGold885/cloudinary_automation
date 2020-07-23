package BusinessFlows;

import Utils.Common;
import Wrappers.UIActions;
import Wrappers.Validations;
import io.qameta.allure.Step;

public class WebWorkFlows extends Common {



    @Step("Login to Cloudinary")
    public static void login(String email, String password) {
        UIActions.setText(cloudinaryLoginPage.emailInputField, email);
        UIActions.setText(cloudinaryLoginPage.passwordInputField, password);
        UIActions.click(cloudinaryLoginPage.signInButton);
        Validations.isDisplayed(menuBar.welcome);
    }

    @Step("Logout")
    public static void signOut() {
        UIActions.click(mainPage.userAvatar);
        UIActions.click(mainPage.signOutButton);
        Validations.isDisplayed(mainPageMenuBarassetWidget.signUpForFreeBtn);
    }

    @Step("Upload image to Cloudinary and validateID")
    public static void uploadAsset(String file, String publicID) throws InterruptedException {
        UIActions.click(menuBar.mediaLibraryBtn);
        UIActions.click(mediaLibrary.uploadButton);
        UIActions.switchToFrame(driver, uploadMediaPopup.popupIframe);
        UIActions.click(uploadMediaPopup.advancedBtn);
        UIActions.setText(uploadMediaPopup.publicIdInput, publicID);
        UIActions.click(uploadMediaPopup.advancedBtn);
        UIActions.uploadFile(uploadMediaPopup.uploadFileBtn, file);
        UIActions.switchToDefaultFrame(driver);
        Validations.isDisplayed(assetWidget.uploadedAsset);
        Validations.elementText(assetWidget.uploadedAsset, getData("publicId"));
        UIActions.hoverOnElement(assetWidget.uploadedAsset);
        Validations.isDisplayed(assetWidget.threeDotAssetBtn);
    }
}
