package com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.config;

import com.negoreserva.common.feature.general.sms.feature.phone.feature.ombala.exception.OmbalaApiException;
import graphql.GraphQLError;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.ErrorType;

public class OmbalaGraphqlErrorsHandler  {

    public static GraphQLError resolve(Throwable ex, DataFetchingEnvironment env) {
        if (ex instanceof OmbalaApiException ombalaEx) {
            return GraphQLError.newError()
                    .errorType(ErrorType.INTERNAL_ERROR)
                    .message("Falha ao enviar SMS via Ombala. Tente novamente.")
                    .path(env.getExecutionStepInfo().getPath())
                    .location(env.getField().getSourceLocation())
                    .build();
        }
        return null;
    }

    protected GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        return OmbalaGraphqlErrorsHandler.resolve(ex, env);
    }
}
