package ru.gb.oop.seminar3;

import java.util.List;
import java.util.Random;

public abstract class AbstractGame implements Game
{
    protected int wordLength;
    
    protected int tryCount;
    
    protected String word;
    
    protected GameStatus status = GameStatus.INIT;
    
    public AbstractGame ()
    {
    
    }
    
    @Override
    public void start (int wordLength, int attempts)
    {
        status = GameStatus.START;
        this.wordLength = wordLength;
        this.tryCount = attempts;
        word = generateWord ();
    }
    
    private String generateWord ()
    {
        List <String> strList = generateCharList ();
        Random random = new Random ();
        StringBuilder sb = new StringBuilder ();
        for (int i = 0; i < wordLength; i++)
        {
            int idx = random.nextInt (strList.size ());
            sb.append (strList.get (idx));
            strList.remove (idx);
        }
        return sb.toString ();
    }
    
    public abstract List <String> generateCharList ();
    
    @Override
    public Answer inputValue (String input)
    {
        int bulls = 0;
        int cows = 0;
        
        for (int i = 0; i < input.length (); i++)
        {
            if (input.charAt (i) == word.charAt (i)) bulls++;
            if (word.contains (String.valueOf (input.charAt (i)))) cows++;
        }
        
        if (bulls == wordLength) status = GameStatus.WIN;
        else if (--tryCount == 0) status = GameStatus.FINISH;
        
        return new Answer (input, bulls, cows);
    }
    
    @Override
    public GameStatus getGameStatus ()
    {
        return status;
    }
    
    public int getTryCount ()
    {
        return tryCount;
    }
    
    public String getWord ()
    {
        return word;
    }
}
