package com.app.repository;


import com.app.data_provider.DataProvider;
import com.app.repository.impl.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UserRepositoryTest {

    @Test
    @DisplayName("When the load is null")
    public void test1(){

        Assertions.assertThatThrownBy(
                () -> new UserRepository(null, DataProvider.userTxtLoadPath()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Load cannot be null");
    }
}
