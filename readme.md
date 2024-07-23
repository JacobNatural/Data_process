# Data Processing Application

## Overview

This application processes and manages text files, including functionalities for finding patterns, modifying files, and overwriting files. The `main` class provides an example of how to use the application.

## [Testing and Coverage](https://jacobnatural.github.io/Data_process/)

All components of the application are thoroughly tested using JUnit, achieving 98% code coverage.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 22
- A Java IDE or text editor (e.g., IntelliJ IDEA, Eclipse, VSCode)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/yourusername/Data_process.git
    cd data_process
    ```
### Building the project using Maven:

```Bash
mvn clean install
```

### Running the application:
```Bash
cd target  
java java --enable-preview -jar DataProcess-1.0.jar
```

### Integrate into Your Project

1. Import the necessary packages into your Java project.
2. Utilize the provided classes and methods to handle car data processing, validation, and statistics.


## Project Structure

### Package: `com.app`

- [**App.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/App.java)
    - Main class demonstrating usage of the application.


### Package: `com.app.data`

- [**DataImpl.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/data/impl/DataImpl.java)
    - Implements the `Data` interface for basic file operations.
    - Fields:
        - `private final DataRepository data`
    - Methods:
        - `public void modifyValue(Filename filename, String newContent)`
        - `public void saveFile(Filename filename, Save<String> save)`
        - `public boolean containFile(Filename filename)`
        - `public long countPatternOccurrences(String regex)`
        - `public long countPatternOccurrences(String regex, Filename filename)`
        - `private int countPatternOccurrences(String content, String regex)`

### Package: `com.app.model`

- [**Filename.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/model/Filename.java)
    - Record for storing file names and IDs.
    - Fields:
        - `public final Long id`
        - `public final String filename`

### Package: `com.app.parser.impl`

- [**ContentLineParser.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/parser/impl/ContentLineParser.java)
    - Parses lines into a map of `Long` to `String`.
    - Methods:
        - `public Map<Long, String> parse(String line)`

- [**FilenameLineParser.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/parser/impl/FilenameLineParser.java)
    - Validates and parses lines into a map of `Long` to `Filename`.
    - Fields:
        - `private final String regex`
    - Methods:
        - `public Map<Long, Filename> parse(String line)`

- [**UserLineParser.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/parser/impl/UserLineParser.java)
    - Validates and parses lines into a map of `Long` to `User`.
    - Fields:
        - `private final String regex`
    - Methods:
        - `public Map<Long, User> parse(String line)`

### Package: `com.app.processing`

- [**DataProcessingImpl.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/processing/impl/DataProcessingImpl.java)
    - Implements `DataProcessing` for managing and processing user-related data.
    - Fields:
        - `private final Map<User, Data> dataProcess`
    - Methods:
        - `void addUser(User user, DataImpl dataImpl)`
        - `void removeUser(User user)`
        - `void updateData(User user, DataImpl dataImpl)`
        - `long getPatternOccurrences(User user, String regex)`
        - `long getPatternOccurrences(User user, String regex, Filename filename)`
        - `void modifyData(User user, Filename fileName, String newContent)`
        - `void saveFile(User user, Filename filename, Save<String> save)`

### Package: `com.app.repository.impl`

- [**DataRepository.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/repository/impl/DataRepository.java)
    - Manages data file storage.
    - Fields:
        - `private final Map<Filename, String> dates`
    - Methods:
        - `public Map<Filename, String> getAll()`

- [**FilenameRepository.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/repository/impl/FilenameRepository.java)
    - Manages file names.
    - Fields:
        - `private final Map<Long, Filename> filenames`
    - Methods:
        - `public Map<Long, Filename> getAll()`

- [**UserRepository.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/repository/impl/UserRepository.java)
    - Manages users.
    - Fields:
        - `private final Map<Long, User> users`
    - Methods:
        - `public Map<Long, User> getAll()`

### Package: `com.app.txt.impl`

- [**TxtTransfer.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/txt/impl/TxtTransfer.java)
    - Handles reading and writing of text files.
    - Methods:
        - `public Map<T, U> readData(String filename, LineParser<T, U> lineParser)`
        - `public void writeData(String filename, T t, Function<T, String> prepare)`

### Package: `com.app.txt.load.generic`

- [**LoadFromTxt.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/txt/load/generic/LoadFromTxt.java)
    - Abstract class for loading data from text files.
    - Fields:
        - `private final Transfer<T, U> transfer`
        - `private final LineParser<T, U> lineParser`
    - Methods:
        - `public Map<T, U> load(String filename)`

### Package: `com.app.txt.load.impl`

- [**ContentTxtLoad.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/txt/load/impl/ContentTxtLoad.java)
    - Loads `String` content from text files.
    - Constructor provided with specific `Transfer` and `LineParser` instances.

- [**FilenameTxtLoad.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/txt/load/impl/FilenameTxtLoad.java)
    - Loads `Filename` objects from text files.
    - Constructor provided with specific `Transfer` and `LineParser` instances.

- [**UserTxtLoad.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/txt/load/impl/UserTxtLoad.java)
    - Loads `User` objects from text files.
    - Constructor provided with specific `Transfer` and `LineParser` instances.

### Package: `com.app.txt.save.generic`

- [**SaveToTxt.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/txt/save/generic/SaveToTxt.java)
    - Abstract class for saving data to text files.
    - Fields:
        - `private final Transfer<T, String> transfer`
    - Methods:
        - `public void save(String filename, T t, Function<T, String> prepare)`

### Package: `com.app.txt.save.impl`

- [**StringToTxtSave.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/txt/save/impl/StringToTxtSave.java)
    - Saves `String` data to text files.
    - Constructor provided with specific `Transfer` instance.

### Package: `com.app.user`

- [**User.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/user/User.java)
    - Represents a user with fields:
        - `private final Long id`
        - `private final String login`
        - `private final String password`
        - `private final UserType userType`
    - Methods:
        - `public boolean isAdministrator()`

- [**UserType.java**](https://github.com/JacobNatural/Data_process/blob/master/src/main/java/com/app/user/UserType.java)
    - Enum for user types:
        - `USER`
        - `ADMINISTRATOR`

## Contributing

We welcome contributions to improve the Car Processing Application. Here's how you can contribute:

1. Fork the repository on GitHub.
2. Make enhancements or fix issues in your forked copy.
3. Submit a pull request to merge your changes into the main repository.

Please ensure your code adheres to our coding standards and is thoroughly tested before submitting a pull request.