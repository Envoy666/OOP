package ru.gb.oop.seminar3;

import java.util.ArrayList;
import java.util.List;

public class EnGame extends AbstractGame
{
    @Override
    public List <String> generateCharList ()
    {
        List <String> strList = new ArrayList <> ();
        for (int i = 'A'; i <= 'Z'; i++)
        {
            strList.add (Character.toString (i));
        }
        return strList;
    }
}
