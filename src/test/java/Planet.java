import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.NumberFormat;
import java.text.ParseException;

public class Planet {
    private WebElement planet;

    public Planet(WebElement planet)
    {
        this.planet = planet;
    }

    public String getName(){
        return planet.findElement(By.className("name")).getText();
    }

    public float getRadius() throws ParseException {

        String stringRadius = planet.findElement((By.className("radius"))).getText();
        return NumberFormat.getNumberInstance().parse(stringRadius.split(" ")[0]).floatValue();
    }

    public long getDistance() throws ParseException {
        String stringDistance = planet.findElement((By.className("distance"))).getText();
        return NumberFormat.getNumberInstance().parse(stringDistance.split(" ")[0]).longValue();
    }

    public WebElement getElement(){
        return planet;
    }


}
