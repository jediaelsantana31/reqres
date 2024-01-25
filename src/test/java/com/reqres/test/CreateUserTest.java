package com.reqres.test;

import com.reqres.pojo.User;
import com.reqres.service.UserService;
import com.reqres.utils.BaseTest;
import com.reqres.utils.ProjectSetting;
import com.reqres.validation.UserValidation;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Feature("User Registration")
public class CreateUserTest extends BaseTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @ParameterizedTest
    @ValueSource(booleans = {true, false})
    @DisplayName("givenValidUser_whenCreateUser_thenTheUserIsRegistered")
    public void givenValidUser_whenCreateUser_thenTheUserIsRegistered(boolean withName) {
        User user = generateUserWithJobAndRandomName(withName);

        UserValidation userValidation = userService.createUser(user);

        userValidation.assertStatusCode(HttpStatus.SC_CREATED)
                .assertResponseSchema(ProjectSetting.CREATE_SCHEMA_PATH)
                .assertResponseContract();
    }

    @Test
    @DisplayName("givenValidUser_whenCreatingUserWithInvalidEndpoint_thenShouldReturn404StatusCode")
    public void givenValidUser_whenCreatingUserWithInvalidEndpoint_thenShouldReturn404StatusCode() {
        User user = generateUserWithJobAndRandomName(true);

        UserValidation userValidation = userService.setEndpoint("nonexistentEndpoint").createUser(user);

        userValidation.assertStatusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    @DisplayName("givenValidUser_whenCreatingUserWithInvalidBody_thenShouldReturn400StatusCode")
    public void givenValidUser_whenCreatingUserWithInvalidBody_thenShouldReturn400StatusCode() {
        User user = generateInvalidUserWithoutName();

        UserValidation userValidation = userService.createUser(user);

        userValidation.assertStatusCode(HttpStatus.SC_BAD_REQUEST);
    }


}
