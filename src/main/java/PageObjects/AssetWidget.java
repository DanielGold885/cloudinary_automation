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

    @FindBy(how = How.XPATH, using = "//button[@data-test='action-manage-btn'][1]")
    public WebElement manageBtn;
}
