package ru.gb.oop.seminar3;

public interface Game
{
    void start (int wordLength, int attempts);
    
    Answer inputValue (String input);
    
    GameStatus getGameStatus ();
}
