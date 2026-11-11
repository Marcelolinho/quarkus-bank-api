package org.acme.domain.mapper;

import org.acme.domain.dto.request.PixKeyRequestDTO;
import org.acme.domain.dto.response.PixKeyResponseDTO;
import org.acme.presentation.client.celcoin.dto.request.CelcoinPixKeyRequestDTO;
import org.acme.presentation.client.celcoin.dto.response.CelcoinPixKeyResponseDTO;
import org.acme.presentation.client.celcoin.dto.response.CelcoinPixKeyResponseDTO.CelcoinPixKeyAccount;
import org.acme.presentation.client.celcoin.dto.response.CelcoinPixKeyResponseDTO.CelcoinPixKeyOwner;

public class PixKeyMapper {

    public static CelcoinPixKeyRequestDTO toCelcoinRequestDTO(PixKeyRequestDTO dto) {
        return new CelcoinPixKeyRequestDTO(dto.getKey());
    }

    public static PixKeyResponseDTO celcoinToResponseDTO(CelcoinPixKeyResponseDTO dto) {
        CelcoinPixKeyAccount account = dto.account();
        CelcoinPixKeyOwner owner = dto.owner();
        return new PixKeyResponseDTO(
                dto.keyType(),
                dto.key(),
                account == null ? null : account.participant(),
                account == null ? null : account.branch(),
                account == null ? null : account.account(),
                account == null ? null : account.accountType(),
                owner == null ? null : owner.type(),
                owner == null ? null : owner.documentNumber(),
                owner == null ? null : owner.name(),
                dto.endToEndId(),
                dto.sameTaxId()
        );
    }
}
