package org.acme.infra.panache.models;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
@Table(name = "pix_qr_code")
public class PanachePixQrCode extends PanacheEntityBase {

    @Id
    public UUID id;

    @Column(nullable = false)
    public String pixKey;

    public BigDecimal amount;

    public String merchantPostalCode;
    public String merchantCity;
    public String merchantCategoryCode;
    public String merchantName;

    @JdbcTypeCode(SqlTypes.JSON)
    public List<String> tags;

    public String additionalInformation;
    public boolean withdrawal;
    public String withdrawalServiceProvider;

    public Long transactionId;
    public String transactionIdentification;

    @Column(columnDefinition = "text")
    public String emvqrcps;

    public static Optional<PanachePixQrCode> findByKeyAndAmount(String pixKey, BigDecimal amount) {
        if (amount == null) {
            return find("pixKey = ?1 and amount is null", pixKey).firstResultOptional();
        }
        return find("pixKey = ?1 and amount = ?2", pixKey, amount).firstResultOptional();
    }
}
