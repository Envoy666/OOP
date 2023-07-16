package ru.gb.oop.seminar3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main
{
    private static List <String> log = new ArrayList <> ();
    
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner (System.in);
        int gameMode = selectGame (scanner);
        
        boolean nextLoop = true;
        
        while (nextLoop)
        {
            nextLoop = false;
            String message = null;
            AbstractGame game = switch (gameMode)
            {
                case 1 ->
                {
                    message = "Режим: цифры";
                    yield new NumberGame ();
                }
                case 2 ->
                {
                    message = "Режим: русские буквы";
                    yield new RuGame ();
                }
                case 3 ->
                {
                    message = "Режим: английские буквы";
                    yield new EnGame ();
                }
                default -> null;
            };
            
            if (game == null) return;
            
            System.out.println (message);
            log.add (message);
            
            System.out.println ("Введите количество символов:");
            int wordLength = scanner.nextInt ();
            System.out.println ("Введите количество попыток:");
            int tryCount = scanner.nextInt ();
            scanner.nextLine ();
            log.add ("количество символов = " + wordLength + ", количество попыток " + tryCount);
            
            game.start (wordLength, tryCount);
            log.add ("загаданная последовательность: " + game.getWord ());
            System.out.println ("Игра началась! (для рестарта введите !restart)");
            
            boolean isFinish = false;
            boolean isWin = false;
            while (!(isFinish || isWin))
            {
                System.out.printf ("Введите свой вариант (осталось попыток - %d): ", game.getTryCount ());
                String input = scanner.nextLine ();
                if (input.equals ("restart!"))
                {
                    System.out.println ("Перезапуск игры!");
                    nextLoop = true;
                    break;
                }
                Answer answer = game.inputValue (input);
                log.add (answer.toLog ());
                System.out.println (answer);
                isFinish = game.getGameStatus () == GameStatus.FINISH;
                isWin = game.getGameStatus () == GameStatus.WIN;
            }
            
            if (nextLoop) continue;
            
            if (isWin) System.out.println ("Вы победили!");
            else System.out.printf ("Вы проиграли... Правильный вариант: %s", game.getWord ());
            
            System.out.println ("Перезапустить игру? Y/N");
            nextLoop = forceValidAnswer (scanner);
        }
        
        System.out.println ("Вывести лог игры? Y/N");
        if (forceValidAnswer (scanner))
        {
            for (String s : log)
            {
                System.out.println (s);
            }
        }
    }
    
    
    /**
     * @param scanner экземпляр класса Scanner
     * @return номер режима
     * @apiNote выбор режима игры
     */
    private static int selectGame (Scanner scanner)
    {
        System.out.println ("Выберите режим: ");
        System.out.println ("1. Цифры");
        System.out.println ("2. Русские буквы");
        System.out.println ("3. Английские буквы");
        System.out.println ("4. Выход");
        int mode = -1;
        while ((mode = scanner.nextInt ()) < 1 || mode > 4)
        {
            System.out.println ("Введено неверное значение");
        }
        return mode;
    }
    
    /**
     * @param scanner экземпляр класса Scanner
     * @return true - если введено Y, false - если N
     * @apiNote организовывает получение валидного ответа от пользователя - только Y или N
     */
    private static boolean forceValidAnswer (Scanner scanner)
    {
        String inputStr;
        while (true)
        {
            inputStr = scanner.nextLine ();
            if (inputStr.equalsIgnoreCase ("Y")) return true;
            if (inputStr.equalsIgnoreCase ("N")) return false;
            System.out.println ("Unknown command: " + inputStr);
        }
    }
}
