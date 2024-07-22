package Base;

import Utils.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class Base {
    WebDriver driver;
    public Properties prop;
    public Properties dataprop;
    //1. Without constructor
//    public void loadPropertiesFile() {
//        prop = new Properties();
//        File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties"); // finding the file
//        try {
//            FileInputStream fis = new FileInputStream(propFile);
//            prop.load(fis);
//        }catch (Throwable e) {
//            e.printStackTrace();
//        }
//    }
    //2.With constructor
    public Base() {
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties"); // finding the file
        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        }catch (Throwable e) {
            e.printStackTrace();
        }

        dataprop = new Properties();
        File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\testdata\\testdata.properties");
        try {
            FileInputStream dataFis = new FileInputStream(dataPropFile);
            dataprop.load(dataFis);
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public WebDriver initializeBrowserAndOpenApplicationURL(String browserName) {
        if(browserName.equalsIgnoreCase("firefox")) {
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
