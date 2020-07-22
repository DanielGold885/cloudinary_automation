package CloudinarySanity;

import Utils.Common;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;


@Listeners(Utils.Listeners.class)
public class Sanity extends Common {
    public Sanity() throws IOException, SAXException, ParserConfigurationException {
    }


    @Test(description = "Upload image test")
    @Description("Upload image to Cloudinary and validate successful upload")
    public void uploadImageToCloudinary() {

    }

}
