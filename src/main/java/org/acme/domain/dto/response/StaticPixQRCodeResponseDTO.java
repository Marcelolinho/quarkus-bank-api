package org.acme.domain.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record StaticPixQRCodeResponseDTO(
        UUID uuid,
        String key,
        BigDecimal amount,
        Long transactionId,
        String transactionIdentification,
        String emvqrcps
) {
}
