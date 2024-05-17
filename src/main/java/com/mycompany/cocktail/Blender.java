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
    private Logger logger;

    public Blender(double capacity,Logger logger) {
        this.capacity = capacity;
        ingredients = new ArrayList<>();
        this.logger=logger;
    }

    public void addIngredient(Ingredient ingredient) throws BlenderOverFlowException {
        if (totalVolume()+getVolume(ingredient)<=capacity) {
            ingredients.add(ingredient);
            System.out.println(ingredient.getName()+" added to blender");
            this.logger.log(ingredient.getName()+" added to blender");
        }
        else {
            throw new BlenderOverFlowException();
        }
    }
  

    public void blend() {
        System.out.println("Whoops I just pressed the Red button to blend!");
        this.logger.log("Blendig ......");

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
        this.logger.log("Pouring .....");
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
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

    public String getIngredients() {
        String ings ="";
        for(Ingredient ingredient : ingredients ){
            ings+= ingredient; 
        }
        return ings;
     
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
    public String getInfo(){
        String info = "blender Info";
        System.out.println("[blender Info]");
        info+=getIngredients();
        info+= "Total Calories = "+totalCalories();
        return info;
    }
    
}
