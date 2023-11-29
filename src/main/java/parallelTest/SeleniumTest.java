package parallelTest;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.testng.AssertJUnit.assertEquals;

public class SeleniumTest {
    WebDriver driver;
    @BeforeTest
    @Parameters("browserType")

    public void setup(String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        if(browser.equalsIgnoreCase("firefox")){
            capabilities.setBrowserName("firefox");
        }

        if(browser.equalsIgnoreCase("chrome")){
            capabilities.setBrowserName("chrome");
        }

        if(browser.equalsIgnoreCase("edge")){
            capabilities.setBrowserName("MicrosoftEdge");
        }

        driver = new RemoteWebDriver (new URL("http://localhost:4444/wd/hub"), capabilities);
    }
    @Test
    public void SeleniumCrossBrowserTests(){
        driver.get("https://anupdamoda.github.io/AceOnlineShoePortal/index.html");

        driver.findElement(By.xpath("//*[@id=\"menuToggle\"]/input")).click();
        driver.findElement(By.xpath("//*[@id=\"menu\"]/a[2]/li")).click();
        driver.findElement(By.xpath("//*[@id=\"usr\"]")).sendKeys("sa");
        driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("sasa");
        driver.findElement(By.xpath("//*[@id=\"second_form\"]/input")).click();

       String ShoeCategory = driver.findElement(By.xpath("//*[@id=\"ShoeType\"]")).getText();
        assertEquals(ShoeCategory, "Formal Shoes");
    }
}
