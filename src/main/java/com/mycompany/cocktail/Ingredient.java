/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cocktail;

/**
 *
 * @author bahar
 */
public abstract class Ingredient {
    private String name;
    private double calories;

    public Ingredient(String name, double calories) {
        this.name = name;
        this.calories = calories;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }


    public String getInfo() {
        return "Ingredient{" + "name=" + name + ", calories=" + calories + '}';
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
