package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Common extends Base {

    private String platform = getData("platformName");

    // Parse XML - Receives node as String and returns value.
    public static String getData(String nodeName) {

        DocumentBuilder dBuilder;
        Document doc = null;

        File fXmlFile = new File("./configurationFiles/config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {

            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }


    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("internetExplorer"))
            driver = initInternetExplorerDriver();
        else
            throw new RuntimeException("Invalid Platform type stated!");
        driver.manage().window().setSize(new Dimension(1024, 768));
        wait = new WebDriverWait(driver, Long.parseLong(getData("defaultTimeout")));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("defaultTimeout")),
                TimeUnit.SECONDS);
        actions = new Actions(driver);
        driver.get(getData("URL"));
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    public static WebDriver initInternetExplorerDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }


    @BeforeClass
    public void startSession() {

        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("browserName"));
        else if (platform.equalsIgnoreCase("remote"))
            initBrowser(getData("browserName"));
        else if (platform.equalsIgnoreCase("mobile"))
            initBrowser(getData("browserName"));
        else
            throw new RuntimeException("Invalid Platform name!");
        PageManager.initPageObjectElements();
    }

    @AfterClass
    public void cleanSession() {
        driver.quit();
    }
}

