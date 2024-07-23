package com.app.txt.load.impl;

import com.app.data_provider.DataProvider;
import com.app.extension.txt.UserTxtLoadExtension;
import com.app.user.User;
import com.app.user.UserType;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

@ExtendWith(UserTxtLoadExtension.class)
@RequiredArgsConstructor
public class UserTxtLoadLoadTest {
    private final UserTxtLoad userTxtLoad;


    @Test
    @DisplayName("When the file loads correctly")
    public void test1(){

        Assertions.assertThat(userTxtLoad.load(DataProvider.userTxtLoadPath()))
                .isEqualTo(Map.of(
                        1L, new User(1L,"JAN","jan123", UserType.USER),
                        2L, new User(2L,"WIKTOR","wiktor123",UserType.ADMINISTRATOR)
                        )
                );
    }
}
