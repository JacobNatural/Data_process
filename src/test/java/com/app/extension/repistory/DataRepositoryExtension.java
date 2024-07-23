package com.app.extension.repistory;

import com.app.data_provider.DataProvider;
import com.app.parser.impl.ContentLineParser;
import com.app.parser.impl.FilenameLineParser;
import com.app.repository.impl.DataRepository;
import com.app.repository.impl.FilenameRepository;
import com.app.txt.impl.TxtTransfer;
import com.app.txt.load.impl.ContentTxtLoad;
import com.app.txt.load.impl.FilenameTxtLoad;
import org.junit.jupiter.api.extension.*;

public class DataRepositoryExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(DataRepository.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {

        var filenameRepository = new FilenameRepository(
                new FilenameTxtLoad(
                        new TxtTransfer<>(),
                        new FilenameLineParser(".*")),
                DataProvider.filenameTxtLoadPath());

        return new DataRepository(
                new ContentTxtLoad(
                        new TxtTransfer<>(),
                        new ContentLineParser()
                ),filenameRepository
        );
    }
}
