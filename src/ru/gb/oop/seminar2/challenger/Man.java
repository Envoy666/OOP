package ru.gb.oop.seminar2.challenger;

public class Man implements Challenger
{
    @Override
    public String getName ()
    {
        return "человек";
    }
    
    @Override
    public boolean run (int distance)
    {
        System.out.println ("побежал на дистанцию " + distance + "м");
        return distance <= 3000;
    }
    
    @Override
    public boolean jump (int height)
    {
        System.out.println ("прыгнул в высоту на " + height + "м");
        return height <= 1;
    }
}
