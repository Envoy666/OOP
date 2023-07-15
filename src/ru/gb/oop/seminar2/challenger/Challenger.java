package ru.gb.oop.seminar2.challenger;

public interface Challenger
{
    /**
     * @return имя
     * @apiNote возвращает имя участника для идентификации
     */
    String getName ();
    
    /**
     * @param distance дистанция
     * @return true - если дистанция преодолена, иначе false
     * @apiNote метод преодоления дистанции
     */
    boolean run (int distance);
    
    /**
     * @param height высота
     * @return true - если высота взята, иначе false
     * @apiNote метод преодоления высоты
     */
    boolean jump (int height);
}
