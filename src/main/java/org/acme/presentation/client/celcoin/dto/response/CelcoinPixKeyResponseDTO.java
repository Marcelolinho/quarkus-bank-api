package org.acme.presentation.client.celcoin.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CelcoinPixKeyResponseDTO(
        String keyType,
        String key,
        CelcoinPixKeyAccount account,
        CelcoinPixKeyOwner owner,
        @JsonProperty("endtoEndId") String endToEndId,
        String creationDate,
        String keyOwnershipDate,
        String openClaimCreationDate,
        Object statistics,
        @JsonProperty("isSameTaxId") boolean sameTaxId
) {

    public record CelcoinPixKeyAccount(
            String participant,
            String branch,
            String account,
            String accountType,
            String createDate
    ) {
    }

    public record CelcoinPixKeyOwner(
            String type,
            String documentNumber,
            String name
    ) {
    }
}
