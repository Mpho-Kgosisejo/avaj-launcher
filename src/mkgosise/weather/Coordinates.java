package mkgosise.weather;

public class Coordinates {
    private int longitude = 0;
    private int latitude = 0;
    private int height = 0;

    public Coordinates(int longitude, int latitude, int height)
    {
        if (height > 100)
            this.height = 100;
        else
            this.height = height;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public int getLongitude()
    {
        return (this.longitude);
    }

    public int getLatitude()
    {
        return (this.latitude);
    }

    public int getHeight()
    {
        return (this.height);
    }
}
