package com.app.txt.load.impl;

import com.app.data_provider.DataProvider;
import com.app.extension.txt.ContentTxtLoadExtension;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

@ExtendWith(ContentTxtLoadExtension.class)
@RequiredArgsConstructor
public class ContentTxtLoadLoadTest {
    private final ContentTxtLoad contentTxtLoad;

    @Test
    @DisplayName("When the file loads correctly")
    public void test1(){
        Assertions.assertThat(contentTxtLoad.load(DataProvider.contentTxtLoadPath()))
                .isEqualTo(Map.of(
                                1L,"first\nsecond\nthird")
                );
    }

}
