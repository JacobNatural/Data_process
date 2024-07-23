package com.app.processing;

import com.app.processing.impl.DataProcessingImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static com.app.data_provider.DataProvider.*;

public class DataImplProcessingRemoveUserTest {

    @Test
    @DisplayName("When the user is null")
    public void test1(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>());

        Assertions.assertThatThrownBy(
                () -> dataProcessingImpl.removeUser(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User cannot be null");
    }

    @Test
    @DisplayName("When removing a user who does not exists")
    public void test2(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>(Map.of(USER2, DATA_IMPL_1)));

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.removeUser(USER1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User does not exist");
    }

    @Test
    @DisplayName("When removing a user from empty map")
    public void test3(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>());

        Assertions.assertThatThrownBy(
                        () -> dataProcessingImpl.removeUser(USER1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("User does not exist");
    }

    @Test
    @DisplayName("When removing a user without throwing an exception")
    public void test4(){
        DataProcessingImpl dataProcessingImpl = new DataProcessingImpl(new HashMap<>(Map.of(USER2, DATA_IMPL_1)));

        Assertions.assertThatNoException().isThrownBy(
                        () -> dataProcessingImpl.removeUser(USER2));
    }

}
