package mkgosise.simulator.vehicles;


import mkgosise.weather.Coordinates;

public class Aircraft {
    protected Long          id;
    protected String        name;
    protected Coordinates coordinates;
    private static Long     idCounter = 0L;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.id = this.nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private Long nextId()
    {
        return (++this.idCounter);
    }
}
