package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AssetWidget {

    @FindBy(how = How.XPATH, using = "//div[@data-test='asset-info-text']")
    public WebElement recentUploadedAsset;
}
