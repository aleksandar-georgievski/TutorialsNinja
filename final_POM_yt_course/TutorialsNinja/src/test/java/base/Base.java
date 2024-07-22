package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utils.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {

    WebDriver driver;
    public Properties prop;
    public Properties testProp;

    public Base() {
        prop = new Properties();
        File propFile = new File("D:\\Coding\\Selenium-Java-Projects\\final_POM_yt_course\\TutorialsNinja\\src\\main\\java\\config\\Config.properties");
        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);

        } catch (Throwable e) {
            e.printStackTrace();
        }

        testProp = new Properties();
        File testFile = new File("D:\\Coding\\Selenium-Java-Projects\\final_POM_yt_course\\TutorialsNinja\\src\\main\\java\\testdata\\Testdata.properties");

        try {
            FileInputStream fis2 = new FileInputStream(testFile);
            testProp.load(fis2);

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
    public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) {
        if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
        driver.get(prop.getProperty("url"));

        return driver;
    }

}
