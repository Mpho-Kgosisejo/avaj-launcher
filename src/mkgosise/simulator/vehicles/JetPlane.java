package mkgosise.simulator.vehicles;

import mkgosise.simulator.WeatherTower;
import mkgosise.weather.Coordinates;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
       super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String tmp = "JetPlane#" + this.name + "(" + this.id + "):";

        switch (weather){
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 10), (coordinates.getHeight() + 2));
                writing.write(tmp + " Sunny huh, this should be easy. [#" + weather + " - (Lat +10, H +2)]");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 5), coordinates.getHeight());
                writing.write(tmp + " It's raining. Better watch out for lightnings: . [#" + weather + " - (Lat +5)]");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), (coordinates.getLatitude() + 1), coordinates.getHeight());
                writing.write(tmp + " I can not see, switching to auto Pilot. :-) [#" + weather + " - (Lat +1)]");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 7));
                writing.write(tmp + " OMG! Winter is coming! [#" + weather + " - (H -7)]");
                break;
        }

        if (coordinates.getHeight() <= 0)
        {
            writing.write(tmp + " landing...");
            writing.write("Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        writing.write("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}