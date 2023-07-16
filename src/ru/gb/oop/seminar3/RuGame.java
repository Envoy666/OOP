package ru.gb.oop.seminar3;

import java.util.ArrayList;
import java.util.List;

public class RuGame extends AbstractGame
{
    @Override
    public List <String> generateCharList ()
    {
        List <String> strList = new ArrayList <> ();
        for (int i = 'А'; i <= 'Я'; i++)
        {
            strList.add (Character.toString (i));
        }
        return strList;
    }
}
