package mkgosise.simulator;

import mkgosise.simulator.vehicles.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower
{
    private List<Flyable> observers = new ArrayList<>();
    private List<Flyable> toRemove = new ArrayList<>();

    public void register(Flyable flyable)
    {
        this.observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        this.toRemove.add(flyable);
    }

    protected void conditionsChange()
    {
        for (Flyable flyable: this.observers) {
            flyable.updateConditions();
        }
        observers.removeAll(toRemove);
    }
}