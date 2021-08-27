import java.text.ParseException;

public interface Matchable {

    public boolean match(Planet planet) throws ParseException;
}
