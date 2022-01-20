package com.example.graphqlexample.exception;


public class FoodNotFoundEception extends RuntimeException {
    public FoodNotFoundEception(String message){
        super(message);
    }
}
