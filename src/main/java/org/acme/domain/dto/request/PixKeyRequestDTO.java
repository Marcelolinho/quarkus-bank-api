package org.acme.domain.dto.request;

import jakarta.ws.rs.QueryParam;

public class PixKeyRequestDTO {

    @QueryParam("key")
    private String key;

    public PixKeyRequestDTO() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
