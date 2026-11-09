package org.acme.domain.dto.request;

import java.util.Map;


public class CelcoinPixQrCodeRequestDTO {

    private Map<String, Object> body;

    public CelcoinPixQrCodeRequestDTO(Map<String, Object> body) {
        this.body = body;
    }

    public CelcoinPixQrCodeRequestDTO() {
    }

    public Map<String, Object> getBody() {
        return body;
    }

    public void setBody(Map<String, Object> body) {
        this.body = body;
    }
}
