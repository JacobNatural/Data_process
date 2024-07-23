package com.app.txt.load.generic;

import com.app.parser.LineParser;
import com.app.txt.Transfer;
import com.app.txt.load.Load;
import lombok.RequiredArgsConstructor;

import java.util.Map;

/**
 * An abstract class that implements the Load interface for loading data from a text file.
 * It uses a Transfer instance to handle reading data and a LineParser to parse the lines.
 *
 * @param <T> the type of the keys in the data
 * @param <U> the type of the values in the data
 */
@RequiredArgsConstructor
public abstract class LoadFromTxt<T, U> implements Load<T, U> {

    /**
     * The Transfer instance used for reading data from a file.
     */
    private final Transfer<T, U> transfer;

    /**
     * The LineParser instance used for parsing lines of data.
     */
    private final LineParser<T, U> lineParser;

    /**
     * Loads data from the specified text file using the Transfer and LineParser instances.
     *
     * @param filename the name of the file to load data from
     * @return a map containing the loaded data, where the key is of type T and the value is of type U
     */
    @Override
    public Map<T, U> load(String filename) {
        return transfer.readData(filename, lineParser);
    }
}
