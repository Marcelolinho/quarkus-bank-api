package org.acme.dto;

import java.util.Map;


public class CelcoinPixQrCodeDto {

    private Map<String, Object> body;

    public CelcoinPixQrCodeDto(Map<String, Object> body) {
        this.body = body;
    }

    public CelcoinPixQrCodeDto() {
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
