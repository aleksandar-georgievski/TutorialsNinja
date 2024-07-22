package Pages;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Tests.SeleniumTest.driver;
import static Tests.SeleniumTest.*;

public class ProductsPage {

    public static String formalShoes_xpath = "//h2[@class='FormalShoesTitle']";
    public static String sportsShoes_xpath = "//h2[@class='SportsShoesTitle']";
    public static String sneakersShoes_xpath = "//h2[@class='SneakerShoesTitle']";

    public static String formalShoesDropdown_css = ".formalshoedropdown";
    public static String sportsShoesDropdown_css = ".sportsshoedropdown";
    public static String sneakersDropdown_css = ".sneakershoedropdown";

    public static String formalShoes_firstShoeName = "/html/body/div[2]/table/tbody/tr[1]/td[1]";
    public static String sportsShoes_firstShoeName = "/html/body/div[3]/table/tbody/tr[1]/td[1]";
    public static String sneakerShoes_firstShoeName = "/html/body/div[4]/table/tbody/tr[1]/td[1]";

    public static void formalShoes_verifyTitle() {
        String expectedTitleFS = "Formal Shoes";
        String actualTitleFS = driver.findElement(By.xpath(formalShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleFS, actualTitleFS);
        if(expectedTitleFS.equals(actualTitleFS)) {
            test.log(Status.PASS, "Test Passed for title verification of Formal Shoes");
        }else {
            test.log(Status.FAIL, "Test Failed for title verification of Formal Shoes");
        }
    }
    public static void sportsShoes_verifyTitle() {
        String expectedTitleSS = "Sports Shoes";
        String actualTitleSS = driver.findElement(By.xpath(sportsShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleSS, actualTitleSS);
        if(expectedTitleSS.equals(actualTitleSS)) {
            test.log(Status.PASS, "Test Passed for title verification of Sports Shoes");
        }else {
            test.log(Status.FAIL, "Test Failed for title verification of Formal Shoes");
        }
    }
    public static void sneakers_verifyTitle() {
        String expectedTitleSN = "Sneakers";
        String actualTitleSN = driver.findElement(By.xpath(sneakersShoes_xpath)).getText();
        Assert.assertEquals(expectedTitleSN, actualTitleSN);
        if(expectedTitleSN.equals(actualTitleSN)) {
            test.log(Status.PASS, "Test Passed for title verification of Sneakers Shoes");
        }else {
            test.log(Status.FAIL, "Test Failed for title verification of Formal Shoes");
        }
    }

    public static void formalShoes_firstShoe_verify() {
        String expectedFirstFormalShoe = "   Classic Cheltenham";
        driver.findElement(By.cssSelector(formalShoesDropdown_css)).click();
        String actualFirstFormalShoe = driver.findElement(By.xpath(formalShoes_firstShoeName)).getText();
        Assert.assertEquals(expectedFirstFormalShoe, actualFirstFormalShoe);
        if(expectedFirstFormalShoe.equals(actualFirstFormalShoe)) {
            test.log(Status.PASS, "Test Passed for First Shoe Name of Formal Shoe i.e Classic Cheltenham");
        }
    }
    public static void sportsShoes_firstShoe_verify() {
        String expectedFirstSportsShoe = "   Ultimate";
        driver.findElement(By.cssSelector(sportsShoesDropdown_css)).click();
        String actualFirstSportsShoe = driver.findElement(By.xpath(sportsShoes_firstShoeName)).getText();
        Assert.assertEquals(expectedFirstSportsShoe, actualFirstSportsShoe);
        if(expectedFirstSportsShoe.equals(actualFirstSportsShoe)) {
            test.log(Status.PASS, "Test Passed for First Shoe Name of Sports Shoe i.e Ultimate");
        }
    }
    public static void sneakers_firstShoe_verify() {
        String expectedFirstSneakersShoe = "   Archivo";
        driver.findElement(By.cssSelector(sneakersDropdown_css)).click();
        String actualFirstSneakersShoe = driver.findElement(By.xpath(sneakerShoes_firstShoeName)).getText();
        Assert.assertEquals(expectedFirstSneakersShoe, actualFirstSneakersShoe);
        if(expectedFirstSneakersShoe.equals(actualFirstSneakersShoe)) {
            test.log(Status.PASS, "Test Passed for First Shoe Name of Sneaker Shoe i.e Archivo");
        }
    }

    public static void formalShoes_firstShoeName_getTitle() {

    }
    public static void sportsShoes_firstShoeName_getTitle() {

    }
}

















