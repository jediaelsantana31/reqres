package com.reqres.utils;

import io.restassured.RestAssured;

public class BaseTest {

    public BaseTest() {
        RestAssured.baseURI = ProjectSetting.BASE_URL;
    }
}
