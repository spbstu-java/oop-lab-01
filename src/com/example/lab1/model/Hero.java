package com.example.lab1.model;

import com.example.lab1.strategy.MovementStrategy;

public class Hero
{
    private final String name;
    private Point position;
    private MovementStrategy strategy;

    public Hero(String name, Point position)
    {
        this.name = name;
        this.position = position;
    }

    public void setStrategy(MovementStrategy strategy)
    {
        this.strategy = strategy;
    }

    public void move(Point destination)
    {
        if (strategy == null)
        {
            throw new IllegalStateException("Способ перемещения не установлен");
        }

        strategy.move(position, destination);
        position = destination;
    }

    public String getName()
    {
        return name;
    }

    public Point getPosition()
    {
        return position;
    }

    @Override
    public String toString()
    {
        return name + " is at " + position;
    }
}
