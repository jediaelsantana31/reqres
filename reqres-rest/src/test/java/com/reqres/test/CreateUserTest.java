package com.reqres.test;

import com.reqres.service.UserService;
import com.reqres.utils.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CreateUserTest extends BaseTest {

    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }

    @Test
    public void shouldCreateUserSuccessfully() {


    }
}
