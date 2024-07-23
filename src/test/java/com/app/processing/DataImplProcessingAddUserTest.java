package com.app.processing;

import com.app.processing.impl.DataProcessingImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.app.data_provider.DataProvider.*;


public class DataImplProcessingAddUserTest {

    @Test
    @DisplayName("When the user is null")
    public void test1(){

        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(Map.of());
        Assertions.assertThatThrownBy(
                () -> dataProcessingImpl.addUser(null, DATA_IMPL_1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User cannot be null");
    }

    @Test
    @DisplayName("When the data is null")
    public void test2(){

        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(Map.of());
        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.addUser(USER1, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Data cannot be null");
    }



    @Test
    @DisplayName("When adding a user and the user already exists")
    public void test3(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(Map.of(USER1, DATA_IMPL_1));

        Assertions.assertThatThrownBy(
                () -> dataProcessingImpl.addUser(USER1, DATA_IMPL_1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("The user already exists");
    }

    @Test
    @DisplayName("When the method add a user without throwing an exception")
    public void test4(){

        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>());

        Assertions.assertThatNoException().isThrownBy(
                () -> dataProcessingImpl.addUser(USER1, DATA_IMPL_1));
    }
}
