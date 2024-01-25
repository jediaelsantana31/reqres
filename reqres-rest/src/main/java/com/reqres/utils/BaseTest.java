package com.reqres.utils;

import com.github.javafaker.Faker;
import com.reqres.pojo.User;
import io.restassured.RestAssured;

public class BaseTest {
    private Faker faker;

    public BaseTest() {
        RestAssured.baseURI = ProjectSetting.BASE_URL;
        faker = new Faker();
    }

    public User generateUserWithJobAndRandomName(boolean withName) {
        User user = new User();
        user.setJob(faker.job().title());

        if (withName) {
            user.setName(faker.name().firstName());
        }

        return user;
    }

    public User generateInvalidUserWithoutName() {
        User user = new User();
        user.setJob(faker.job().title());
        user.setName(null);
        return user;
    }
}
