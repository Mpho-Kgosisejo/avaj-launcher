package mkgosise.weather;

import mkgosise.Helper;

import java.util.Random;

public class WeatherProvider {
    private static Helper helper = new Helper();
    private static WeatherProvider weatherProvider = null;
    private static String[] weather = helper.getWeatherTypes();

    private WeatherProvider(){}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates) {
        Random random = new Random();
        return (weather[random.nextInt(weather.length)]);
    }
}
