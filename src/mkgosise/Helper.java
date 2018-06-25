package mkgosise;

public class Helper {
    private String[] weatherTypes = {"RAIN", "FOG", "SUN", "SNOW"};
    private String[] aircrafts = {"jetplane", "helicopter", "baloon"};

    public String[] getWeatherTypes()
    {
        return (this.weatherTypes);
    }

    public boolean isValidAircrafts(String aircrafts)
    {
        for (String aircraft : this.aircrafts) {
            if (aircraft.equals(aircrafts.trim().toLowerCase()))
            {
                return (true);
            }
        }
        return (false);
    }
    public void exitProgram(String message)
    {
        System.out.println(message);
        System.exit(1);
    }

    public String getAircraft(String aircraft, int lineIndex, int elementIndex)
    {
        if (this.isValidAircrafts(aircraft) != true)
        {
            exitProgram("Invalid aircraft: \"" + aircraft + "\". At: line \"" + lineIndex + "\" element \"" + elementIndex + "\".");
            return  (null);
        }
        return (aircraft);
    }

    public int getPositiveNumber(String strNumber, int lineIndex, int elementIndex)
    {
        int ret = 0;

        try {
            ret = Integer.parseInt(strNumber);

            if (ret < 0)
            {
                exitProgram("Number can not be below 0. At: line \"" + lineIndex + "\" element \"" + elementIndex + "\".");
            }
        }
        catch (Exception exc)
        {
            exitProgram("Exception Error converting number: " + exc.getMessage() + "\nAt: line \"" + lineIndex + "\" element \"" + elementIndex + "\".");
        }
        return (ret);
    }

}
