/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cocktail;

import java.util.Scanner;

// final until now


/**
 *
 * @author bahar
 */
public class Cocktail {
    public static void main(String[] args) {
        RGBColor red = new RGBColor(255, 0, 0);
        RGBColor green = new RGBColor(0, 255, 0);
        RGBColor yellow = new RGBColor(0, 0, 255);
        RGBColor white = new RGBColor(255, 255, 255);  
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Welcome to the Cocktail Maker! Create your own drink!");
         System.out.print("Enter blender capacity (ml): ");
        double blenderCapacity = scanner.nextDouble();
        Blender blender = new Blender(blenderCapacity);
        System.out.print("Enter cup capacity (ml): ");
        double cupCapacity = scanner.nextDouble();
        Cup cup = new Cup(cupCapacity);
        while (true) {
            System.out.println("\nWhat ingredient would you like to add?");
            System.out.println("1. Custom fruits");
            System.out.println("2. Add Milk ");
            System.out.println("3. Sugar (16 calories)");
            System.out.println("4. I'm done adding ingredients");
             int choice = scanner.nextInt();
             
            if (choice == 4) {
                break;
            }

            Ingredient ingredient ;
            switch (choice) {
               case 1:
                   System.out.println("enter name of the fruit");
                   String fruit=scanner.next();
                   System.out.println("enter your calories");
                   int calories=scanner.nextInt();
                   System.out.println("entter your volume (ml)");
                   int volume=scanner.nextInt();
                   System.out.println("enter the color of the fruit as int,int,int");
                   RGBColor color=new RGBColor(scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
                   ingredient = new Fruit(fruit, calories, volume,color);  
                   try {
                        blender.addIngredient(ingredient);
                    } catch (BlenderOverFlowException ex) {
                       ex.getMessage();
                    }     
                    break;                   
                   
               case 2:
                   System.out.println("enter your calories");
                   int caloriess=scanner.nextInt();
                   System.out.println("entter your volume (ml)");
                   int volumee=scanner.nextInt();
                   ingredient = new Milk("milk",caloriess,volumee , white);
                     try {
                        blender.addIngredient(ingredient);
                    } catch (BlenderOverFlowException ex) {
                       ex.getMessage();
                    }     
                    break;
                case 3:
                    ingredient = new Sugar("Sugar",16);
                     try {
                        blender.addIngredient(ingredient);
                    } catch (BlenderOverFlowException ex) {
                       ex.getMessage();
                    }     
                    
                    break;
                default:
                    System.out.println("Invalid choice!");
            }          
              
         }
        blender.blend();

         try {
            blender.pour(cup);
        }
           catch (CupsOverFlowException | EmptyBlenderException ex) {
            System.out.println(ex.getMessage());
        }
           
        blender.getInfo();
        cup.getInfo();
    }
}



