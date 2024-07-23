package com.app.extension.txt;

import com.app.parser.impl.UserLineParser;
import com.app.txt.impl.TxtTransfer;
import com.app.txt.load.impl.UserTxtLoad;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

public class UserTxtLoadExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(UserTxtLoad.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new UserTxtLoad(
                new TxtTransfer<>(),
                new UserLineParser("[1-9][0-9]*;[A-Z0-9]+;[a-z0-9]+;(USER|ADMINISTRATOR)"));
    }
}
