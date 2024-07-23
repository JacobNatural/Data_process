package com.app.txt.load.impl;

import com.app.data_provider.DataProvider;
import com.app.extension.txt.FilenameTxtLoadExtension;
import com.app.model.Filename;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

@ExtendWith(FilenameTxtLoadExtension.class)
@RequiredArgsConstructor
public class FilenameTxtLoadLoadTest {
    private final FilenameTxtLoad filenameTxtLoad;

    @Test
    @DisplayName("When the file loads correctly")
    public void test1(){
        Assertions.assertThat(filenameTxtLoad.load(DataProvider.filenameTxtLoadPath()))
                .isEqualTo(Map.of(
                        1L,new Filename(1L,"F:\\Jaava\\Krzysztof Makowski Java korepetycje\\Projekty\\DataProcess\\src\\test\\resources\\data1.txt"),
                        2L, new Filename(2L,"F:\\Jaava\\Krzysztof Makowski Java korepetycje\\Projekty\\DataProcess\\src\\test\\resources\\data2.txt")
                        )
                );
    }
}

