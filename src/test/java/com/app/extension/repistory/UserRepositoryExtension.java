package com.app.extension.repistory;


import com.app.data_provider.DataProvider;
import com.app.parser.impl.UserLineParser;
import com.app.repository.impl.UserRepository;
import com.app.txt.impl.TxtTransfer;
import com.app.txt.load.impl.UserTxtLoad;
import org.junit.jupiter.api.extension.*;


public class UserRepositoryExtension implements ParameterResolver {

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(UserRepository.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new UserRepository(new UserTxtLoad(
                new TxtTransfer<>(),
                new UserLineParser("[1-9][0-9]*;[A-Z0-9]+;[a-z0-9]+;(USER|ADMINISTRATOR)")),
                DataProvider.userTxtLoadPath());
    }
}
