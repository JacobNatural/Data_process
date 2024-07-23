package com.app.repository;

import com.app.extension.repistory.UserRepositoryExtension;
import com.app.repository.impl.UserRepository;
import com.app.user.User;
import com.app.user.UserType;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

@ExtendWith(UserRepositoryExtension.class)
@RequiredArgsConstructor
public class UserRepositoryGetAllTest {
    private final UserRepository userRepository;

    @Test
    @DisplayName("When the user repository contains correct data")
    public void test1(){
        Assertions.assertThat(userRepository.getAll())
                .isEqualTo(Map.of(
                        1L, new User(1L,"JAN","jan123", UserType.USER),
                        2L, new User(2L,"WIKTOR","wiktor123",UserType.ADMINISTRATOR)
                ));
    }
}
