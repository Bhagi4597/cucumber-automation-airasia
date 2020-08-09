package steps;
import com.cucumber.framework.browser.ChromeBrowser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;


public class CheckFlightStatus {
    ChromeBrowser browser = new ChromeBrowser();
    WebDriver driver = browser.getChromeDriver(browser.getChromeCapabilities());

    @Given("^on home page$")
    public void iAtTheHomePage() {
        driver.manage().window().maximize();
        driver.get("http://www.airasia.com");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Flights']")));
        String title=driver.getTitle();
        System.out.println(title);
    }

    @When("^I click on the Flights status$")
    public void iClickOnTheFlightsStatus() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[text() ='Flight status']")).click();
    }

    @Then("^I should be at the Flights status page$")
    public void iShouldBeAtTheFlightsStatusPage() {
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        String url=driver.getCurrentUrl();
        System.out.println(url);
        Assert.assertEquals("https://www.airasia.com/flightstatus/en/GB", url);
    }

 @And("^Enter the flight number as (.*)$")
   public void enterFlightNumberFlightNumber(String flightNumber) {
     driver.findElement(By.id("flightNumber")).sendKeys(flightNumber);
    }

    @And("^I click on find flights$")
    public void iClickOnFindFlights() {
        List<WebElement> buttons = driver.findElements(By.xpath("//button[text()= 'Find flights']"));
        buttons.get(0).click();
    }

    @Then("^I should be at status result page$")
    public void iShouldBeAtResultPage() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//i[@class= 'material-icons flight']")));
        boolean displayed = driver.findElement(By.xpath("//div[text()=' Penang (PEN) ']")).isDisplayed();
        Assert.assertEquals(true, displayed);
    }
}
