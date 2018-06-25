package mkgosise.simulator.vehicles;

import mkgosise.simulator.WeatherTower;
import mkgosise.weather.Coordinates;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(this.coordinates);
        String tmp = "Baloon#" + this.name + "(" + this.id + "):";

        switch (weather){
            case "SUN":
                coordinates = new Coordinates((coordinates.getLongitude() + 2), coordinates.getLatitude(), (coordinates.getHeight() + 2));
                writing.write(tmp + " Let's enjoy the good weather and take some pics. [#" + weather + " - (Long +2, H +4)]");
                break;
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 5));
                writing.write(tmp + " Damn you rain! You messed up my baloon. [#" + weather + " - (H -5)]");
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 3));
                writing.write(tmp + " Foggy, I'll just lower a bit. [#" + weather + " - (H -3)]");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), (coordinates.getHeight() - 15));
                writing.write(tmp + " It's snowing. We're gonna crash. [#" + weather + " - (H -15)]");
                break;
        }

        if (coordinates.getHeight() <= 0)
        {
            writing.write(tmp + " landing...");
            writing.write("Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);

        writing.write("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}