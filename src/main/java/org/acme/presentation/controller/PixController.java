package org.acme.presentation.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.domain.dto.request.StaticPixQRCodeRequestDTO;
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
}
