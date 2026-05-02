package org.acme.client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.dto.CelcoinPixQrCodeDto;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/celcoin")
@RegisterRestClient(configKey = "celcoin")
public interface CelcoinClient {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create_qr_code")
    CelcoinPixQrCodeDto createQrCodeByPixKey(String pixKey);
}
