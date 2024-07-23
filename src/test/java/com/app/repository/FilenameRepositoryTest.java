package com.app.repository;

import com.app.data_provider.DataProvider;
import com.app.repository.impl.FilenameRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FilenameRepositoryTest {
    @Test
    @DisplayName("When the load is null")
    public void test1(){

        Assertions.assertThatThrownBy(
                        () -> new FilenameRepository(null, DataProvider.userTxtLoadPath()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Load cannot be null");
    }
}
