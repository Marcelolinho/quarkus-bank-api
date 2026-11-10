package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import jakarta.transaction.Transactional;
import org.acme.domain.bo.StaticPixQRCodeBO;
import org.acme.domain.dto.request.StaticPixQRCodeRequestDTO;
import org.acme.domain.dto.response.StaticPixQRCodeResponseDTO;
import org.acme.domain.mapper.StaticPixQRCodeMapper;
import org.acme.domain.usecases.CreateStaticQRCode;
import org.acme.presentation.client.celcoin.CelcoinClient;
import org.acme.presentation.client.celcoin.services.CelcoinAuthenticationService;

@ApplicationScoped
public class PixService {

    @Inject
    CelcoinAuthenticationService celcoinAuthentication;

    @Inject
    @RestClient
    CelcoinClient celcoinClient;

    @Transactional
    public StaticPixQRCodeResponseDTO createQRCodeByKey(StaticPixQRCodeRequestDTO dto) {
        CreateStaticQRCode createStaticQRCodeUseCase = new CreateStaticQRCode(celcoinClient, celcoinAuthentication);

        StaticPixQRCodeBO response = createStaticQRCodeUseCase.createPixPayment(dto);

        return StaticPixQRCodeMapper.toResponseDTO(response);
    }
}
