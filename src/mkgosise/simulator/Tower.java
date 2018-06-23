package mkgosise.simulator;

import mkgosise.simulator.vehicles.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower
{
    private List<Flyable> observers = new ArrayList<>();

    public void register(Flyable flyable)
    {
        this.observers.add(flyable);
        System.out.println("Here...");
    }

    public void unregister(Flyable flyable)
    {
        //remove passed fly_obj...
    }

    protected void conditionsChange()
    {

    }
}