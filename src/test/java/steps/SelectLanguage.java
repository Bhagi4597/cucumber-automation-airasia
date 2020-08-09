package steps;
import com.cucumber.framework.browser.ChromeBrowser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SelectLanguage {
    ChromeBrowser browser = new ChromeBrowser();
    WebDriver driver = browser.getChromeDriver(browser.getChromeCapabilities());

    @Given("I am at home page")
    public void iAtTheHomePage() {
        driver.manage().window().maximize();
        driver.get("http://www.airasia.com");
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Flights']")));
        String title=driver.getTitle();
        System.out.println(title);
    }

    @When("^I select language from dropdown as (.*)$")
    public void iselectedLanguage(String language){
        driver.findElement(By.id("langDrop")).click();
        driver.findElement(By.id("langDrop2")).click();
    }

    @Then("Verify that language change is reflected in url")
    public void verifyLanguageChangeReflected() throws InterruptedException {
        Thread.sleep(5000);
        String url=driver.getCurrentUrl();
        System.out.println(url);

        Assert.assertEquals("https://www.airasia.com/id/id", url);
    }

}

