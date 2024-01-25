package com.reqres.service;

import com.reqres.pojo.User;
import com.reqres.validation.UserValidation;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    private static final String BASE_PATH = "/api/users";
    private String currentEndpoint = BASE_PATH;

    public UserService setEndpoint(String endpoint) {
        this.currentEndpoint = endpoint;
        return this;
    }

    public UserValidation createUser(User user) {
        Response response = given()
                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(user)
                .post(currentEndpoint);

        return new UserValidation(user, response.then());
    }

}
