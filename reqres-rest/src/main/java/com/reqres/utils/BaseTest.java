package com.reqres.utils;

import io.restassured.RestAssured;

public class BaseTest {

    public BaseTest() {
        RestAssured.baseURI = "https://reqres.in/api";
    }
}
