package com.app.extension.txt;

import com.app.parser.impl.FilenameLineParser;
import com.app.txt.impl.TxtTransfer;
import com.app.txt.load.impl.FilenameTxtLoad;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class FilenameTxtLoadExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(FilenameTxtLoad.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new FilenameTxtLoad(new TxtTransfer<>(), new FilenameLineParser(".*"));
    }

}
