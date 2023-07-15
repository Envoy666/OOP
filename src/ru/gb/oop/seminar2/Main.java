package ru.gb.oop.seminar2;

import java.util.Arrays;
import java.util.List;

import ru.gb.oop.seminar2.challenger.Cat;
import ru.gb.oop.seminar2.challenger.Challenger;
import ru.gb.oop.seminar2.challenger.Man;
import ru.gb.oop.seminar2.challenger.Robot;
import ru.gb.oop.seminar2.obstacle.Obstacle;
import ru.gb.oop.seminar2.obstacle.Treadmill;
import ru.gb.oop.seminar2.obstacle.Wall;

public class Main
{
    public static void main (String[] args)
    {
        List <Challenger> challengerList = challengerList ();
        List <Obstacle> obstacleList = obstaclesList ();
        for (Challenger challenger : challengerList)
        {
            System.out.println (">>> участник: " + challenger.getName ());
            boolean fail = false;
            for (Obstacle obstacle : obstacleList)
            {
                if (!obstacle.challenge (challenger))
                {
                    fail = true;
                    break;
                }
            }
            if (fail) System.out.println ("полоса не пройдена");
            else System.out.println ("полоса пройдена полностью");
        }
    }
    
    /**
     * @return список препятствий
     * @apiNote создает список препятствий
     */
    private static List <Obstacle> obstaclesList ()
    {
        return Arrays.asList (
                new Treadmill (1000),
                new Wall (1),
                new Treadmill (3000),
                new Wall (2),
                new Treadmill (5000),
                new Wall (3)
        );
    }
    
    /**
     * @return список участников
     * @apiNote создает список участников
     */
    private static List <Challenger> challengerList ()
    {
        return Arrays.asList (new Man (), new Cat (), new Robot ());
    }
}
