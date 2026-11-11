package org.acme.presentation.exception;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.acme.domain.dto.response.ErrorResponseDTO;
import org.acme.domain.exception.ApiException;
import org.jboss.logging.Logger;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class ExceptionMappers {

    private static final Logger LOG = Logger.getLogger(ExceptionMappers.class);

    @ServerExceptionMapper
    public Response mapApiException(ApiException e) {
        return error(e.getCode(), e.getMessage());
    }

    @ServerExceptionMapper
    public Response mapWebApplicationException(WebApplicationException e) {
        Response.StatusType status = e.getResponse().getStatusInfo();
        return error(status.getStatusCode(), status.getReasonPhrase());
    }

    @ServerExceptionMapper
    public Response mapException(Exception e) {
        LOG.error("Unhandled error", e);
        return error(500, "Internal Server Error");
    }

    private Response error(int code, String reason) {
        return Response.status(code)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ErrorResponseDTO(code, reason))
                .build();
    }
}
