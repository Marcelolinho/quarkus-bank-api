package org.acme.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.client.CelcoinClient;
import org.acme.model.PixQrCode;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.math.BigDecimal;

@ApplicationScoped
public class PixService {

    @ConfigProperty(name = "celcoin-key")
    String celcoinKey;

    @Inject
    CelcoinClient celcoinClient;

    public PixQrCode createPixPayment(String pixKey, BigDecimal ammount) {
        return null;
    }
}
