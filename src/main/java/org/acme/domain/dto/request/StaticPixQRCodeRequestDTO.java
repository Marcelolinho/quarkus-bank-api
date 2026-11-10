package org.acme.domain.dto.request;

import org.acme.domain.bo.StaticPixQRCodeMerchantBO;

import java.math.BigDecimal;
import java.util.ArrayList;

public class StaticPixQRCodeRequestDTO {

    private String key;
    private BigDecimal amount;
    private StaticPixQRCodeMerchantBO merchant;
    private ArrayList<String> tags;
    private String additionalInformation;
    private boolean withdrawal;
    private String withdrawalServiceProvider;

    public StaticPixQRCodeRequestDTO() {
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
