package com.app.txt.load.impl;

import com.app.model.Filename;
import com.app.parser.LineParser;
import com.app.txt.Transfer;
import com.app.txt.load.Load;
import com.app.txt.load.generic.LoadFromTxt;

/**
 * A concrete implementation of the Load interface for loading Filename data from a text file.
 * It extends the abstract LoadFromTxt class to provide specific functionality for Filename data.
 *
 * @param <T> the type of the keys in the data (Long in this case)
 * @param <U> the type of the values in the data (Filename in this case)
 */
public class FilenameTxtLoad extends LoadFromTxt<Long, Filename> implements Load<Long, Filename> {

    /**
     * Constructs a FilenameTxtLoad instance with the specified Transfer and LineParser.
     *
     * @param transfer the Transfer instance used for reading data from a file
     * @param lineParser the LineParser instance used for parsing lines of data
     */
    public FilenameTxtLoad(Transfer<Long, Filename> transfer, LineParser<Long, Filename> lineParser) {
        super(transfer, lineParser);
    }
}