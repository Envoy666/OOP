package ru.gb.oop.seminar2.obstacle;

import ru.gb.oop.seminar2.challenger.Challenger;

public class Wall implements Obstacle
{
    private final int height;
    
    public Wall (int height)
    {
        this.height = height;
    }
    
    @Override
    public boolean challenge (Challenger challenger)
    {
        if (challenger.jump (height))
        {
            System.out.println ("высота взята");
            return true;
        }
        else
        {
            System.out.println ("высота не взята");
            return false;
        }
    }
}
