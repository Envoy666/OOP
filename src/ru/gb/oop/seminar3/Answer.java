package ru.gb.oop.seminar3;

public class Answer
{
    private String input;
    private int bulls;
    private int cows;
    
    public Answer ()
    {
    }
    
    public Answer (String input, int bulls, int cows)
    {
        this.input = input;
        this.bulls = bulls;
        this.cows = cows;
    }
    
    @Override
    public String toString ()
    {
        return "быки = " + bulls + ", коровы = " + cows;
    }
    
    public int getBulls ()
    {
        return bulls;
    }
    
    public int getCows ()
    {
        return cows;
    }
    
    public String toLog ()
    {
        return "ввод = " + input + ", быки = " + bulls + ", коровы = " + cows;
    }
}
