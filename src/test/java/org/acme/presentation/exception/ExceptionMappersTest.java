package org.acme.presentation.exception;

import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.core.Response;
import org.acme.domain.dto.response.ErrorResponseDTO;
import org.acme.domain.exception.ApiException;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExceptionMappersTest {

    private final ExceptionMappers mappers = new ExceptionMappers();

    @Test
    void apiExceptionKeepsCodeAndReason() {
        assertError(mappers.mapApiException(new ApiException(404, "Pix key not found")), 404, "Pix key not found");
    }

    @Test
    void webApplicationExceptionUsesStatusReasonPhrase() {
        assertError(mappers.mapWebApplicationException(new NotFoundException()), 404, "Not Found");
    }

    @Test
    void unexpectedExceptionBecomesGeneric500() {
        assertError(mappers.mapException(new IllegalStateException("db password leaked")), 500, "Internal Server Error");
    }

    private void assertError(Response response, int code, String reason) {
        ErrorResponseDTO body = (ErrorResponseDTO) response.getEntity();
        assertEquals(code, response.getStatus());
        assertEquals(code, body.code());
        assertEquals(reason, body.reason());
        assertEquals(LocalDate.now(), body.timestamp());
    }
}
