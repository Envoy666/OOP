package ru.gb.oop.seminar3;

import java.util.ArrayList;
import java.util.List;

public class NumberGame extends AbstractGame
{
    @Override
    public List <String> generateCharList ()
    {
        List <String> strList = new ArrayList <> ();
        for (int i = 0; i < 10; i++)
        {
            strList.add (Integer.toString (i));
        }
        return strList;
    }
}
