package mkgosise.simulator.vehicles;

import mkgosise.simulator.WeatherTower;
import mkgosise.weather.Coordinates;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        String tmp = "Helicopter#" + this.name + "(" + this.id + "):";

        switch (weather){
            case "SUN":
                coordinates = new Coordinates((coordinates.getLongitude() + 10), coordinates.getLatitude(), (coordinates.getHeight() + 2));
                writing.write(tmp + " This is hot. [#" + weather + " - (Long +10, H +2)]");
                break;
            case "RAIN":
                coordinates = new Coordinates((coordinates.getLongitude() + 5), coordinates.getLatitude(), coordinates.getHeight());
                writing.write(tmp + " Damn rain! Better speed up. [#" + weather + " - (Long +5)]");
                break;
            case "FOG":
                coordinates = new Coordinates((coordinates.getLongitude() + 1), coordinates.getLatitude(), coordinates.getHeight());
                writing.write(tmp + " Damn, if only I had auto pilot. Can't see clearly! [#" + weather + " - (Long +1)]");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 12));
                writing.write(tmp + " My rotor is going to freeze! [#" + weather + " - (H -12)]");
                break;
        }

        if (coordinates.getHeight() <= 0)
        {
            writing.write(tmp + " landing...");
            writing.write("Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);

        writing.write("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}