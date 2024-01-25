package com.reqres.validation;

import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.ValidatableResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GenericValidation<T extends GenericValidation<T>> {
    protected ValidatableResponse response;

    public GenericValidation(ValidatableResponse response) {
        this.response = response;
    }

    @SuppressWarnings("unchecked")
    public T assertStatusCode(int expectedStatusCode) {
        response.statusCode(expectedStatusCode);
        return (T) this;
    }

    @SuppressWarnings("unchecked")
    public T assertResponseSchema(String schemaFileName) {
        try {
            String schemaContent = new String(Files.readAllBytes(Paths.get(schemaFileName)));
            response.body(JsonSchemaValidator.matchesJsonSchema(schemaContent));
        } catch (IOException e) {
            throw new RuntimeException("Error reading schema file", e);
        }

        return (T) this;
    }
}
