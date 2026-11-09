package org.acme.domain.usecases;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.infra.client.CelcoinClient;
import org.acme.domain.bo.PixQrCodeBO;

import java.math.BigDecimal;

@ApplicationScoped
public class CreateStaticQRCode {

    @Inject
    CelcoinClient celcoinClient;

    @Inject
    CelcoinAuthentication authService;

    public PixQrCodeBO createPixPayment(String pixKey, BigDecimal ammount) {
        String token = authService.getToken();

        return null;
    }
}
