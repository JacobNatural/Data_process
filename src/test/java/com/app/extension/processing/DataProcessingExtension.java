package com.app.extension.processing;

import com.app.processing.impl.DataProcessingImpl;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.HashMap;
import java.util.Map;

import static com.app.data_provider.DataProvider.*;

public class DataProcessingExtension implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().equals(DataProcessingImpl.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return new DataProcessingImpl(new HashMap<>(Map.of(USER1, DATA_IMPL_1, USER2, DATA_IMPL_1)));
    }
}
