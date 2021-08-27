import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PlanetPageUI {

    public WebDriver driver;
    public PlanetPageUI(WebDriver driver){
        this.driver = driver;
    }


    public List<Planet>getPlanetList()
    {
        List<Planet> planetList = new ArrayList<>();

        for (WebElement planet:driver.findElements(By.className("planet")))
        {
            planetList.add(new Planet(planet));

        }

        return planetList;
    }

    public List<Planet> getPlanets(Matchable matchable) throws ParseException {

        List<Planet> planetList = new ArrayList<>();
        for (Planet planet:getPlanetList())
        {
            if(matchable.match(planet)){
                planetList.add(planet);
            }
        }
        return planetList;
    }

    public List<Planet> getPlanetsPred(Predicate<Planet> predicate) throws ParseException {

        List<Planet> planetList = new ArrayList<>();
        for (Planet planet:getPlanetList())
        {
            if(predicate.test(planet)){
                planetList.add(planet);
            }
        }
        return planetList;
    }

    public void clickExploreButton(Planet planet)
    {
        planet.getElement().findElement(By.className("v-btn__content")).click();

    }

    public void closePopUp()
    {
        driver.findElement(By.cssSelector("[aria-label='close']")).click();
    }


}
