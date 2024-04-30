package com.mycompany.cocktail;

public class EmptyBlenderException extends Exception {

    @Override
    public String getMessage() {
        return "Empty blender exception";
    }
}
