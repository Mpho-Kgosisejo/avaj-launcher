package mkgosise.simulator.vehicles;

import mkgosise.weather.Coordinates;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
    {
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        type = type.toLowerCase();

        switch (type)
        {
            case "jetplane":
                return (new JetPlane(name, coordinates));
            case "helicopter":
                return (new Helicopter(name, coordinates));
            case "baloon":
                return (new Baloon(name, coordinates));
        }
        return (null);
    }
}
