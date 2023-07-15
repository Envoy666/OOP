package ru.gb.oop.seminar2.obstacle;

import ru.gb.oop.seminar2.challenger.Challenger;

public class Treadmill implements Obstacle
{
    private final int distance;
    
    public Treadmill (int distance)
    {
        this.distance = distance;
    }
    
    @Override
    public boolean challenge (Challenger challenger)
    {
        if (challenger.run (distance))
        {
            System.out.println ("дистанция преодолена");
            return true;
        }
        else
        {
            System.out.println ("дистанция не преодолена");
            return false;
        }
    }
}
