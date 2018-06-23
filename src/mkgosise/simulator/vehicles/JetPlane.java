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

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        System.out.println("Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.");
    }
}