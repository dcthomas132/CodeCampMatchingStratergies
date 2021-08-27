import java.text.ParseException;

public class MatchByRadiusOver implements Matchable
{

    private float radiusToMeet;
    public MatchByRadiusOver(float radiusToMeet)
    {
        this.radiusToMeet = radiusToMeet;
    }


    @Override
    public boolean match(Planet planet) throws ParseException {

        return(planet.getRadius() > radiusToMeet);

    }
}
