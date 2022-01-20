package com.example.graphqlexample.exception;

import graphql.GraphQLException;
import graphql.kickstart.spring.error.ThrowableGraphQLError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component
public class GraphQLExceptionHandler  {

    @ExceptionHandler(GraphQLException.class)
    public ThrowableGraphQLError handle(GraphQLException e){
        return new ThrowableGraphQLError(e);
    }

}
