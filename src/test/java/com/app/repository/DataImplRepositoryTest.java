package com.app.repository;

import com.app.data_provider.DataProvider;
import com.app.extension.repistory.FilenameRepositoryExtension;
import com.app.extension.txt.ContentTxtLoadExtension;
import com.app.repository.impl.DataRepository;
import com.app.repository.impl.FilenameRepository;
import com.app.txt.load.impl.ContentTxtLoad;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith({FilenameRepositoryExtension.class, ContentTxtLoadExtension.class})
@RequiredArgsConstructor
public class DataImplRepositoryTest {

    private final FilenameRepository filenameRepository;
    private final ContentTxtLoad contentTxtLoad;

    @Test
    @DisplayName("When the load is null")
    public void test1(){
        Assertions.assertThatThrownBy(
                        () -> new DataRepository(null,filenameRepository ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Load cannot be null");
    }

    @Test
    @DisplayName("When the filename repository is null")
    public void test2(){
        Assertions.assertThatThrownBy(
                        () -> new DataRepository(contentTxtLoad,null ))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Repository cannot be null");
    }
}
