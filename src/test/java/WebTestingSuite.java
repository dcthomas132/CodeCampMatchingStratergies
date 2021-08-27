import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;

public class WebTestingSuite
{

    private WebDriver planetDriver;

    @BeforeEach
    public void setUp()
    {
        planetDriver = new ChromeDriver();
        planetDriver.get("https://d21vtxezke9qd9.cloudfront.net/#/planets");

    }

    @Test
    public void ConfirmExplorationTextOnPlanetsWithRadiusOver4000Test() throws ParseException {
        var page = new PlanetPageUI(planetDriver);
        var wait = new WebDriverWait(planetDriver, 3);
        for (Planet planet: page.getPlanets(new MatchByRadiusOver( 4000)))
        {
            page.clickExploreButton(planet);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='snackbar popup-message mr-auto']")));
            Assertions.assertEquals("Exploring " + planet.getName(),
                    planetDriver.findElement(By.cssSelector("[class='snackbar popup-message mr-auto']")).getText());
            page.closePopUp();
        }
    }

    @Test
    public void ConfirmExplorationTextOnPlanetsWithRadiusOver4000Test2() throws ParseException {
        var page = new PlanetPageUI(planetDriver);
        var wait = new WebDriverWait(planetDriver, 3);
        for (Planet planet: page.getPlanetsPred(predicateFunctions.getPlanetWithRadiusOver(4000f)))
        {
            page.clickExploreButton(planet);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='snackbar popup-message mr-auto']")));
            Assertions.assertEquals("Exploring " + planet.getName(),
                    planetDriver.findElement(By.cssSelector("[class='snackbar popup-message mr-auto']")).getText());
            page.closePopUp();
        }
    }



    @AfterEach
    public void endTask()
    {
        planetDriver.quit();
    }

}
