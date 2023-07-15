package ru.gb.oop.seminar2.obstacle;

import ru.gb.oop.seminar2.challenger.Challenger;

public interface Obstacle
{
    /**
     * @param challenger экземпляр класса, реализующего интерфейс Challenger
     * @return true - если участник справился с препятствием, иначе false
     * @apiNote испытывает участника на способность преодолеть препятствие
     */
    boolean challenge (Challenger challenger);
}
