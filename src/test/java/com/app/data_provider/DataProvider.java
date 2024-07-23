package com.app.data_provider;

import com.app.data.impl.DataImpl;
import com.app.model.Filename;
import com.app.repository.impl.DataRepository;
import com.app.user.User;
import com.app.user.UserType;
import lombok.SneakyThrows;
import org.junit.jupiter.params.provider.Arguments;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public interface DataProvider {

    // FILENAME
    String FILENAME_SAVE = "text_save.txt";

    // CONTENT
    String SIMPLE_TEXT = "simple_text";
    String CONTENT1 = "content1";
    String CONTENT2 = "some text inside";

    // OBJECT FILENAME
    Filename FILENAME1 = new Filename(  1L, "data1.txt");
    Filename FILENAME2 = new Filename(2L, "data2.txt");
    Filename FILENAME3 = new Filename(3L, "data2.txt");

    // USER
    User USER1 = new User(1L, "sun","sun12", UserType.USER);
    User USER2 = new User(2L, "moon","mon12", UserType.ADMINISTRATOR);
    User USER3 = new User(3L, "saturn","saturn12", UserType.USER);

    // DATA_REPOSITORY
    DataRepository DATA_REPOSITORY = new DataRepository(new HashMap<>(Map.of(
            FILENAME1, "content for found occurrences",
            FILENAME2, "another text for searching")
    ));

    // DATA
    DataImpl DATA_IMPL_1 = new DataImpl(DATA_REPOSITORY);

    static Stream<String> provideIncorrectUserLines(){
        return Stream.of(
                "1;sun:sun12;USER",
                "1;su?;sun12;USER",
                "3;sun:sun12;user",
                "a;sun:sun12;USER"
        );
    }

    static Stream<Arguments> provideCorrectUserLines(){
        return Stream.of(
                Arguments.of(
                        "1;SUN;sun12;USER",
                        Map.of(1L, new User(1L, "SUN", "sun12", UserType.USER))),
                Arguments.of(
                        "1;MOON;moon32;ADMINISTRATOR",
                        Map.of(1L,new User(1L, "MOON", "moon32", UserType.ADMINISTRATOR))),
                        Arguments.of(
                                "9;SATURN;hello12;USER",
                                Map.of(9L,new User(9L,"SATURN", "hello12", UserType.USER))),
                        Arguments.of(
                                "4;WILD12;deep12;USER",
                                Map.of(4L, new User(4L, "WILD12", "deep12", UserType.USER)))
        );
    }

    static Stream<String> provideIncorrectFilenameLines(){
        return Stream.of(
                "1;some.txt.txt",
                "2,hello21.json",
                "4:moon1234.txt",
                "summer:134.txt");
    }

    static Stream<Arguments> provideCorrectFilenameLines(){
        return Stream.of(
                Arguments.of(
                        "1;data.txt",Map.of(1L, new Filename(1L, "data.txt"))),
                Arguments.of(
                        "5;content123.txt", Map.of(5L,new Filename(5L, "content123.txt"))),
                Arguments.of(
                        "3;DATA1.txt", Map.of(3L,new Filename(3L, "DATA1.txt"))),
                Arguments.of(
                        "4;Data4.txt", Map.of(4L, new Filename(4L, "Data4.txt"))));
    }






    @SneakyThrows
    static String userTxtLoadPath(){

        String FILENAME_LOAD = "user_test.txt";

        return Paths.get(DataProvider.class.getClassLoader().getResource(FILENAME_LOAD).toURI()).toString();
    }

    @SneakyThrows
    static String filenameTxtLoadPath(){

        String FILENAME_LOAD = "filename_text.txt";

        return Paths.get(DataProvider.class.getClassLoader().getResource(FILENAME_LOAD).toURI()).toString();
    }

    @SneakyThrows
    static Map<Long, Filename> filenameTxtLoadList(){
        return Map.of(1L, new Filename(1L,Paths.get(DataProvider.class.getClassLoader().getResource("data1.txt").toURI()).toString()),
                2L,new Filename(2L,Paths.get(DataProvider.class.getClassLoader().getResource("data1.txt").toURI()).toString()));
    }

    @SneakyThrows
    static String contentTxtLoadPath(){

        String FILENAME_LOAD = "content_text.txt";

        return Paths.get(DataProvider.class.getClassLoader().getResource(FILENAME_LOAD).toURI()).toString();
    }



    @SneakyThrows
    static String simpleTransferText(){

        String FILENAME_LOAD = "simple_transfer_text.txt";

        return Paths.get(DataProvider.class.getClassLoader().getResource(FILENAME_LOAD).toURI()).toString();

    }


 }
