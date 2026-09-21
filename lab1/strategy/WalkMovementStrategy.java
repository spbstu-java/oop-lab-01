package com.example.lab1.strategy;

import com.example.lab1.model.Point;
 
public class WalkMovementStrategy implements MovementStrategy
{
    @Override
    public void move(Point from, Point to)
    {
        System.out.println("Герой идет пешком из " + from + " в " + to);
    }
}
