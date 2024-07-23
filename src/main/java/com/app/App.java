package com.app;

import com.app.data.impl.DataImpl;
import com.app.model.Filename;
import com.app.parser.impl.ContentLineParser;
import com.app.parser.impl.FilenameLineParser;
import com.app.parser.impl.UserLineParser;
import com.app.repository.impl.DataRepository;
import com.app.repository.impl.FilenameRepository;
import com.app.repository.impl.UserRepository;
import com.app.processing.impl.DataProcessingImpl;
import com.app.txt.impl.TxtTransfer;
import com.app.txt.load.impl.ContentTxtLoad;
import com.app.txt.load.impl.FilenameTxtLoad;
import com.app.txt.load.impl.UserTxtLoad;
import com.app.txt.save.impl.StringToTxtSave;
import com.app.user.User;
import java.util.HashMap;

/**
 * The main class for the application.
 * This class initializes repositories, processes data, and performs various operations
 * such as adding and removing users, modifying data, and saving data to files.
 */
public class App {

    /**
     * The main method which serves as the entry point for the application.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {

        // USER REPOSITORY
        var userLineParser = new UserLineParser("[1-9][0-9]*;[A-Z0-9]+;[a-z0-9]+;(USER|ADMINISTRATOR)");
        var userTransfer = new TxtTransfer<Long, User>();
        var userRepository = new UserRepository(new UserTxtLoad(userTransfer, userLineParser),"user.txt");
        var users = userRepository.getAll();

        // FILENAME REPOSITORY
        var filenameLineParser = new FilenameLineParser("[1-9][0-9]*;[a-zA-Z0-9]+.txt");
        var filenameTransfer = new TxtTransfer<Long, Filename>();
        var filenameRepository = new FilenameRepository(new FilenameTxtLoad(filenameTransfer, filenameLineParser), "filenames.txt");
        var filenames = filenameRepository.getAll();


        // DATA REPOSITORY
        var contentTransfer = new TxtTransfer<Long,String>();
        var dataRepository = new DataRepository(new ContentTxtLoad(contentTransfer, new ContentLineParser()), filenameRepository);
        var data = new DataImpl(dataRepository);

        // DATA PROCESS
        var dataProcess = new DataProcessingImpl(new HashMap<>());

        // ADD USER
        dataProcess.addUser(users.get(1L), data);
        dataProcess.addUser(users.get(2L), data);
        dataProcess.addUser(users.get(3L), data);
        dataProcess.addUser(users.get(4L), data);

        // REMOVE USER
        dataProcess.removeUser(users.get(4L));

        // PATTERN OCCURRENCES;
        System.out.println("Pattern occurences 'a' for all files");
        System.out.println(dataProcess.getPatternOccurrences(users.get(2L), "[a]"));
        System.out.println("Pattern occurences 'a' for all 'test1.txt'");
        System.out.println(dataProcess.getPatternOccurrences(users.get(3L), "[a]", filenames.get(1L)));

        // MODIFY DATA
        dataProcess.modifyData(users.get(2L), filenames.get(1L), "new example with changes");

        // UPDATE DATA
        dataProcess.updateData(users.get(2L), data);

        // SAVE FILE
        var saveString = new StringToTxtSave(new TxtTransfer<>());
        dataProcess.saveFile(users.get(2L), filenames.get(1L),saveString);
    }
}
