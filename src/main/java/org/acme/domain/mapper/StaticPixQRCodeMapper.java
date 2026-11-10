package org.acme.domain.mapper;

import org.acme.domain.bo.StaticPixQRCodeBO;
import org.acme.domain.bo.StaticPixQRCodeMerchantBO;
import org.acme.domain.dto.request.StaticPixQRCodeRequestDTO;
import org.acme.domain.dto.response.StaticPixQRCodeResponseDTO;
import org.acme.infra.panache.models.PanachePixQrCode;
import org.acme.presentation.client.celcoin.dto.request.CelcoinStaticQRCodeRequestDTO;
import org.acme.presentation.client.celcoin.dto.request.CelcoinStaticQRCodeRequestDTO.CelcoinStaticQRCodeMerchant;
import org.acme.presentation.client.celcoin.dto.response.CelcoinStaticQRCodeResponseDTO;

import java.util.ArrayList;

public class StaticPixQRCodeMapper {

    public static StaticPixQRCodeBO toBO(CelcoinStaticQRCodeRequestDTO dto) {
        CelcoinStaticQRCodeMerchant merchant = dto.getMerchant();
        StaticPixQRCodeBO bo = new StaticPixQRCodeBO(
                dto.getKey(),
                dto.getAmount(),
                merchant == null ? null : new StaticPixQRCodeMerchantBO(
                        merchant.getPostalCode(),
                        merchant.getCity(),
                        merchant.getMerchantCategoryCode(),
                        merchant.getName()
                ),
                dto.getTags(),
                dto.getAdditionalInformation(),
                dto.isWithdrawal(),
                dto.getWithdrawalServiceProvider()
        );
        bo.setTransactionIdentification(dto.getTransactionIdentification());
        return bo;
    }

    public static StaticPixQRCodeBO toBO(PanachePixQrCode entity) {
        StaticPixQRCodeBO bo = new StaticPixQRCodeBO(
                entity.pixKey,
                entity.amount,
                new StaticPixQRCodeMerchantBO(
                        entity.merchantPostalCode,
                        entity.merchantCity,
                        entity.merchantCategoryCode,
                        entity.merchantName
                ),
                entity.tags == null ? null : new ArrayList<>(entity.tags),
                entity.additionalInformation,
                entity.withdrawal,
                entity.withdrawalServiceProvider
        );
        bo.setUuid(entity.id);
        bo.setTransactionId(entity.transactionId);
        bo.setTransactionIdentification(entity.transactionIdentification);
        bo.setEmvqrcps(entity.emvqrcps);
        return bo;
    }

    public static PanachePixQrCode toEntity(StaticPixQRCodeBO bo) {
        PanachePixQrCode entity = new PanachePixQrCode();
        entity.id = bo.getUuid();
        entity.pixKey = bo.getKey();
        entity.amount = bo.getAmount();
        entity.merchantPostalCode = bo.getMerchant().getPostalCode();
        entity.merchantCity = bo.getMerchant().getCity();
        entity.merchantCategoryCode = bo.getMerchant().getMerchantCategoryCode();
        entity.merchantName = bo.getMerchant().getName();
        entity.tags = bo.getTags();
        entity.additionalInformation = bo.getAdditionalInformation();
        entity.withdrawal = bo.isWithdrawal();
        entity.withdrawalServiceProvider = bo.getWithdrawalServiceProvider();
        entity.transactionId = bo.getTransactionId();
        entity.transactionIdentification = bo.getTransactionIdentification();
        entity.emvqrcps = bo.getEmvqrcps();
        return entity;
    }

    public static CelcoinStaticQRCodeRequestDTO toCelcoinRequestDTO(StaticPixQRCodeBO bo) {
        return new CelcoinStaticQRCodeRequestDTO(
                bo.getKey(),
                bo.getAmount(),
                bo.getTransactionIdentification(),
                toCelcoinMerchant(bo.getMerchant()),
                bo.getTags(),
                bo.getAdditionalInformation(),
                bo.isWithdrawal(),
                bo.getWithdrawalServiceProvider()
        );
    }

    public static CelcoinStaticQRCodeRequestDTO dtoToCelcoinRequestDTO(StaticPixQRCodeRequestDTO dto) {
        return new CelcoinStaticQRCodeRequestDTO(
                dto.getKey(),
                dto.getAmount(),
                null,
                toCelcoinMerchant(dto.getMerchant()),
                dto.getTags(),
                dto.getAdditionalInformation(),
                dto.isWithdrawal(),
                dto.getWithdrawalServiceProvider()
        );
    }

    public static StaticPixQRCodeResponseDTO toResponseDTO(StaticPixQRCodeBO bo) {
        return new StaticPixQRCodeResponseDTO(
                bo.getUuid(),
                bo.getKey(),
                bo.getAmount(),
                bo.getTransactionId(),
                bo.getTransactionIdentification(),
                bo.getEmvqrcps()
        );
    }

    public static StaticPixQRCodeResponseDTO celcoinToResponseDTO(CelcoinStaticQRCodeResponseDTO dto) {
        return new StaticPixQRCodeResponseDTO(
                null,
                null,
                null,
                dto.getTransactionId(),
                dto.getTransactionIdentification(),
                dto.getEmvqrcps()
        );
    }

    private static CelcoinStaticQRCodeMerchant toCelcoinMerchant(StaticPixQRCodeMerchantBO merchant) {
        if (merchant == null) {
            return null;
        }
        return new CelcoinStaticQRCodeMerchant(
                merchant.getPostalCode(),
                merchant.getCity(),
                merchant.getMerchantCategoryCode(),
                merchant.getName()
        );
    }
}
