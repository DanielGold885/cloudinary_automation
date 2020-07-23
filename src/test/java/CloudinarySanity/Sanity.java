package CloudinarySanity;

import BusinessFlows.WebWorkFlows;
import Utils.Common;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@Listeners(Utils.Listeners.class)
public class Sanity extends Common{


    public Sanity() {
    }

    @BeforeMethod
    public void login() {
        WebWorkFlows.login(getData("email"), getData("password"));
    }

//    @AfterMethod
//    public void logout() {
//        WebWorkFlows.signOut();
//    }


    @Test(description = "Upload image test")
    @Description("Upload image to Cloudinary and validate successful upload")
    public void uploadImageToCloudinary() throws IOException, SAXException, ParserConfigurationException {
//        WebWorkFlows.uploadAsset(getData("filePath"), getData("publicId"));
       // assertTrue(false);
        driver.findElement(By.id("123"));
    }

}
