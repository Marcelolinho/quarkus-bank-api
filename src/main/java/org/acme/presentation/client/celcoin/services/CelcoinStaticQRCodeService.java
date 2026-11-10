package org.acme.presentation.client.celcoin.services;

import org.acme.domain.dto.request.StaticPixQRCodeRequestDTO;
import org.acme.domain.mapper.StaticPixQRCodeMapper;
import org.acme.presentation.client.celcoin.CelcoinClient;
import org.acme.presentation.client.celcoin.dto.request.CelcoinStaticQRCodeRequestDTO;
import org.acme.presentation.client.celcoin.dto.response.CelcoinStaticQRCodeResponseDTO;

public class CelcoinStaticQRCodeService {

    private CelcoinAuthenticationService authenticationService;
    private CelcoinClient celcoinClient;

    public CelcoinStaticQRCodeService(CelcoinAuthenticationService authenticationService, CelcoinClient celcoinClient) {
        this.authenticationService = authenticationService;
        this.celcoinClient = celcoinClient;
    }

    public CelcoinStaticQRCodeResponseDTO createQRCode(StaticPixQRCodeRequestDTO dto) {
        CelcoinStaticQRCodeRequestDTO requestDTO = StaticPixQRCodeMapper.dtoToCelcoinRequestDTO(dto);
        return celcoinClient.createQrCodeByPixKey("Bearer " + authenticationService.getToken(), requestDTO);
    }
}
