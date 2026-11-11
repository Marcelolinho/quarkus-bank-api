package org.acme.presentation.client.celcoin.dto.response;

public record CelcoinResponseDTO<T>(
        String status,
        T body,
        String version
) {
}
