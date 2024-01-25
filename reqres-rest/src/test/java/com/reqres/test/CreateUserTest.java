package com.reqres.test;

import com.github.javafaker.Faker;
import com.reqres.pojo.User;
import com.reqres.service.UserService;
import com.reqres.utils.BaseTest;
import com.reqres.utils.ProjectSetting;
import com.reqres.validation.UserValidation;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateUserTest extends BaseTest {

    private UserService userService;
    private Faker faker;


    @BeforeEach
    public void setUp() {
        userService = new UserService();
        faker = new Faker();

    }

    @Test
    public void shouldCreateUserSuccessfully() {
        User user = new User();
        user.setName(faker.name().firstName());
        user.setJob(faker.job().title());

        UserValidation userValidation = userService.createUser(user);

        userValidation.assertStatusCode(HttpStatus.SC_CREATED)
                .assertResponseSchema(ProjectSetting.CREATE_SCHEMA_PATH)
                .assertResponseContract();

        //  assertResponseStatus(response, 201);
        //assertResponseBody(response, user);
        //assertResponseContract(response);
    }
}
