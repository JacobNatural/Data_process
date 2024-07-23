package com.app.data;

import com.app.data.impl.DataImpl;
import com.app.model.Filename;
import com.app.repository.impl.DataRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.HashMap;
import java.util.Map;

import static com.app.data_provider.DataProvider.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings()
public class DataImplModifyValueTest {

    @Mock
    private DataRepository dataRepository;

    @Mock
    private Map<Filename, String> map = new HashMap<>(Map.of(FILENAME1,CONTENT1 ));

    @InjectMocks
    DataImpl dataImpl;

    @Test
    @DisplayName("When the method modifies a value")
    public void test1(){

        Mockito.when(dataRepository.getAll())
                .thenReturn(map);

        dataImpl.modifyValue(FILENAME2, CONTENT2);

        InOrder inorder = Mockito.inOrder(dataRepository, map);
        inorder.verify(dataRepository, Mockito.times(1)).getAll();
        inorder.verify(map, Mockito.times(1)).put(FILENAME2, CONTENT2);

    }
}
