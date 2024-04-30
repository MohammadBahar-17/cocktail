package com.mycompany.cocktail;

public class Mixture extends Ingredient implements TangibleIngredient {
    private  double volume;
    private  RGBColor rgbColor;

    public Mixture(double volume, RGBColor rgbColor, double calories) {
        super("Mixture", calories);
        this.volume = volume;
        this.rgbColor = rgbColor;
    }

    @Override
    public double getVolume() {
        return volume;
    }

    @Override
    public RGBColor getColor() {
        return rgbColor;
    }

    @Override
    public String toString() {
        return "{" + "volume=" + volume + ", rgbColor=" + rgbColor + '}';
    }
    
}
