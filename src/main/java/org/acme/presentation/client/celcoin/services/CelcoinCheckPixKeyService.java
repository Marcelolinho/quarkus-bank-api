package org.acme.presentation.client.celcoin.services;

import org.acme.domain.dto.request.PixKeyRequestDTO;
import org.acme.domain.mapper.PixKeyMapper;
import org.acme.presentation.client.celcoin.CelcoinClient;
import org.acme.presentation.client.celcoin.dto.request.CelcoinPixKeyRequestDTO;
import org.acme.presentation.client.celcoin.dto.response.CelcoinPixKeyResponseDTO;

public class CelcoinCheckPixKeyService {

    private CelcoinAuthenticationService authenticationService;
    private CelcoinClient celcoinClient;

    public CelcoinCheckPixKeyService(CelcoinAuthenticationService authenticationService, CelcoinClient celcoinClient) {
        this.authenticationService = authenticationService;
        this.celcoinClient = celcoinClient;
    }

    public CelcoinPixKeyResponseDTO checkPixKey(String account, PixKeyRequestDTO dto) {
        CelcoinPixKeyRequestDTO requestDTO = PixKeyMapper.toCelcoinRequestDTO(dto);
        return celcoinClient.consultPixKey(authenticationService.getToken(), account, requestDTO).body();
    }
}
