package org.acme.presentation.client.celcoin.dto.request;

import java.math.BigDecimal;
import java.util.ArrayList;

public class CelcoinStaticQRCodeRequestDTO {

    private String key;
    private BigDecimal amount;
    private String transactionIdentification;
    private CelcoinStaticQRCodeMerchant merchant;
    private ArrayList<String> tags;
    private String additionalInformation;
    private boolean withdrawal;
    private String withdrawalServiceProvider;

    public CelcoinStaticQRCodeRequestDTO(String key, BigDecimal amount, String transactionIdentification, CelcoinStaticQRCodeMerchant merchant, ArrayList<String> tags, String additionalInformation, boolean withdrawal, String withdrawalServiceProvider) {
        this.key = key;
        this.amount = amount;
        this.transactionIdentification = transactionIdentification;
        this.merchant = merchant;
        this.tags = tags;
        this.additionalInformation = additionalInformation;
        this.withdrawal = withdrawal;
        this.withdrawalServiceProvider = withdrawalServiceProvider;
    }

    public CelcoinStaticQRCodeRequestDTO() {
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

    public String getTransactionIdentification() {
        return transactionIdentification;
    }

    public void setTransactionIdentification(String transactionIdentification) {
        this.transactionIdentification = transactionIdentification;
    }

    public CelcoinStaticQRCodeMerchant getMerchant() {
        return merchant;
    }

    public void setMerchant(CelcoinStaticQRCodeMerchant merchant) {
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

    public static class CelcoinStaticQRCodeMerchant {
        private String postalCode;
        private String city;
        private String merchantCategoryCode = "5651";
        private String name;

        public CelcoinStaticQRCodeMerchant(String postalCode, String city, String merchantCategoryCode, String name) {
            this.postalCode = postalCode;
            this.city = city;
            this.merchantCategoryCode = merchantCategoryCode;
            this.name = name;
        }

        public CelcoinStaticQRCodeMerchant() {
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getMerchantCategoryCode() {
            return merchantCategoryCode;
        }

        public void setMerchantCategoryCode(String merchantCategoryCode) {
            this.merchantCategoryCode = merchantCategoryCode;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
