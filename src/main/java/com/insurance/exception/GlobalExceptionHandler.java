package com.insurance.exception;

import com.insurance.dto.BaseResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof ApiException) {
            ApiException apiException = (ApiException) exception;
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(new BaseResponse<>(
                            false,
                            apiException.getMessage(),
                            apiException.getErrorCode().getCode()))
                    .build();
        }

        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(new BaseResponse<>(
                        false,
                        "Internal Server Error",
                        ErrorCode.DATABASE_ERROR.getCode()))
                .build();
    }
}
