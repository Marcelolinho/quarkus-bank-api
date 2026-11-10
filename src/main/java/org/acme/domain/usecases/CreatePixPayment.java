package org.acme.domain.usecases;

import org.acme.domain.bo.StaticPixQRCodeMerchantBO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

public class CreatePixPayment {

    private UUID uuid;
    private String key;
    private BigDecimal amount;
    private StaticPixQRCodeMerchantBO merchant;
    private ArrayList<String> tags;
    private String additionalInformation;
    private boolean withdrawal;
    private String withdrawalServiceProvider;

    public CreatePixPayment(String key, BigDecimal amount, StaticPixQRCodeMerchantBO merchant, ArrayList<String> tags, String additionalInformation, boolean withdrawal, String withdrawalServiceProvider) {
        this.uuid = UUID.randomUUID();
        this.key = key;
        this.amount = amount;
        this.merchant = merchant;
        this.tags = tags;
        this.additionalInformation = additionalInformation;
        this.withdrawal = withdrawal;
        this.withdrawalServiceProvider = withdrawalServiceProvider;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public StaticPixQRCodeMerchantBO getMerchant() {
        return merchant;
    }

    public void setMerchant(StaticPixQRCodeMerchantBO merchant) {
        this.merchant = merchant;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public boolean isWithdrawal() {
        return withdrawal;
    }

    public void setWithdrawal(boolean withdrawal) {
        this.withdrawal = withdrawal;
    }

    public String getWithdrawalServiceProvider() {
        return withdrawalServiceProvider;
    }

    public void setWithdrawalServiceProvider(String withdrawalServiceProvider) {
        this.withdrawalServiceProvider = withdrawalServiceProvider;
    }
}
