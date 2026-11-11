package org.acme.domain.dto.response;

import java.time.LocalDate;

public record ErrorResponseDTO(
        int code,
        String reason,
        LocalDate timestamp
) {

    public ErrorResponseDTO(int code, String reason) {
        this(code, reason, LocalDate.now());
    }
}
