package org.acme.domain.bo;

import java.math.BigDecimal;
import java.util.*;

public class StaticPixQRCodeBO {

    private UUID uuid;
    private String key;
    private BigDecimal amount;
    private StaticPixQRCodeMerchantBO merchant;
    private ArrayList<String> tags;
    private String additionalInformation;
    private boolean withdrawal;
    private String withdrawalServiceProvider;
    private Long transactionId;
    private String transactionIdentification;
    private String emvqrcps;

    // TODO: Add "User" when keycloak gets implemented


    public StaticPixQRCodeBO(String key, BigDecimal amount, StaticPixQRCodeMerchantBO merchant, ArrayList<String> tags, String additionalInformation, boolean withdrawal, String withdrawalServiceProvider) {
        this.uuid = UUID.randomUUID();
        this.key = key;
        this.amount = amount;
        this.merchant = merchant;
        this.tags = tags;
        this.additionalInformation = additionalInformation;
        this.withdrawal = withdrawal;
        this.withdrawalServiceProvider = withdrawalServiceProvider;

        validate();
    }

    public StaticPixQRCodeBO() {
    }

    private void validate() {
        Map<String, Object> requiredAttributes = new HashMap<>();
        requiredAttributes.put("key", this.key);
        requiredAttributes.put("merchant", this.merchant);

        for (Map.Entry<String, Object> entry : requiredAttributes.entrySet()) {
            if (entry.getValue() == null) {
                throw new RuntimeException(String.format("O valor de %s não deve ser nulo", entry.getKey()));
            }
        }
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

    public StaticPixQRCodeMerchantBO getMerchant() {
        return merchant;
    }

    public void setMerchant(StaticPixQRCodeMerchantBO merchant) {
        this.merchant = merchant;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionIdentification() {
        return transactionIdentification;
    }

    public void setTransactionIdentification(String transactionIdentification) {
        this.transactionIdentification = transactionIdentification;
    }

    public String getEmvqrcps() {
        return emvqrcps;
    }

    public void setEmvqrcps(String emvqrcps) {
        this.emvqrcps = emvqrcps;
    }
}
