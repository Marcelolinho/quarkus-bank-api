package org.acme.presentation.client.celcoin.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.acme.presentation.client.celcoin.CelcoinClient;
import org.acme.presentation.client.celcoin.dto.request.CelcoinAuthenticationRequestDTO;
import org.acme.presentation.client.celcoin.dto.response.CelcoinAuthenticationResponseDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Date;

@ApplicationScoped
public class CelcoinAuthenticationService {

    private CelcoinAuthenticationResponseDTO celcoinAccess;

    @ConfigProperty(name = "celcoin.client.id")
    String celcoinClientId;

    @ConfigProperty(name = "celcoin.client.secret")
    String celcoinClientSecret;

    @Inject
    @RestClient
    CelcoinClient celcoinClient;

    public String getToken() {
        if (getCelcoinAccess() != null && celcoinAccess.getTokenExpirationDate().after(new Date())) {
            return celcoinAccess.getAccessToken();
        }

        CelcoinAuthenticationResponseDTO response = authenticate();
        setCelcoinAccess(response);
        return response.getAccessToken();
    }

    private CelcoinAuthenticationResponseDTO authenticate() {
        CelcoinAuthenticationRequestDTO requestBody = new CelcoinAuthenticationRequestDTO(celcoinClientId, "client_credentials", celcoinClientSecret);

        try {
            return celcoinClient.authenticate(requestBody);
        } catch(Exception e) {
            throw new RuntimeException("Couldn't authenticate to Celcoin.");
        }
    }

    public CelcoinAuthenticationResponseDTO getCelcoinAccess() {
        return celcoinAccess;
    }

    public void setCelcoinAccess(CelcoinAuthenticationResponseDTO celcoinAccess) {
        this.celcoinAccess = celcoinAccess;
    }
}
