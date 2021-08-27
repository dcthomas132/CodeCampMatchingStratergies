import java.text.ParseException;
import java.util.function.Predicate;

public class predicateFunctions {

    public static Predicate <Planet> getPlanetWithRadiusOver(float radius){
        return planet -> {
            try {
                return planet.getRadius() > radius;
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;
        };
    }

}
