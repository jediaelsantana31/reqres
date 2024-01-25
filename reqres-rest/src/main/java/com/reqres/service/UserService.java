package com.reqres.service;

import com.reqres.pojo.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserService {

    public Response createUser(User user) {
        return given()
                .contentType(ContentType.JSON)
                .body(user)
                .post("/users");
    }

}
