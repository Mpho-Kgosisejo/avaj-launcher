package mkgosise.simulator;

import mkgosise.weather.Coordinates;
import mkgosise.weather.WeatherProvider;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather()
    {
        this.conditionsChange();
    }
}
