package com.reqres.validation;

import com.reqres.pojo.User;
import io.restassured.response.ValidatableResponse;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UserValidation extends GenericValidation<UserValidation> {
    private User user;

    public UserValidation(User user, ValidatableResponse response) {
        super(response);
        this.user = user;
    }

    public UserValidation assertResponseContract() {
        response.body("name", equalTo(user.getName()));
        response.body("job", equalTo(user.getJob()));
        response.body("id", notNullValue());
        response.body("createdAt", notNullValue());
        return this;
    }

}
