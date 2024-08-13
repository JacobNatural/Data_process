# Data Processing Application
![Static Badge](https://img.shields.io/badge/Build-passing-flat)
[![Static Badge](https://img.shields.io/badge/Coverage-98%25-flat)](https://jacobnatural.github.io/data-process/jacoco/index.html)
[![Static Badge](https://img.shields.io/badge/docs-blue)](https://jacobnatural.github.io/data-process/apidocs/index.html)

## Overview

This application processes and manages text files, including functionalities for finding patterns, 
modifying files, and overwriting files. All components of the application are thoroughly tested using JUnit.


## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 22+**
- **Apache Maven 3.9.6+**



### Cloning the repository:

```bash
git clone https://github.com/JacobNatural/data-process.git
cd data-process
```

### Running the application:
- To build the application and run it:
```Bash
mvn clean package -DskipTests
cd target  
java --enable-preview -jar data-process-1.0.jar
```


### Running Tests
- To execute the tests, use the following command:
```Bash
mvn clean test
```

### Integrate into Your Project
- If you want to use this application as a dependency in another Maven project,
  first install it into your local Maven repository by running:
```Bash
mvn clean install -DskipTests
```
- Then, you can add the following dependency to your pom.xml file:

```xml
<dependency>
    <groupId>com.app</groupId>
    <artifactId>data-process</artifactId>
    <version>1.0</version>
</dependency>
```

## Contributing

We welcome contributions to improve the Data Process Application. Here's how you can contribute:

1. Fork the repository on GitHub.
2. Make enhancements or fix issues in your forked copy.
3. Submit a pull request to merge your changes into the main repository.

Please ensure your code adheres to our coding standards and is thoroughly tested before submitting a pull request.