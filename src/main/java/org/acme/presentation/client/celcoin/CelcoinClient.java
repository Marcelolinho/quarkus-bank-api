package org.acme.presentation.client.celcoin;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.presentation.client.celcoin.dto.request.CelcoinAuthenticationRequestDTO;
import org.acme.presentation.client.celcoin.dto.request.CelcoinStaticQRCodeRequestDTO;
import org.acme.presentation.client.celcoin.dto.response.CelcoinAuthenticationResponseDTO;
import org.acme.presentation.client.celcoin.dto.response.CelcoinStaticQRCodeResponseDTO;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(configKey = "celcoin")
public interface CelcoinClient {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/v5/token")
    CelcoinAuthenticationResponseDTO authenticate(@BeanParam CelcoinAuthenticationRequestDTO requestDTO);

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/pix/v1/brcode/static")
    CelcoinStaticQRCodeResponseDTO createQrCodeByPixKey(@HeaderParam("Authorization") String authorization, CelcoinStaticQRCodeRequestDTO requestDTO);

//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Path("/baas/v2/pix/dict/entry/external/{account}")

}
