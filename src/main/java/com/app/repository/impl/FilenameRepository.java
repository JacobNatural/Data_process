package com.app.repository.impl;

import com.app.model.Filename;
import com.app.repository.Repository;
import com.app.txt.load.Load;

import java.util.Map;

/**
 * The FilenameRepository class implements the Repository interface for managing filename data.
 * It loads filename data from a file and provides access to the data through a map.
 */
public class FilenameRepository implements Repository<Long, Filename> {

    private final Map<Long, Filename> filenames;

    /**
     * Constructs a FilenameRepository with filename data loaded from a file.
     *
     * @param load the Load strategy used to load filename data
     * @param filename the name of the file containing filename data
     * @throws IllegalArgumentException if the load strategy is null
     */
    public FilenameRepository(Load<Long, Filename> load, String filename) {
        if (load == null) {
            throw new IllegalArgumentException("Load cannot be null");
        }
        this.filenames = load.load(filename);
    }

    /**
     * Retrieves all filenames in the repository.
     *
     * @return a map containing all filenames, where the key is the filename ID (Long) and the value is the Filename object
     */
    @Override
    public Map<Long, Filename> getAll() {
        return filenames;
    }
}
