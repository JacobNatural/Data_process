package com.app.txt.save.generic;

import com.app.txt.Transfer;
import com.app.txt.save.Save;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;

import java.util.function.Function;

/**
 * Abstract implementation of the {@link Save} interface for saving data to a text file.
 *
 * <p>This class provides a generic way to save data of type {@code T} to a text file by using
 * a {@link Transfer} mechanism that handles the actual writing process. It requires a {@link Function}
 * to convert the data of type {@code T} into a {@link String} representation.</p>
 *
 * @param <T> the type of data to be saved
 * @see Save
 * @see Transfer
 */
@AllArgsConstructor
public abstract class SaveToTxt<T> implements Save<T> {

    private final Transfer<T, String> transfer;

    /**
     * Saves the specified data to a file.
     *
     * <p>This method converts the data of type {@code T} into a {@link String} using the provided
     * {@link Function} and then uses the {@link Transfer} instance to write the data to the specified file.</p>
     *
     * @param filename the name of the file to save data to
     * @param t the data to be saved
     * @param prepare a {@link Function} that converts data of type {@code T} into a {@link String}
     * @throws IllegalArgumentException if any argument is {@code null} or if {@code filename} is empty
     * @throws Exception if an I/O error occurs during file operations
     */
    @Override
    @SneakyThrows
    public void save(String filename, T t, Function<T, String> prepare) {
        transfer.writeData(filename, t, prepare);
    }
}
