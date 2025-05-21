package tests;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import utils.CSVDataReader;
import java.time.Duration;
import java.util.List;
public class GoogleMapsRoute {
  WebDriver driver;
  WebdriverWait wait;
  @BeforeClass
  public void setup() {
    System.setProperty("webdriver.chrome.driver","path/to/chromedriver");
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver,Duration.ofSeconds(20));
  }
  @Test
  public void testRouteFromCSV() {
    List<String[]> stationPairs = CSVDataReader.readStationPairs("Stations.csv");
    for(String[] pair : stationPairs) {
      String from = pair[0];
      String to = pair[1];
      System.out.println("\nSearching route from " + from + " to " + to);
      driver.get("https://www.google.com/maps");
      try{
        webElement accept = wait.until(ExpectedConditions.elementToBeCleckable(By.xpath("//button/div[normalize-space()='Accept all']")));
        accept.click();
      } catch(Exception ignored) {}

      wait.until(ExpectedConditions.elementToBeClickable(By.xpath("searchbox-directions"))).click();
      WebElement startInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Choose starting point, or click on the map...]")));
      startInput.sendKeys(from);
      startInput.sendKeys(Keys.ENTER);
      
      WebElement destInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@aria-label='Choose destination, or click on the map...]")));
      destInput.sendKeys(to);
      destInput.sendKeys(Keys.ENTER);
      
      webElement publicRouteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='tab']//button[@aria-label='Transit']")));
      publicRouteButton.click();
      
      try {
        webElement nextTrain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-label*='Transit']div.section-directions-trip-title")));
        webElement journeyTime = driver.findElement(By.cssSelector("div.section-directions-trip-duration"));

        System.out.println("Next train: " + nextTrain.getText());
        System.out.println("Journey Time: " + journeyTime.getText());
         } catch(Exception e) {
            System.out.println("Train info not found for this route.");
         }
    }
  }
  @AfterClass
  public void teardown() {
    driver.quit();
  }
}
