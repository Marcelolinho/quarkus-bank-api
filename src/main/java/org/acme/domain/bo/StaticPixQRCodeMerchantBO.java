package org.acme.domain.bo;

import org.acme.domain.exception.ApiException;

import io.netty.util.internal.StringUtil;

import java.util.*;
import java.util.stream.Stream;

public class StaticPixQRCodeMerchantBO {

    private UUID uuid;
    private String postalCode;
    private String city;
    private String merchantCategoryCode = "5651";
    private String name;

    public StaticPixQRCodeMerchantBO(String postalCode, String city, String merchantCategoryCode, String name) {
        this.uuid = UUID.randomUUID();
        this.postalCode = postalCode;
        this.city = city;
        this.merchantCategoryCode = merchantCategoryCode;
        this.name = name;

        validate();
    }

    public StaticPixQRCodeMerchantBO() {
    }

    private void validate() {
        Map<String, String> attributes = new HashMap<>();
        attributes.put("postalCode", this.postalCode);
        attributes.put("city", this.city);
        attributes.put("merchantCategoryCode", this.merchantCategoryCode);
        attributes.put("name", this.name);

        for (Map.Entry<String, String> obj : attributes.entrySet()) {
            if (StringUtil.isNullOrEmpty(obj.getValue())) {
                throw new ApiException(400, String.format("O campo %s não pode ser nulo ou vazio", obj.getKey()));
            }
        }
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
