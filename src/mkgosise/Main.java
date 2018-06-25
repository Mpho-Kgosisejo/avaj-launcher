package mkgosise;

import mkgosise.simulator.WeatherTower;
import mkgosise.simulator.vehicles.AircraftFactory;
import mkgosise.simulator.vehicles.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static WeatherTower weatherTower = new WeatherTower();

    public static void main(String[] args) {
        List<Flyable>   flyables = new ArrayList<>();
        Helper helper = new Helper();
        BufferedReader  buffReader;
        FileReader      fileReader;
        String          line;
        String          []lineArray;
        String          type;
        String          name;
        int             latitude;
        int             longitude;
        int             height;
        int             lineIndex = 2;

        if (args.length != 1)
        {
            helper.exitProgram("One(1) argument must be passed. [" + args.length + " passed]");
        }

        try {
            fileReader = new FileReader(args[0]);
            buffReader = new BufferedReader(fileReader);
            line = buffReader.readLine();

            if (line != null)
            {

                line = line.trim();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations <= 0)
                {
                    helper.exitProgram("Invalid simulation count: " + simulations);
                }

                while ((line = buffReader.readLine()) != null)
                {
                    line = line.trim();
                    lineArray = line.split(" ");
                    if (lineArray.length != 5)
                    {
                        helper.exitProgram("Line \"" + lineIndex + "\" of file \"" + args[0] + "\" has invalid data. Elements are " + lineArray.length + " \"but must be 5\".");
                    }
                    type = helper.getAircraft(lineArray[0], lineIndex, 0);
                    name = lineArray[1];
                    latitude = helper.getPositiveNumber(lineArray[2], lineIndex, 2);
                    longitude = helper.getPositiveNumber(lineArray[3], lineIndex, 3);
                    height = helper.getPositiveNumber(lineArray[4], lineIndex, 4);

                    flyables.add(AircraftFactory.newAircraft(type, name, longitude, latitude, height));
                    lineIndex++;
                }

                for (Flyable flyable : flyables)
                {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulations; i++)
                {
                    //MyFileWriter.write("simulation: " + i);
                    weatherTower.changeWeather();
                    //MyFileWriter.write(" ");
                }
            }
        }catch (FileNotFoundException e){
            System.out.println("Exception Error: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Exception Error: " + e.getMessage());
        }
        finally {
            MyFileWriter.close();
        }
    }
}
