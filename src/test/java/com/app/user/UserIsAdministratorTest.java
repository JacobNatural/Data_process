package com.app.user;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class UserIsAdministratorTest {



    @Test
    @DisplayName("When the user is an administrator")
    public void test1(){

        var user = new User(1L, "Moon", "moon123", UserType.ADMINISTRATOR);

        Assertions.assertThat(user.isAdministrator()).isTrue();
    }

    @Test
    @DisplayName("When user is not an administrator")
    public void test2(){

        var user = new User(1L, "Moon", "moon123", UserType.USER);

        Assertions.assertThat(user.isAdministrator()).isFalse();

    }
}
