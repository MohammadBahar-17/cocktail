/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cocktail;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bahar
 */
public class Blender {
    protected List<Ingredient> ingredients;
    private double capacity;

    public Blender(double capacity) {
        this.capacity = capacity;
        ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) throws BlenderOverFlowException {
        if (totalVolume()+getVolume(ingredient)<=capacity) {
            ingredients.add(ingredient);
            System.out.println(ingredient.getName()+" added to blender");
        }
        else {
            throw new BlenderOverFlowException();
        }
    }

    public void blend() {
        System.out.println("Whoops I just pressed the Red button to blend!");

        double blendVolume = totalVolume();
        double blendCalories = totalCalories();
        RGBColor blendColor = getColor();

        
        ingredients.clear();

        if (blendVolume != 0) {
            ingredients.add(new Mixture(blendVolume, blendColor, blendCalories));
        }
    }

    private boolean isFullyMixed() {
        return ingredients.size() == 1 && ingredients.getFirst() instanceof Mixture;
    }

    public void pour(Cup cup) throws CupsOverFlowException, EmptyBlenderException {
        if (cup == null) {
            return;
        }

        if (ingredients.isEmpty()) {
            throw new EmptyBlenderException();
        }

        if (!isFullyMixed()) {
            System.out.println(" what are you trying to do. Have you pressed the Red button?");
            return;
        }
        Mixture mixture = (Mixture) ingredients.getFirst();

        if (cup.getCapacity() < mixture.getVolume()) {
            throw new CupsOverFlowException();

        }
    
        Cup.Contents contents = cup.getContents();
        contents.setCalories(mixture.getCalories());
        contents.setColor(mixture.getColor());
        contents.setVolume(mixture.getVolume());
    }

    public double totalCalories() {
        double total = 0;
        for (Ingredient ingredient : ingredients) {
            total += ingredient.getCalories();
        }
        return total;
    }

    public double totalVolume() {
        double total = 0;
        for (Ingredient ingredient : ingredients) {
            total += getVolume(ingredient);
        }
        return total;
    }

    public void getIngredients() {
        for(Ingredient ingredient : ingredients ){
            System.out.println(ingredient);
        }
       // return ingredients;
    }

    public RGBColor getColor() {
        
        int totalRed = 0, totalGreen = 0, totalBlue = 0;
        int totalTangibleIngredients = 0;

        for (Ingredient ingredient : ingredients) {
            if (ingredient instanceof TangibleIngredient tangibleIngredient) {
                RGBColor color = tangibleIngredient.getColor();

                totalRed += color.getRed();
                totalGreen += color.getGreen();
                totalBlue += color.getBlue();
                totalTangibleIngredients++;
            }
        }

        if (totalTangibleIngredients == 0) {
            return new RGBColor(255, 255, 255);
        }

        int avgRed = totalRed / totalTangibleIngredients;
        int avgGreen = totalGreen / totalTangibleIngredients;
        int avgBlue = totalBlue / totalTangibleIngredients;
        return new RGBColor(avgRed, avgGreen, avgBlue);
    }

    private double getVolume(Ingredient ingredient) {
        if (ingredient instanceof Fruit) {
           return ((Fruit) ingredient).getVolume();     
        } else if (ingredient instanceof Milk) {
            return ((Milk) ingredient).getVolume();
        }
        else {
            return 0;
        }
    }
    public void getInfo(){
        System.out.println("[blender Info]");
        
        getIngredients();

//        for(Ingredient ingredient : ingredients ){
//            System.out.println(ingredient);
//        }

        System.out.println("Total Calories = "+totalCalories()); 
    }
    
}
