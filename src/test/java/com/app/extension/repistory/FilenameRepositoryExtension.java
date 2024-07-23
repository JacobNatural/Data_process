package com.app.extension.repistory;

import com.app.data_provider.DataProvider;
import com.app.parser.impl.FilenameLineParser;
import com.app.repository.impl.FilenameRepository;
import com.app.txt.impl.TxtTransfer;
import com.app.txt.load.impl.FilenameTxtLoad;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class FilenameRepositoryExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(FilenameRepository.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new FilenameRepository(
                new FilenameTxtLoad(
                        new TxtTransfer<>(),
                        new FilenameLineParser(".*")),
                DataProvider.filenameTxtLoadPath());
    }
}
