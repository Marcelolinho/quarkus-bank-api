package org.acme.domain.usecases;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.infra.client.CelcoinClient;
import org.acme.domain.dto.request.CelcoinAuthenticationRequestDTO;
import org.acme.domain.dto.response.CelcoinAuthenticationResponseDTO;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.Date;

@ApplicationScoped
public class CelcoinAuthentication {

    private CelcoinAuthenticationResponseDTO celcoinAccess;

    @ConfigProperty(name = "celcoin.client.id")
    String celcoinClientId;

    @ConfigProperty(name = "celcoin.client.secret")
    String celcoinClientSecret;

    @Inject
    CelcoinClient celcoinClient;

    public String getToken() {
        if (getCelcoinAccess() != null && celcoinAccess.getTokenExpirationDate().before(new Date())) {
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
