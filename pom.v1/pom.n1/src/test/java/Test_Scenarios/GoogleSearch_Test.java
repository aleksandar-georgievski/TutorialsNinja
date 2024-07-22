package Test_Scenarios;

import Objects.FacebookPage;
import Objects.GoogleSearchPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GoogleSearch_Test {
    WebDriver driver;

    GoogleSearchPage objectrepo;
    FacebookPage facebookrepo;

    @BeforeTest
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com");
    }

    @Test
    public void SearchOperation() throws InterruptedException {
//        GoogleSearchPage page = new GoogleSearchPage(driver);
//        page.searchGoogle("Facebook");
        objectrepo = new GoogleSearchPage(driver);
        objectrepo.searchGoogle("Facebook");
    }

    @Test
    public void VerifyAndAccessFacebookLink() {
        objectrepo = new GoogleSearchPage(driver);
        objectrepo.clickFacebook();
    }

    @Test
    public void verifyFacebookLogin() {
       facebookrepo = new FacebookPage(driver);
       facebookrepo.EnterEmail("ace.georgievski1997@gmail.com");
       facebookrepo.EnterPassword("aleksandarg1997");
       facebookrepo.ClickLoginButton();

    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
