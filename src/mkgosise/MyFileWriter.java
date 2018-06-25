package mkgosise;

import java.io.*;

public class MyFileWriter {

    private static File file = null;
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;

    public MyFileWriter() {
        try {
            file = new File("simulation.txt");
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
        }
        catch (IOException exc){
            System.err.println("IOException Error: " + exc.getMessage());
        }
        catch (Exception exc)
        {
            System.err.println("Exception Error: " + exc.getMessage());
        }
    }

    public static void write(String str)
    {
        try {
            bw.write(str);
            bw.newLine();
        }catch (Exception exc) {
            System.err.println("Exception Error: " + exc.getMessage());
        }
    }

    public static void close()
    {
        try {
            if (bw != null)
                bw.close();
        }catch (Exception exc){
            System.err.println("Exception Error: " + exc.getMessage());
        }
    }
}
