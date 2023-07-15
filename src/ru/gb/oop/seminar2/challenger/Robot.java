package ru.gb.oop.seminar2.challenger;

public class Robot implements Challenger
{
    @Override
    public String getName ()
    {
        return "робот";
    }
    
    @Override
    public boolean run (int distance)
    {
        System.out.println ("побежал на дистанцию " + distance + "м");
        return distance <= 10000;
    }
    
    @Override
    public boolean jump (int height)
    {
        System.out.println ("прыгнул в высоту на " + height + "м");
        return height <= 3;
    }
}
