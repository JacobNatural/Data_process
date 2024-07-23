package com.app.data;

import com.app.data.impl.DataImpl;
import com.app.data_provider.DataProvider;
import com.app.repository.impl.DataRepository;
import com.app.txt.impl.TxtTransfer;
import com.app.txt.save.impl.StringToTxtSave;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.stream.Collectors;

@ExtendWith(MockitoExtension.class)
@MockitoSettings()
public class DataImplSaveFileTest {

    @Mock
    DataRepository dataRepository;

    @InjectMocks
    DataImpl dataImpl;

    @Test
    @DisplayName("When the save filename")
    @SneakyThrows
    public void test1(){

        Mockito.when(dataRepository.getAll())
                .thenReturn(Map.of(
                        DataProvider.FILENAME1,"content",
                        DataProvider.FILENAME2,"content2")
                );

        dataImpl.saveFile(DataProvider.FILENAME1, new StringToTxtSave(new TxtTransfer<>()));

        try(var lines = Files.lines(Path.of(DataProvider.FILENAME1.filename()))){
            Assertions.assertThat(lines.collect(Collectors.joining("\n")))
                    .isEqualTo("content");
        }
    }

    @AfterAll
    @SneakyThrows
    public static void cleanData(){
        Files.deleteIfExists(Path.of(DataProvider.FILENAME1.filename()));
    }
}
