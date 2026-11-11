package org.acme.presentation.client.celcoin.dto.response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CelcoinResponseDTOTest {

    private static final String PIX_KEY_JSON = """
            {
              "status": "SUCCESS",
              "body": {
                "keyType": "EMAIL",
                "key": "teste@celcoin.com.br",
                "account": {
                  "participant": "18236120",
                  "branch": "0",
                  "account": "********",
                  "accountType": "********",
                  "createDate": null
                },
                "owner": {
                  "type": "********",
                  "documentNumber": "***778477**",
                  "name": "teste celcoin"
                },
                "endtoEndId": "E139358932026032313566ZQX3kOHGyf",
                "creationDate": null,
                "keyOwnershipDate": null,
                "openClaimCreationDate": null,
                "statistics": null,
                "isSameTaxId": true
              },
              "version": "1.0.0"
            }
            """;

    @Test
    void deserializesPixKeyBody() throws Exception {
        CelcoinResponseDTO<CelcoinPixKeyResponseDTO> response = new ObjectMapper()
                .readValue(PIX_KEY_JSON, new TypeReference<>() {});

        assertEquals("SUCCESS", response.status());
        assertEquals("1.0.0", response.version());
        assertEquals("EMAIL", response.body().keyType());
        assertEquals("18236120", response.body().account().participant());
        assertEquals("teste celcoin", response.body().owner().name());
        assertEquals("E139358932026032313566ZQX3kOHGyf", response.body().endToEndId());
        assertTrue(response.body().sameTaxId());
    }
}
