package org.acme.domain.dto.response;

public record PixKeyResponseDTO(
        String keyType,
        String key,
        String participant,
        String branch,
        String account,
        String accountType,
        String ownerType,
        String ownerDocumentNumber,
        String ownerName,
        String endToEndId,
        boolean sameTaxId
) {
}
