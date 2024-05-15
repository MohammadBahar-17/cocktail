/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cocktail;

/**
 *
 * @author bahar
 */
public class Cup {
    private  double capacity;
    private  Contents contents;
    
    public Cup(double capacity) {
        this.contents = new Contents();
        this.capacity = capacity;
    }

    public double getCapacity() {
        return capacity;
    }

    public Contents getContents() {
        return this.contents;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }
    
    
    public  class Contents {
        private double calories;
        private RGBColor color;
        private double volume;

        public void setCalories(double calories) {
            this.calories = calories;
        }

        public double getCalories() {
            return calories;
        }

        public void setColor(RGBColor color) {
            this.color = color;
        }

        public RGBColor getColor() {
            return color;
        }

        public void setVolume(double volume) {
            this.volume = volume ;
        }

        public double getVolume() {
            return volume;
        }
    }
    public String getInfo() {
       return ("[Cup contents]")+
        ("- Total capacity: " + capacity)+
        ("- Mixture volume: " + contents.getVolume())+
       ("- Mixture calories: " + contents.getCalories())+
       ("- Mixture color: " + contents.getColor());
    }


}
