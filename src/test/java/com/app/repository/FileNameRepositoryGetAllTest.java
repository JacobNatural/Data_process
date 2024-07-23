package com.app.repository;

import com.app.extension.repistory.FilenameRepositoryExtension;
import com.app.model.Filename;
import com.app.repository.impl.FilenameRepository;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

@ExtendWith(FilenameRepositoryExtension.class)
@RequiredArgsConstructor
public class FileNameRepositoryGetAllTest {
    private final FilenameRepository filenameRepository;

    @Test
    @DisplayName("When the user repository contains correct data")
    public void test1(){


        Assertions.assertThat(filenameRepository.getAll())
                .isEqualTo(Map.of(
                        1L,new Filename(1L,"F:\\Jaava\\Krzysztof Makowski Java korepetycje\\Projekty\\DataProcess\\src\\test\\resources\\data1.txt"),
                        2L, new Filename(2L,"F:\\Jaava\\Krzysztof Makowski Java korepetycje\\Projekty\\DataProcess\\src\\test\\resources\\data2.txt")
                ));
    }
}

