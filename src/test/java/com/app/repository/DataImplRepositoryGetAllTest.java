package com.app.repository;

import com.app.extension.repistory.DataRepositoryExtension;
import com.app.model.Filename;
import com.app.repository.impl.DataRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import java.util.Map;


@ExtendWith(DataRepositoryExtension.class)
@RequiredArgsConstructor
public class DataImplRepositoryGetAllTest {

    private final DataRepository dataRepository;

    @Test
    @DisplayName("When the user repository contains correct data")
    public void test1(){

        Assertions.assertThat(dataRepository.getAll())
                .isEqualTo(
                        Map.of(new Filename(
                                1L,
                                "F:\\Jaava\\Krzysztof Makowski Java korepetycje\\Projekty\\DataProcess\\src\\test\\resources\\data1.txt"),
                                "some text\n" +
                                        "for testing",
                                new Filename(2L, "F:\\Jaava\\Krzysztof Makowski Java korepetycje\\Projekty\\DataProcess\\src\\test\\resources\\data2.txt"),
                                "another text\n" +
                                        "for testing\n" +
                                        "and analyze"));


    }


}
