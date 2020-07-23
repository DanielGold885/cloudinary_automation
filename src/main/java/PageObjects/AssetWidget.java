package PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class AssetWidget {

    @FindBy(how = How.XPATH, using = "//div[@data-test='asset-info-text']")
    public List<WebElement> assets;

    @FindBy(how = How.XPATH, using = "//*[text() = 'public_id12345']")
    public WebElement uploadedAsset;

    @FindBy(how = How.XPATH, using = "path[d='M12 6c1.6 0 3-1.3 3-3s-1.3-3-3-3-3 1.3-3 3 1.4 3 3 3zm0 3c-1.6 0-3 1.3-3 3s1.3 3 3 3 3-1.3 3-3-1.4-3-3-3zm0 9c-1.6 0-3 1.4-3 3s1.3 3 3 3 3-1.4 3-3a3 3 0 0 0-3-3z']")
    public WebElement threeDotAssetBtn;
}
