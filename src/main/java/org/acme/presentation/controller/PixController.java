package org.acme.presentation.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.domain.dto.request.PixKeyRequestDTO;
import org.acme.domain.dto.request.StaticPixQRCodeRequestDTO;
import org.acme.domain.dto.response.PixKeyResponseDTO;
import org.acme.domain.dto.response.StaticPixQRCodeResponseDTO;
import org.acme.services.PixService;

@Path("/pix")
public class PixController {

    @Inject
    PixService pixService;

    @POST
    @Path("/qrcode/static")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StaticPixQRCodeResponseDTO createStaticQRCode(StaticPixQRCodeRequestDTO dto) {
        return pixService.createQRCodeByKey(dto);
    }

    @GET
    @Path("/key/{account}")
    @Produces(MediaType.APPLICATION_JSON)
    public PixKeyResponseDTO consultPixKey(@PathParam("account") String account, @BeanParam PixKeyRequestDTO dto) {
        return pixService.consultPixKey(account, dto);
    }
}
