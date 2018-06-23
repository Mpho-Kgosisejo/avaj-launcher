package mkgosise.simulator.vehicles;

import mkgosise.simulator.WeatherTower;
import mkgosise.weather.Coordinates;
import mkgosise.simulator.vehicles.Flyable;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower    weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}