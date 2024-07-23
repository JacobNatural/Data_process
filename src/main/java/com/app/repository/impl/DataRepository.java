package com.app.repository.impl;

import com.app.model.Filename;
import com.app.repository.Repository;
import com.app.txt.load.Load;
import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * The DataRepository class implements the Repository interface for managing file data.
 * It maps filenames to their corresponding content based on data loaded from a file and another repository.
 */
@RequiredArgsConstructor
public class DataRepository implements Repository<Filename, String> {

    private final Map<Filename, String> dates;

    /**
     * Constructs a DataRepository with file data loaded from a file and a repository of filenames.
     *
     * @param load the Load strategy used to load file data
     * @param repository the Repository that provides filenames
     * @throws IllegalArgumentException if the load strategy or repository is null
     */
    public DataRepository(Load<Long, String> load, Repository<Long, Filename> repository) {
        if (load == null) {
            throw new IllegalArgumentException("Load cannot be null");
        }

        if (repository == null) {
            throw new IllegalArgumentException("Repository cannot be null");
        }
        dates = repository
                .getAll()
                .values()
                .stream()
                .map(filename -> getModel(load, filename))
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    /**
     * Loads data associated with a given filename and creates a map entry.
     *
     * @param load the Load strategy used to load file data
     * @param filename the filename for which data is to be loaded
     * @return a map containing the filename and its corresponding content
     */
    private Map<Filename, String> getModel(Load<Long, String> load, Filename filename) {
        return Map.of(
                filename, load.load(filename.filename()).get(1L));
    }

    /**
     * Retrieves all file data in the repository.
     *
     * @return a map containing all file data, where the key is the Filename object and the value is the file content (String)
     */
    @Override
    public Map<Filename, String> getAll() {
        return dates;
    }
}