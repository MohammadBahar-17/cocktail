/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cocktail;

/**
 *
 * @author bahar
 */
public class Fruit extends Ingredient implements TangibleIngredient {
    private double volume;
    private RGBColor color;

    public Fruit(String name, int calories, double volume, RGBColor color) {
        super(name, calories);
        this.volume = volume;
        this.color = color;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public RGBColor getColor() {
        return color;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Volume: " + volume + ", Color: " + color.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }
    
}
