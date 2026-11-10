package org.acme.domain.usecases;

import org.acme.domain.bo.StaticPixQRCodeBO;
import org.acme.domain.dto.request.StaticPixQRCodeRequestDTO;
import org.acme.domain.mapper.StaticPixQRCodeMapper;
import org.acme.infra.panache.models.PanachePixQrCode;
import org.acme.presentation.client.celcoin.CelcoinClient;
import org.acme.presentation.client.celcoin.dto.response.CelcoinStaticQRCodeResponseDTO;
import org.acme.presentation.client.celcoin.services.CelcoinAuthenticationService;
import org.acme.presentation.client.celcoin.services.CelcoinStaticQRCodeService;

public class CreateStaticQRCode {

    CelcoinClient celcoinClient;

    CelcoinAuthenticationService authService;

    public CreateStaticQRCode(CelcoinClient celcoinClient, CelcoinAuthenticationService authService) {
        this.celcoinClient = celcoinClient;
        this.authService = authService;
    }

    public StaticPixQRCodeBO createPixPayment(StaticPixQRCodeRequestDTO dto) {
        StaticPixQRCodeBO bo = StaticPixQRCodeMapper.toBO(StaticPixQRCodeMapper.dtoToCelcoinRequestDTO(dto));
        // TODO: Create user validation and mapping to PixQRCodeBO so we can save who asked for the QR Code

        return PanachePixQrCode.findByKeyAndAmount(bo.getKey(), bo.getAmount())
                .map(StaticPixQRCodeMapper::toBO)
                .orElseGet(() -> createOnCelcoin(bo, dto));
    }

    private StaticPixQRCodeBO createOnCelcoin(StaticPixQRCodeBO bo, StaticPixQRCodeRequestDTO dto) {
        CelcoinStaticQRCodeResponseDTO response = new CelcoinStaticQRCodeService(authService, celcoinClient)
                .createQRCode(dto);

        bo.setTransactionId(response.getTransactionId());
        bo.setTransactionIdentification(response.getTransactionIdentification());
        bo.setEmvqrcps(response.getEmvqrcps());

        StaticPixQRCodeMapper.toEntity(bo).persist();
        return bo;
    }
}
