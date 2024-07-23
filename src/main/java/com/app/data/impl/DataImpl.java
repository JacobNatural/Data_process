package com.app.data.impl;

import com.app.data.Data;
import com.app.model.Filename;
import com.app.repository.impl.DataRepository;
import com.app.txt.save.Save;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * The Data class provides methods for modifying, saving, checking, and counting occurrences of patterns in file data.
 * It interacts with a DataRepository to perform these operations.
 */
@RequiredArgsConstructor
public class DataImpl implements Data {
    private final DataRepository data;

    /**
     * Modifies the content of a file identified by the given filename.
     *
     * @param filename   the identifier of the file to be modified.
     * @param newContent the new content to replace the existing content.
     */
    public void modifyValue(Filename filename, String newContent){
        data.getAll().put(filename, newContent);
    }

    /**
     * Saves the content of a file identified by the given filename using the specified save strategy.
     *
     * @param filename the identifier of the file to be saved.
     * @param save     the save strategy to use for saving the file content.
     */
    public void saveFile(Filename filename, Save<String> save){
        save.save(filename.filename(), data.getAll().get(filename), x -> x);
    }

    /**
     * Checks if a file identified by the given filename exists in the repository.
     *
     * @param filename the identifier of the file to check.
     * @return true if the file exists, false otherwise.
     */
    public boolean containFile(Filename filename){
        return data.getAll().containsKey(filename);
    }

    /**
     * Counts the total occurrences of a pattern specified by the given regex in all file contents.
     *
     * @param regex the regular expression pattern to search for.
     * @return the total number of occurrences of the pattern.
     */
    public long countPatternOccurrences(String regex){
        return data
                .getAll()
                .values()
                .stream()
                .map(content -> countPatternOccurrences(content, regex))
                .collect(Collectors.summarizingInt(x -> x)).getSum();
    }

    /**
     * Counts the occurrences of a pattern specified by the given regex in the content of a file identified by the given filename.
     *
     * @param regex    the regular expression pattern to search for.
     * @param filename the identifier of the file whose content will be searched.
     * @return the number of occurrences of the pattern in the file content.
     */
    public long countPatternOccurrences(String regex, Filename filename){
        return countPatternOccurrences(data.getAll().get(filename), regex);
    }

    /**
     * Counts the occurrences of a pattern specified by the given regex in the given content.
     *
     * @param content the content to search for the pattern.
     * @param regex   the regular expression pattern to search for.
     * @return the number of occurrences of the pattern in the content.
     */
    private int countPatternOccurrences(String content, String regex){
        int count = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()){
            count++;
        }
        return count;
    }
}

