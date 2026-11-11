package org.acme.presentation.client.celcoin.dto.request;

import jakarta.ws.rs.QueryParam;

public class CelcoinPixKeyRequestDTO {

    @QueryParam("key")
    private String key;

    public CelcoinPixKeyRequestDTO(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
