package CloudinarySanity;

import BusinessFlows.WebWorkFlows;
import Utils.Common;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(Utils.Listeners.class)
public class Sanity extends Common {


    @BeforeMethod
    public void login() {
        WebWorkFlows.login(getData("email"), getData("password"));
    }

    @AfterMethod
    public void logout() {
        WebWorkFlows.signOut();
    }

    @Test(description = "Upload image test")
    @Description("Validate successful asset upload with ID to Cloudinary and validate")
    public void uploadAssetWithID() {
        WebWorkFlows.uploadAsset(getData("filePath"), getData("publicId"));
    }
}
