package com.example.graphqlexample.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class FoodNotFoundEception extends RuntimeException implements GraphQLError {
    public FoodNotFoundEception(String message){
        super(message);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
