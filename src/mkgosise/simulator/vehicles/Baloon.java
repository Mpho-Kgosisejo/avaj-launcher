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

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}