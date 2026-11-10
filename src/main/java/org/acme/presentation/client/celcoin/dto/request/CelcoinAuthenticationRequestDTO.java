package org.acme.presentation.client.celcoin.dto.request;

import jakarta.ws.rs.FormParam;

public class CelcoinAuthenticationRequestDTO {

    @FormParam("client_id")
    private String clientId;
    @FormParam("grant_type")
    private String grantType;
    @FormParam("client_secret")
    private String clientSecret;

    public CelcoinAuthenticationRequestDTO(String clientId, String grantType, String clientSecret) {
        this.clientId = clientId;
        this.grantType = grantType;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    @Override
    public String toString() {
        return "CelcoinAuthenticationRequestDTO{" +
                "clientId='" + clientId + '\'' +
                ", grantType='" + grantType + '\'' +
                ", clientSecret='" + clientSecret + '\'' +
                '}';
    }
}
