package com.app.txt.load.impl;

import com.app.parser.LineParser;
import com.app.txt.Transfer;
import com.app.txt.load.Load;
import com.app.txt.load.generic.LoadFromTxt;

/**
 * A concrete implementation of the Load interface for loading content data from a text file.
 * It extends the abstract LoadFromTxt class to provide specific functionality for content data.
 *
 * The type of the keys in the data (Long in this case)
 * The type of the values in the data (String in this case)
 */
    public class ContentTxtLoad extends LoadFromTxt<Long, String> implements Load<Long, String> {

    /**
     * Constructs a ContentTxtLoad instance with the specified Transfer and LineParser.
     *
     * @param transfer the Transfer instance used for reading data from a file
     * @param lineParser the LineParser instance used for parsing lines of data
     */
    public ContentTxtLoad(Transfer<Long, String> transfer, LineParser<Long, String> lineParser) {
        super(transfer, lineParser);
    }
}