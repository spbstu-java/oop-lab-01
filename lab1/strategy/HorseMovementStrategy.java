package com.example.lab1.strategy;

import com.example.lab1.model.Point;

public class HorseMovementStrategy implements MovementStrategy
{
    @Override
    public void move(Point from, Point to)
    {
        System.out.println("Герой едет на лошади из " + from + " в " + to);
    }
}
