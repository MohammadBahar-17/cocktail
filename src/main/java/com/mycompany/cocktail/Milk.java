/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cocktail;

/**
 *
 * @author bahar
 */
public class Milk extends Ingredient implements TangibleIngredient {
    private double volume;
    private RGBColor color;

    public Milk(String name,int calories,int volume, RGBColor color) {
        super(name,calories);
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

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setColor(RGBColor color) {
        this.color = color;
    }
    @Override
    public String getInfo() {
        return "Milk{" +"name="+this.getName()+", calories="+this.getCalories()+ " ,volume=" + volume + ", color=" + color + '}';
    }

    @Override
    public String toString() {
        return getInfo();
    }

}
