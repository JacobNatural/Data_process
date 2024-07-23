package com.app.processing.impl;

import com.app.data.impl.DataImpl;
import com.app.model.Filename;
import com.app.processing.DataProcessing;
import com.app.txt.save.Save;
import com.app.user.User;
import lombok.AllArgsConstructor;

import java.util.Map;

/**
 * The DataProcessing class provides methods for managing and processing data associated with users.
 * It supports adding, removing, and updating user-data associations, as well as performing various
 * operations on the data such as counting pattern occurrences and saving files.
 */
@AllArgsConstructor
public class DataProcessingImpl implements DataProcessing {

    private final Map<User, DataImpl> dataProcess;

    /**
     * Adds a user and their associated data to the data process map.
     * Throws an exception if the user or data is null, or if the user already exists in the map.
     *
     * @param user the user to be added
     * @param dataImpl the data associated with the user
     */
    public void addUser(User user, DataImpl dataImpl){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }

        if(dataImpl == null){
            throw new IllegalArgumentException("Data cannot be null");
        }

        if(dataProcess.containsKey(user)){
            throw new IllegalArgumentException("The user already exists");
        }

        dataProcess.put(user, dataImpl);
    }

    /**
     * Removes a user and their associated data from the data process map.
     * Throws an exception if the user is null or if the user does not exist in the map.
     *
     * @param user the user to be removed
     */
    public void removeUser(User user){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }

        if(!dataProcess.containsKey(user)){
            throw new IllegalArgumentException("User does not exist");
        }

        dataProcess.remove(user);
    }

    /**
     * Updates the data associated with an existing user.
     * Throws an exception if the user or data is null, if the user does not exist in the map,
     * or if the data is to be updated for a non-existing user.
     *
     * @param user the user whose data is to be updated
     * @param dataImpl the new data to associate with the user
     */
    public void updateData(User user, DataImpl dataImpl){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }

        if(dataImpl == null){
            throw new IllegalArgumentException("Data cannot be null");
        }

        if(!dataProcess.containsKey(user)){
            throw new IllegalArgumentException("User does not exist");
        }

        dataProcess.put(user, dataImpl);
    }

    /**
     * Counts the occurrences of a pattern in the data associated with a specific user.
     * Throws an exception if the user is null, if the regex is null or empty, or if the user does not exist.
     *
     * @param user the user whose data is to be processed
     * @param regex the regular expression pattern to count occurrences of
     * @return the number of occurrences of the pattern in the user's data
     */
    public long getPatternOccurrences(User user, String regex) {
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }

        if(regex == null){
            throw new IllegalArgumentException("Regex cannot be null");
        }

        if(regex.isEmpty()){
            throw new IllegalArgumentException("Regex cannot be empty");
        }

        if (!dataProcess.containsKey(user)) {
            throw new IllegalArgumentException("User not exist");
        }

        return dataProcess.get(user).countPatternOccurrences(regex);
    }

    /**
     * Counts the occurrences of a pattern in a specific file's data associated with a user.
     * Throws an exception if the user, regex, or filename is null, if the regex is empty, if the user does not exist,
     * or if the file does not exist for the user.
     *
     * @param user the user whose data is to be processed
     * @param regex the regular expression pattern to count occurrences of
     * @param filename the filename whose data is to be processed
     * @return the number of occurrences of the pattern in the file's data
     */
    public long getPatternOccurrences(User user, String regex, Filename filename){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }

        if(regex == null){
            throw new IllegalArgumentException("Regex cannot be null");
        }

        if(filename == null){
            throw new IllegalArgumentException("Filename cannot be null");
        }

        if(regex.isEmpty()){
            throw new IllegalArgumentException("Regex cannot be empty");
        }

        if (!dataProcess.containsKey(user)) {
            throw new IllegalArgumentException("User not exist");
        }

        if(!dataProcess.get(user).containFile(filename)){
            throw new IllegalArgumentException("File not exist");
        }

        return dataProcess.get(user).countPatternOccurrences(regex, filename);
    }

    /**
     * Modifies the content of a file associated with a user.
     * Throws an exception if the user, filename, or new content is null or empty,
     * if the user does not exist, if the file does not exist, or if the user is not an administrator.
     *
     * @param user the user whose file is to be modified
     * @param fileName the filename of the file to be modified
     * @param newContent the new content to set in the file
     */
    public void modifyData(User user, Filename fileName, String newContent){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }

        if(fileName == null){
            throw new IllegalArgumentException("Filename cannot be null");
        }

        if(newContent == null){
            throw new IllegalArgumentException("Content cannot be null");
        }

        if(newContent.isEmpty()){
            throw new IllegalArgumentException("Content cannot be empty");
        }

        if(!dataProcess.containsKey(user)){
            throw new IllegalArgumentException("User not exist");
        }

        if(!dataProcess.get(user).containFile(fileName)){
            throw new IllegalArgumentException("File not exist");
        }

        if(!user.isAdministrator()){
            throw new IllegalArgumentException("This user is not an administrator");
        }

        dataProcess.get(user).modifyValue(fileName, newContent);
    }

    /**
     * Saves the content of a file associated with a user using the provided Save strategy.
     * Throws an exception if the user, filename, or save strategy is null, if the user does not exist,
     * or if the user is not an administrator.
     *
     * @param user the user whose file is to be saved
     * @param filename the filename of the file to be saved
     * @param save the Save strategy to use for saving the file
     */
    public void saveFile(User user, Filename filename, Save<String> save){
        if(user == null){
            throw new IllegalArgumentException("User cannot be null");
        }

        if(filename == null){
            throw new IllegalArgumentException("Filename cannot be null");
        }

        if(save == null){
            throw new IllegalArgumentException("Save cannot be null");
        }

        if(!dataProcess.containsKey(user)){
            throw new IllegalArgumentException("User not exist");
        }

        if(!user.isAdministrator()){
            throw new IllegalArgumentException("This user is not an administrator");
        }

        if(!dataProcess.get(user).containFile(filename)){
            throw new IllegalArgumentException("File not exist");
        }

        dataProcess.get(user).saveFile(filename, save);
    }
}