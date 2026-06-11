package com.negoreserva.common.feature.general.sms.config;

import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.config.OmbalaGraphqlErrorsHandler;
import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.exception.OmbalaApiException;
import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;

public class SmsGraphqlErrorsHandler {

    public static GraphQLError resolve(Throwable ex, DataFetchingEnvironment env) {
        return switch (ex) {
            case OmbalaApiException e -> OmbalaGraphqlErrorsHandler.resolve(e, env);
            default -> null;
        };
    }

    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return SmsGraphqlErrorsHandler.resolve(ex, env);
    }
}
