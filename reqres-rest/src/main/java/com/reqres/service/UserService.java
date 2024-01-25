package com.reqres.service;

import com.reqres.pojo.User;
import com.reqres.validation.UserValidation;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    public UserValidation createUser(User user) {
        Response response = given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/users");

        return new UserValidation(user, response.then());
    }

}
