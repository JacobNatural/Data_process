package com.app.txt.load.impl;

import com.app.parser.LineParser;
import com.app.txt.Transfer;
import com.app.txt.load.Load;
import com.app.txt.load.generic.LoadFromTxt;
import com.app.user.User;

/**
 * A concrete implementation of the Load interface for loading User data from a text file.
 * It extends the abstract LoadFromTxt class to provide specific functionality for User data.
 *
 * @param <T> the type of the keys in the data (Long in this case)
 * @param <U> the type of the values in the data (User in this case)
 */
public class UserTxtLoad extends LoadFromTxt<Long, User> implements Load<Long, User> {

    /**
     * Constructs a UserTxtLoad instance with the specified Transfer and LineParser.
     *
     * @param transfer the Transfer instance used for reading data from a file
     * @param lineParser the LineParser instance used for parsing lines of data
     */
    public UserTxtLoad(Transfer<Long, User> transfer, LineParser<Long, User> lineParser) {
        super(transfer, lineParser);
    }
}
