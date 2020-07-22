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

    String platform = getData("platformName");

    public Common() throws IOException, SAXException, ParserConfigurationException {
    }


    public static String getData(String nodeName) throws ParserConfigurationException, IOException, SAXException {
        File fXmlFile = new File("./configurationFiles/config.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initBrowser(String browserType) throws ParserConfigurationException, IOException, SAXException {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("internetExplorer"))
            driver = initInternetExplorerDriver();
        else
            throw new RuntimeException("Invalid Platform type stated!");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("defaultTimeout")));
        driver.get(getData("URL"));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("defaultTimeout")),
                TimeUnit.SECONDS);
        actions = new Actions(driver);
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
    public void startSession() throws
            IOException, ParserConfigurationException, SAXException, InterruptedException {

        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("browserName"));
        else if (platform.equalsIgnoreCase("remote"))
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

