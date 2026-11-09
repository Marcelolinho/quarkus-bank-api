package org.acme.infra.client;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.domain.dto.request.CelcoinAuthenticationRequestDTO;
import org.acme.domain.dto.request.CelcoinPixQrCodeRequestDTO;
import org.acme.domain.dto.response.CelcoinAuthenticationResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/celcoin")
@RegisterRestClient(configKey = "celcoin")
public interface CelcoinClient {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/token")
    CelcoinAuthenticationResponseDTO authenticate(CelcoinAuthenticationRequestDTO requestDTO);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/pix/create_qr_code")
    CelcoinPixQrCodeRequestDTO createQrCodeByPixKey(String pixKey);


}
